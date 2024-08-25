import java.util.*;

public class Bouleau extends Arbre {
    // constructeur de la classe Bouleau
    public Bouleau(Ecosysteme ecosysteme) {
        super(ecosysteme); // constructeur de la classe parente
        this.setEmpoisonne(false); // le bouleau n'est pas empoisonné
        this.setVivant(true); // le bouleau est vivant
        this.setComestible(false); // le bouleau n'est pas comestible

        // définit au hasard le nb de graines et la durée de vie
        Random rand = new Random();
        int nbGraine = rand.nextInt((4-2) +1) + 2;  // nb de graines
        this.setNbGraines(nbGraine);
        int lifeSpan = rand.nextInt((8-4) +1) + 4;  // durée de vie
        this.setDureeVie(lifeSpan);

        // ajoute le bouleau à la liste des bouleaux
        this.getEcosysteme().getBouleauxDansEco().add(this);

        // ajoute le bouleau à l'écosystème
        this.getEcosysteme().ajouterVegetal(this);

    }
}
