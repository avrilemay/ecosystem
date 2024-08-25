import java.util.*;

public class Asperge extends Legume {
    // constructeur de la classe Asperge
    public Asperge(Ecosysteme ecosysteme) {
        super(ecosysteme); // appelle le constructeur de la classe parente
        this.setEmpoisonne(false); // l'asperge n'est pas empoisonnée
        this.setVivant(true); // l'asperge est vivante
        this.setComestible(true); // l'asperge est comestible
        Random rand = new Random();
        this.setNbGraines(rand.nextInt((8-4) +1) + 4); // nb de graines
        this.setDureeVie(rand.nextInt((12-6) +1) + 6); // durée de vie
        // ajoute l'asperge à la liste des asperges
        this.getEcosysteme().getAspergesDansEco().add(this);
        this.getEcosysteme().ajouterVegetal(this); // ajoute le végétal à l'écosystème

    }


}
