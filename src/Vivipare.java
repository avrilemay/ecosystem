import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Vivipare implements Reproduction {

    private Animal animal;

    // constructeur Vivipare
    public Vivipare(Animal animal) {
        this.animal = animal;
    }


    // getter et setter

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    // méthode pour se reproduire
    public void seReproduire() throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {

        // obtient l'animal à reproduire
        Animal animal = this.getAnimal();

        // exit si ce n'est pas une femelle en âge de se reproduire
        // qui a un éco et qui veut se reproduire
        if (!animal.isVivant()
                || animal.getEcosysteme() == null
                || animal.getAge() <= 1
                || !animal.souhaiteSeReproduire()
                || animal.getSexe() == Sexe.MALE) {
            return;
        }

        // si les conditions sont réunies
        if (animal.getReproduction() instanceof Vivipare) {
            // on obtient la liste des organismes
            List<Organisme> lstOrganismes = new ArrayList<>(animal.getEcosysteme().getOrganismesDansEco());
            // on mélange pour obtenir un ordre aléatoire
            Collections.shuffle(lstOrganismes);

            // initialise le père à null
            Animal pere = null;
            // parcourt les différents organismes
            for (Organisme organisme : lstOrganismes) {
                // cherche un père idéal
                if (organisme.getClass() == animal.getClass() // même espèce/classe
                        && ((Animal) organisme).getSexe() == Sexe.MALE// mâle
                        && ((Animal) organisme).isVivant() // vivant
                        && ((Animal) organisme).souhaiteSeReproduire() // veut se reproduire
                        && ((Animal) organisme).getAge() > 1 // mature
                        && organisme.getEcosysteme() != null // dans un eco
                        && organisme.getEcosysteme() == animal.getEcosysteme()) { // =

                    // assigne le père si le trouve
                    pere = (Animal) organisme;

                    // au début, il y a eu 0 petits
                    int nombrePetitsProduits = 0;
                    // le nombre de petits par portée est héritée de la mère
                    int nbPetitsSouhaites = animal.getNbPetits();

                    // tant que la femelle a eu moins de petits qu'elle ne peut en avoir
                    while (nombrePetitsProduits < nbPetitsSouhaites) {

                        // crée un bébé avec les caractéristiques des parents
                        animal.bebeDeReproduction(animal, pere);

                        // incrémente le nombre de petits produits
                        nombrePetitsProduits++;
                    }
                    // print pour suivre facilement l'évolution de l'éoc
                    System.out.println("L'animal femelle ID " + animal.getId() + " d'espèce "
                            + animal.getClass().getSimpleName() +
                            " s'est reproduite avec" +
                            " le mâle ID " + pere.getId() + " et a eu "
                            + nombrePetitsProduits + " petit(s).");

                    // un seul cycle de reproduction par appel de la fonction
                    break;
                }
            }
        }
    }

}


