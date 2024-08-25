import java.lang.reflect.InvocationTargetException;

public interface Reproduction {

    // méthode pour se reproduire
    void seReproduire() throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException;
}
