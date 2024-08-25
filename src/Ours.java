import java.util.*;

public class Ours extends Mammifere {

    // constructeur de la classe Ours
    public Ours(Ecosysteme ecosysteme) {
        super(ecosysteme, initialiseRegime()); // constructeur classe parente

        // mode de reproduction de l'ours: vivipare
        this.setReproduction(new Vivipare(this));

        // crée un objet Random
        Random rand = new Random();

        // définit aléatoirement attributs: vitesse, espérance vie, taille et poids
        this.setVitesse(rand.nextInt((12 - 10) + 1) + 10); // vitesse
        this.setEsperanceVie(rand.nextInt((9-7) + 1) + 7); // espérance de vie
        this.setTaille(rand.nextInt((160 - 60) + 1) + 60); // taille
        this.setPoids(rand.nextInt((800 - 400) + 1) + 400); // poids

        // si l'Ours est une femelle, définit aléatoirement le nb de petits par portée
        if (this.getSexe() == Sexe.FEMELLE) {
            this.setNbPetits(rand.nextInt((2 - 1) + 1) + 1); // nb petits
        }

        // ajoute l'ours à la liste des ours
        this.getEcosysteme().getOursDansEco().add(this);

        // ajoute l'ours à l'écosystème
        this.getEcosysteme().ajouterAnimal(this);
    }

    // initialise le régime alimentaire de l'ours
    private static Set<Regime> initialiseRegime() {
        Set<Regime> regimes = new HashSet<>();
        // l'ours est omnivore = herbivore + ovivore + carnivore
        regimes.add(new Herbivore());
        regimes.add(new Ovivore());
        regimes.add(new Carnivore());
        return regimes;
    }




}
