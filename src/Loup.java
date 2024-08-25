import java.util.*;

public class Loup extends Mammifere {

    // constructeur de la classe Loup
    public Loup(Ecosysteme ecosysteme) {
        super(ecosysteme, initialiseRegime()); // constructeur de la classe parente

        // mode de reproduction du loup: ovipare
        this.setReproduction(new Vivipare(this));

        // crée l'objet Random
        Random rand = new Random();

        // si le loup est une femelle
        if (this.getSexe() == Sexe.FEMELLE){
            // attribue aléatoirement le nb de petits par portée
            int cbBebes = rand.nextInt((2-1) + 1) + 1;  // nb petits aléatoires
            this.setNbPetits(cbBebes);
        }

        // définit aléatoirement: vitesse, espérance de vie, taille et poids
        this.setVitesse(rand.nextInt((15 - 10) +1) + 10);   // Vitesse
        this.setEsperanceVie(rand.nextInt((12-6)+1) + 6);// Espérance de vie aléatoire
        this.setTaille(rand.nextInt((90-60)+1) + 60); // Taille entre 60 et 90cm (max - min + 1) + min
        this.setPoids(rand.nextInt((80-23) + 1) + 23); // Poids entre 23 et 80kg


        // ajoute le loup à la liste des loups
        this.getEcosysteme().getLoupsDansEco().add(this);
        // ajoute le loup à l'écosystème
        this.getEcosysteme().ajouterAnimal(this);

    }


    // méthode pour initialiser le régime alimentaire du loup
    private static Set<Regime> initialiseRegime() {
        Set<Regime> regimes = new HashSet<>();
        // le loup est un carnivore
        regimes.add(new Carnivore());
        return regimes;
    }



}
