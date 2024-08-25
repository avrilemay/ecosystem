import java.util.*;

public class Menthe extends Herbe {

    // constructeur de la classe Menthe
    public Menthe(Ecosysteme ecosysteme) {
        super(ecosysteme); // constructeur de la classe parente
        this.setEmpoisonne(false); // la menthe n'est pas empoisonnée
        this.setVivant(true); // la menthe est vivante
        this.setComestible(true); // la menthe est comestible

        // définit aléatoirement le nombre de graines et la durée de vue
        Random rand = new Random();
        this.setNbGraines(rand.nextInt((8-4) +1) + 4); // nb de graines
        this.setDureeVie(rand.nextInt((12-6) +1) + 6); // durée de vie

        // ajoute la menthe à la liste des menthes
        this.getEcosysteme().getMenthesDansEco().add(this);

        // ajoute le végétal à l'écosystème
        this.getEcosysteme().ajouterVegetal(this);
    }

}
