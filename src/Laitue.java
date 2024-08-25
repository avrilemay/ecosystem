import java.util.*;

public class Laitue extends Legume {
    // constructeur de la classe Laitue
    public Laitue(Ecosysteme ecosysteme) {
        super(ecosysteme); // constructeur de la classe parente
        this.setEmpoisonne(false); // la laitue n'est pas empoisonnée
        this.setVivant(true); // la laitue est vivante
        this.setComestible(true); // la laitue est comestible

        // définit aléatoire le nb de graines et la durée de vie
        Random rand = new Random();
        this.setNbGraines(rand.nextInt((8-4) +1) + 4); // nb de graines
        this.setDureeVie(rand.nextInt((12-6) +1) + 6); // durée de vie

        // ajoute la laitue à la liste des laitue
        this.getEcosysteme().getLaituesDansEco().add(this);
        this.getEcosysteme().ajouterVegetal(this); // ajoute le végétal à l'écosystème

    }

}
