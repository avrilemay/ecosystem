import java.util.*;

public class Biche extends Mammifere {
    // constructeur de la classe Biche
    public Biche(Ecosysteme ecosysteme) {
        super(ecosysteme, initialiseRegime()); // appelle le constructeur de la classe parente

        // mode de reproduction: la biche est un vivipare
        this.setReproduction(new Vivipare(this));

        if (this.getSexe() == Sexe.FEMELLE) {
            // la biche est une femelle, on lui attribue au hasard
            Random rand = new Random();
            // un nb de petits par portée
            int cbBebes = rand.nextInt((2 - 1) + 1) + 1;
            this.setNbPetits(cbBebes);
        }

        Random rand = new Random();
        // on attribue aléatoirement: taille, poids, vitesse, espérance de vie
        this.setEsperanceVie(rand.nextInt((12 - 6) + 1) + 6);
        this.setVitesse(rand.nextInt((17 - 10) + 1) + 10);
        this.setTaille(rand.nextInt((150 - 110) + 1) + 110);
        this.setPoids(rand.nextInt((200 - 90) + 1) + 90);

        // ajoute la biche à la liste des biches
        this.getEcosysteme().getBichesDansEco().add(this);
        // on ajoute la biche à l'écosystème
        this.getEcosysteme().ajouterAnimal(this);
    }

    // initialise le régime alimentaire de la biche: herbivore
    private static Set<Regime> initialiseRegime() {
        Set<Regime> regimes = new HashSet<>();
        // la biche est un herbivore
        regimes.add(new Herbivore());
        return regimes;
    }




}
