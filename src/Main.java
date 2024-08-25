import java.lang.reflect.InvocationTargetException;
import java.util.*;
import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException,
            InterruptedException {

        // création d'un éco "forêt tempérée"
        Ecosysteme eco = new Ecosysteme("foretTemperee");

        // création d'un objet Random
        Random rand = new Random();

        // les asperges
        for (int i = 0; i < rand.nextInt((8-5) + 1) + 5; i++) {
            new Asperge(eco);
        }

        // les biches
        for (int i = 0; i < rand.nextInt((8-5) + 1) + 5; i++) {
            new Biche(eco);
        }

        // les bouleaux
        for (int i = 0; i < rand.nextInt((8-5) + 1) + 5; i++) {
            new Bouleau(eco);
        }

        // les corbeaux
        for (int i = 0; i < rand.nextInt((8-5) + 1) + 5; i++) {
            new Corbeau(eco);
        }

        // les laitues
        for (int i = 0; i < rand.nextInt((8-5) + 1) + 5; i++) {
            new Laitue(eco);
        }

        // les loups
        for (int i = 0; i < rand.nextInt((8-5) + 1) + 5; i++) {
            new Loup(eco);
        }

        // les menthes
        for (int i = 0; i < rand.nextInt((8-5) + 1) + 5; i++) {
            new Menthe(eco);
        }

        // les ours
        for (int i = 0; i < rand.nextInt((8-5) + 1) + 5; i++) {
            new Ours(eco);
        }

        // les rhubarbes
        for (int i = 0; i < rand.nextInt((8-5) + 1) + 5; i++) {
            new Rhubarbe(eco);
        }

        // les tortues
        for (int i = 0; i < rand.nextInt((8-5) + 1) + 5; i++) {
           new Tortue(eco);
        }

        // on simule l'écosystème pour un nombre de jours aléatoire
        for (int jour = 0; jour < rand.nextInt((20 - 15) + 1) + 15; jour++) {

            // print pour suivre le passage du temps
            System.out.println("\n\nLe jour " + jour);

            // simulation du temps qui passe
            eco.passageTemps();

            // sleep pour observer les modifications de l'écosystème
            sleep(10000);

        }

    }
}