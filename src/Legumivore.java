public class Legumivore extends Herbivore {

    public Legumivore() {} // constructeur

    public String toString() { // méthode pour obtenir au format str
        return "Légumivore";
    }

    @Override
    // méthode pour définir si un légumivore peut manger un organisme
    public boolean peutManger(Organisme organisme) {
        // renvoie vrai si c'est un légume vivant, comestible, avec un éco
        if (organisme instanceof Legume) {
            Legume legume = (Legume) organisme;
            return (legume.isVivant()   // le légume doit être vivant
                    && legume.isComestible()  // le légume doit être comestible
                    && legume.getEcosysteme() != null); // avec un éco
        }
        return false; // sinon faux
    }
}
