
public class Carnivore implements Regime {

    public Carnivore() {} // constructeur de la classe Carnivore

    public String toString() { // méthode pour obtenir au format str
        return "Carnivore";
    }

    // méthode pour définir si un carnivore peut manger un organisme
    public boolean peutManger(Organisme organisme) {
        // renvoie vrai si l'animal peut être mangé
        if (organisme instanceof Animal) {
            // un carnivore peut manger un animal vivant
            // qui est herbivore OU carnivore
            // qui appartient à un écosystème
            Animal animal = (Animal) organisme;
            return (animal.isVivant()
                    && (animal.suitRegime(Carnivore.class) || animal.suitRegime(Herbivore.class) )
                    && animal.getEcosysteme() != null);
        }
        return false; // sinon faux
    }


}

