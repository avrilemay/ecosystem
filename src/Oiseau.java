import java.util.*;

public abstract class Oiseau extends Animal {

    // constructeur de la classe Oiseau
    public Oiseau(Ecosysteme ecosysteme, Set<Regime> regimes) {
        super(ecosysteme, regimes); // constructeur classe parente
    }
}
