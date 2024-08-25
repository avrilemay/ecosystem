import java.util.*;

public abstract class Mammifere extends Animal {

    // constructeur Mammifere
    public Mammifere(Ecosysteme ecosysteme, Set<Regime> regimes) {
        super(ecosysteme, regimes); // constructeur classe parente
    }

}
