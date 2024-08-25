import java.util.*;

public class Corbeau extends Oiseau {

    public Corbeau(Ecosysteme ecosysteme) { // constructeur de la classe Corbeau
        super(ecosysteme, initialiseRegime()); // constructeur de la classe parente

        this.setReproduction(new Ovipare(this));
        // mode de reproduction: le corbeau est un ovipare

        // attribue aléatoirement les attributs vitesse, espérance vie, taille, poids, nbPetits
        Random rand = new Random();
        this.setVitesse(rand.nextInt((15 - 10) + 1) + 10);
        this.setEsperanceVie(rand.nextInt((12-6) + 1) + 6);
        this.setTaille(rand.nextInt((78-58)+1) + 58);
        this.setPoids(rand.nextInt((3-1) + 1) + 1);

        int cbBebes = rand.nextInt((2-1) + 1) + 1;
        // nb d'oeufs pour les femelles ou à fertiliser pour les mâles
        this.setNbPetits(cbBebes);

        // ajoute le corbeau à la liste des corbeaux
        this.getEcosysteme().getCorbeauxDansEco().add(this);

        // ajoute l'animal à l'écosystème
        this.getEcosysteme().ajouterAnimal(this);
    }



    // définit le régime alimentaire du corbeau
    private static Set<Regime> initialiseRegime() {
        Set<Regime> regimes = new HashSet<>();
        // le corbeau est un charognard
        regimes.add(new Charognard());
        return regimes;
    }







}
