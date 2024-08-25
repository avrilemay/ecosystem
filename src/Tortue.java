import java.util.*;


public class Tortue extends Reptile {

    // constructeur de la classe Tortue
    public Tortue(Ecosysteme ecosysteme) {

        super(ecosysteme, initialiseRegime()); // constructeur classe parente

        // mode de reproduction de la tortue: ovipare
        this.setReproduction(new Ovipare(this));

        // nouvel objet Random
        Random rand = new Random();

        // si femelle = nb d'oeufs à pondre et si mâle = nb d'oeufs à féconder
        this.setNbPetits(rand.nextInt((2-1) + 1) + 1); // nb d'oeufs

        // définit de façon aléatoire: vitesse, espérance de vie, taille, poids
        this.setVitesse(rand.nextInt((17 - 10) + 1) + 10); // vitesse
        this.setEsperanceVie(rand.nextInt((12-6) + 1) + 6); // espérance de vie
        this.setTaille(rand.nextInt((35 - 20) + 1) + 20); // taille
        this.setPoids(rand.nextInt((2 - 1) + 1) + 1); // poids

        // ajoute la tortue à la liste des tortues
        this.getEcosysteme().getTortuesDansEco().add(this);

        // ajoute l'animal à l'écosystème
        this.getEcosysteme().ajouterAnimal(this);
    }


    // initialise le régime alimentaire de la tortue
    private static Set<Regime> initialiseRegime() {
        Set<Regime> regimes = new HashSet<>();
        // la tortue est un légumivore
        regimes.add(new Legumivore());
        return regimes;
    }

}


