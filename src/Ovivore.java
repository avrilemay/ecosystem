public class Ovivore implements Regime {

    public Ovivore() {} // constructeur Ovivore

    public String toString() { // méthode pour obtenir au format str
        return "Ovivore";
    }

    // méthode pour vérifier si un ovivore peut manger un organisme
    public boolean peutManger(Organisme organisme) {
        if (organisme instanceof Oeuf){
            // renvoie vrai si c'est un oeuf qui appartient à un éco
            Oeuf oeuf = (Oeuf) organisme;
            return oeuf.getEcosysteme() != null;
        } // sinon faux
        return false;
    }
}


