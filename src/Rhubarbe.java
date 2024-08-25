import java.util.*;

public class Rhubarbe extends Legume {
    // constructeur de la classe Rhubarbe
    public Rhubarbe(Ecosysteme ecosysteme) {

        super(ecosysteme); // constructeur de la classe parente

        // nouvel objet Random
        Random rand = new Random();

        // définit les attributs de la rhubarbe
        this.setEmpoisonne(true); // la rhubarbe est empoisonnée
        this.setVivant(true); // la rhubarbe est vivante
        this.setComestible(true); // la rhubarbe est comestible

        // définit de façon aléatoire le nb de graines et la durée de vie
        this.setNbGraines(rand.nextInt((8-4) +1) + 4); // nb de graines
        this.setDureeVie(rand.nextInt((12-6) +1) + 6); // durée de vie

        // ajoute la rhubarbe à la liste des rhubarbes
        this.getEcosysteme().getRhubarbesDansEco().add(this);

        // ajoute le végétal à l'écosystème
        this.getEcosysteme().ajouterVegetal(this);
    }

}
