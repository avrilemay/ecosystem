import java.util.*;

public class Ovipare implements Reproduction {

    private Animal animal;

    // constructeur classe Ovipare
    public Ovipare(Animal animal) {
        this.animal = animal;
    }

    // getter & setter

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }


    // méthode pour la reproduction des ovipares
    public void seReproduire() {

        // obtient l'animal qui se reproduit
        Animal animal = this.getAnimal();

        // si l'animal ne remplit pas les conditions de reproduction
        if (animal == null // n'existe pas
                || animal.getAge() <= 1 // trop jeune
                || animal.getEcosysteme() == null // sans éco
                || !animal.souhaiteSeReproduire() // ne veut pas se reproduire
                || !animal.isVivant()) { // est mort
            return; // sort
        }

        // si c'est une femelle ovipare
        if (animal.getSexe() == Sexe.FEMELLE) {
            // elle va pondre autant d'oeufs que sa génétique lui permet par portée
            int nbOeufsProduits = 0;
            int nbOeufsSouhaites = animal.getNbPetits();
            while (nbOeufsProduits < nbOeufsSouhaites) {

                // crée une nouvelle instance de l'oeuf
                new Oeuf(animal.getEcosysteme(), animal.getId(), animal.getClass());
                nbOeufsProduits++;
            }

            // print pour suivre facilement l'évolution dans l'écosystème
            System.out.println(nbOeufsProduits + " oeuf(s) de " +
                    animal.getClass().getSimpleName() + " ont été pondus.");

        }

        // si c'est un ovipare mâle
        if (animal.getSexe() == Sexe.MALE) {
            // récupère le nb d'oeufs que le mâle peut fertiliser
            int nbOeufsFertilisables = animal.getNbPetits();
            // met le compteur à 0
            int oeufsFertilises = 0;

            // liste tous les oeufs de l'écosystème
            Set<Oeuf> oeufsEco = new HashSet<>(animal.getEcosysteme().getOeufsDansEco());

            // parcourt les oeufs pour les fertiliser d'après les dispos génétiques
            for (Oeuf oeufy : oeufsEco) {

                // si l'oeuf remplit les conditions pour être fertilisé
                if (!oeufy.isFertilise() // n'est pas fertilisé
                        && oeufy.getAge() < 3 // moins de 3 j
                        && oeufy.getEspece().getSimpleName().equals(animal.getClass().getSimpleName())
                        // appartient à la même espèce que le mâle
                        && oeufy.getEcosysteme() != null // a un éco
                        && oeufy.getEcosysteme() == animal.getEcosysteme())
                        // appartiennent au même éco
                {
                    // print pour suivre l'évolution de l'éco
                    System.out.println("L'oeuf de " + animal.getClass().getSimpleName() +
                            " d'ID " + oeufy.getId() + " a été fertilisé " +
                            "par l'animal d'espèce " + animal.getClass().getSimpleName() +
                            " et d'ID " + animal.getId());

                    // fertilise l'oeuf
                    oeufy.estFertilise(animal);
                    // met à jour le nombre d'oeufs fertilisés
                    oeufsFertilises++;

                    // arrête si le nombre désiré d'oeufs a été fertilisé
                    if (oeufsFertilises >= nbOeufsFertilisables) {
                        break;
                    }
                }
            }
        }
    }
}


