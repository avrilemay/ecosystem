public class Charognard extends Carnivore {

    public Charognard() {} // constructeur de la classe Charognard

    // méthode pour obtenir au format str
    @Override
    public String toString() {
        return "Charognard";
    }

    // méthode pour définir si un charognard peut manger un organisme
    @Override
    public boolean peutManger(Organisme organisme) {
        // renvoie vrai si le charognard peut manger l'organisme
        if (organisme instanceof Animal) {
            Animal animal = (Animal) organisme;
            // l'animal doit être mort et appartenir à un écosystème
            return !animal.isVivant()
                    && animal.getEcosysteme() != null;
        }
        return false; // sinon faux
    }
}