public class Herbivore implements Regime {

        public Herbivore() {} // constructeur de la classe

        public String toString() { // méthode pour obtenir au format str
                return "Herbivore";
        }

        // méthode pour définir si un herbivore peut manger un organisme
        public boolean peutManger(Organisme organisme) {
                // renvoie true si c'est un végétal, vivant, comestible et qui a un éco
                if (organisme instanceof Vegetal) {
                        Vegetal vegetal = (Vegetal) organisme;
                        return (vegetal.isVivant() // le végétal doit être vivant
                                && vegetal.isComestible() // comestible
                                && vegetal.getEcosysteme() != null);
                }
                return false; // sinon faux
        }
}
