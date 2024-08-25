import java.util.*;

public abstract class Reptile extends Animal {

    // constructeur de la classe Reptile
    public Reptile(Ecosysteme ecosysteme, Set<Regime> regimes) {
        super(ecosysteme, regimes); // constructeur classe parente
    }
}
