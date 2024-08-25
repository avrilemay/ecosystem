import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.BeforeEach;

import java.lang.reflect.InvocationTargetException;

// Définition de la classe de test avec des méthodes ordonnées
@TestMethodOrder(OrderAnnotation.class)
public class TestProjet {

    // initialisation des variables pour les tests
    private Ecosysteme foretTemperee;
    private Asperge asperge1;
    private Asperge asperge2;
    private Biche biche1;
    private Biche biche2;
    private Biche biche3;
    private Bouleau bouleau1;
    private Bouleau bouleau2;
    private Corbeau corbeau1;
    private Corbeau corbeau2;
    private Corbeau corbeau3;
    private Laitue laitue1;
    private Laitue laitue2;
    private Loup loup1;
    private Loup loup2;
    private Loup loup3;
    private Menthe menthe1;
    private Menthe menthe2;
    private Ours ours1;
    private Ours ours2;
    private Ours ours3;
    private Rhubarbe rhubarbe1;
    private Rhubarbe rhubarbe2;
    private Tortue tortue1;
    private Tortue tortue2;


    // méthode pour initialiser les données avant chaque test
    @BeforeEach
    public void init() {

        // création des instances d'animaux et de végétaux avant chaque test
        foretTemperee = new Ecosysteme("foretTemperee");

        // initialisation des animaux et des végétaux pour la forêtTempérée
        asperge1 = new Asperge(foretTemperee);
        asperge2 = new Asperge(foretTemperee);
        biche1 = new Biche(foretTemperee);
        biche2 = new Biche(foretTemperee);
        biche3 = new Biche(foretTemperee);
        bouleau1 = new Bouleau(foretTemperee);
        bouleau2 = new Bouleau(foretTemperee);
        corbeau1 = new Corbeau(foretTemperee);
        corbeau2 = new Corbeau(foretTemperee);
        corbeau3 = new Corbeau(foretTemperee);
        laitue1 = new Laitue(foretTemperee);
        laitue2 = new Laitue(foretTemperee);
        loup1 = new Loup(foretTemperee);
        loup2 = new Loup(foretTemperee);
        loup3 = new Loup(foretTemperee);
        menthe1 = new Menthe(foretTemperee);
        menthe2 = new Menthe(foretTemperee);
        ours1 = new Ours(foretTemperee);
        ours2 = new Ours(foretTemperee);
        ours3 = new Ours(foretTemperee);
        rhubarbe1 = new Rhubarbe(foretTemperee);
        rhubarbe2 = new Rhubarbe(foretTemperee);
        tortue1 = new Tortue(foretTemperee);
        tortue2 = new Tortue(foretTemperee);
    }


    // test 1 - Une asperge se reproduit (normal)
    @Test
    @Order(1)
    public void testAspergeSeReproduit() throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        System.out.println("\nTest 1 - Une asperge se reproduit (normal)\n");
        System.out.println("Les caractéristiques de l'asperge1 :" + asperge1 + "\n");
        System.out.println("Nombre d'asperges dans l'écosystème :" +
                foretTemperee.getAspergesDansEco().size() + "\n");

        int nbAsperges = foretTemperee.getAspergesDansEco().size();
        System.out.println("Appel de la méthode seReproduire() \n");
        while (nbAsperges == foretTemperee.getAspergesDansEco().size()) {
            asperge1.seReproduire();
        }

        System.out.println("Nombre d'asperges dans l'écosystème :" +
                foretTemperee.getAspergesDansEco().size() + "\n");

        System.out.println("Liste des asperges dans l'écosystème:");
        for (Asperge asperge : foretTemperee.getAspergesDansEco()) {
            System.out.println(asperge);
        }
        System.out.println("\n\n\n\n");
    }

    // test 2 - Une asperge meurt (normal)
    @Test
    @Order(2)
    public void testAspergeMeurt() {
        System.out.println("\nTest 2 - Une asperge meurt de vieillesse (normal)\n");
        asperge2.setDureeVie(1);
        System.out.println("Les caractéristiques de l'asperge2 : " + asperge2 + "\n");
        System.out.println("Nombre d'asperges dans l'écosystème : " +
                foretTemperee.getAspergesDansEco().size() + "\n");
        System.out.println("Appel de la méthode vieillir() \n");
        asperge2.vieillir();

        System.out.println("Nombre d'asperges dans l'écosystème : " +
                foretTemperee.getAspergesDansEco().size() + "\n");

        System.out.println("\n\n\n");
    }


    // test 3 - Une asperge vit un jour (normal)
    @Test
    @Order(3)
    public void testAspergeVitJour() throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        System.out.println("\nTest 3 - Une asperge vit un jour (normal)\n");
        System.out.println("Les caractéristiques de l'asperge2 : " + asperge2 + "\n");
        System.out.println("Appel de la méthode vivreUnJour() \n");
        asperge2.vivreUnJour();

        System.out.println("Les caractéristiques de l'asperge2 : " + asperge2 + "\n");
        System.out.println("\n\n\n");
    }


    // test 4 - Une biche mange (normal)
    @Test
    @Order(4)
    public void testBicheMange() {
        System.out.println("\nTest 4 - Une biche mange (normal)\n");

        biche1.setFaim(5);

        System.out.println("Les caractéristiques de la biche1 :" + biche1 + "\n");
        System.out.println("Nombre de végétaux dans l'écosystème :" +
                foretTemperee.getVegetauxDansEco().size() + "\n");

        System.out.println("Appel de la méthode manger() \n");
        while (biche1.getFaim() < 10) {
            biche1.manger();
        }

        System.out.println("Nombre de végétaux dans l'écosystème :" +
                foretTemperee.getVegetauxDansEco().size() + "\n");

        System.out.println("Les caractéristiques de la biche1 :" + biche1 + "\n");
        System.out.println("\n\n\n");
    }


    // test 5 - Une biche se reproduit (normal)
    @Test
    @Order(5)
    public void testBicheSeReproduit() throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        System.out.println("\nTest 5 - Une biche se reproduit (normal)\n");
        biche1.setSexe(Sexe.FEMELLE);
        biche1.setNbPetits(1);
        biche1.setAge(2);
        biche2.setSexe(Sexe.MALE);
        biche2.setAge(2);
        biche2.setNbPetits(null);
        System.out.println("Les caractéristiques de la biche1 :" + biche1 + "\n");
        System.out.println("Les caractéristiques de la biche2 :" + biche2 + "\n");
        System.out.println("Nombre de biches dans l'écosystème :" +
                foretTemperee.getBichesDansEco().size() + "\n");

        System.out.println("Appel de la méthode seReproduire() \n");
        int nbBiches = foretTemperee.getBichesDansEco().size();
        while (nbBiches == foretTemperee.getBichesDansEco().size()) {
            biche1.getReproduction().seReproduire();
        }

        System.out.println("Nombre de biches dans l'écosystème :" +
                foretTemperee.getBichesDansEco().size() + "\n");

        System.out.println("Liste des biches dans l'écosystème:");
        for (Biche biche : foretTemperee.getBichesDansEco()) {
            System.out.println(biche);
        }
        System.out.println("\n\n\n\n");

    }


    // test 6 - Une biche vit un jour (normal)
    @Test
    @Order(6)
    public void testBicheVitJour() throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        System.out.println("\nTest 6 - Une biche vit un jour (normal)\n");
        System.out.println("Les caractéristiques de la biche3 : " + biche3 + "\n");
        System.out.println("Appel de la méthode vivreUnJour() \n");
        biche3.vivreUnJour();

        System.out.println("Les caractéristiques de la biche3 : " + biche3 + "\n");
        System.out.println("\n\n\n");
    }


    // test 7 - Une biche meurt de vieillesse (normal)
    @Test
    @Order(7)
    public void testBicheMeurt() {
        System.out.println("\nTest 7 - Une biche meurt de vieillesse (normal)\n");
        biche3.setAge(10);
        biche3.setEsperanceVie(0);
        System.out.println("Nombre de biches dans l'écosystème :" +
                foretTemperee.getBichesDansEco().size() + "\n");
        System.out.println("Les caractéristiques de la biche3 : " + biche3 + "\n");
        System.out.println("Appel de la méthode vieillir() \n");
        biche3.vieillir();

        System.out.println("Les caractéristiques de la biche3 : " + biche3 + "\n");
        System.out.println("\n\n\n");
    }


    // test 8 - Un bouleau se reproduit (normal)
    @Test
    @Order(8)
    public void testBouleauSeReproduit() throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        System.out.println("\nTest 8 - Un bouleau se reproduit (normal)\n");
        System.out.println("Les caractéristiques du bouleau1 :" + bouleau1 + "\n");
        System.out.println("Nombre de bouleaux dans l'écosystème :" +
                foretTemperee.getBouleauxDansEco().size() + "\n");

        int nbBouleaux = foretTemperee.getBouleauxDansEco().size();
        System.out.println("Appel de la méthode seReproduire() \n");
        while (nbBouleaux == foretTemperee.getBouleauxDansEco().size()) {
            bouleau1.seReproduire();
        }

        System.out.println("Nombre de bouleaux dans l'écosystème :" +
                foretTemperee.getBouleauxDansEco().size() + "\n");

        System.out.println("Liste des bouleaux dans l'écosystème:");
        for (Bouleau bouleau : foretTemperee.getBouleauxDansEco()) {
            System.out.println(bouleau);
        }
        System.out.println("\n\n\n\n");
    }

    // test 9 - Un bouleau meurt (normal)
    @Test
    @Order(9)
    public void testBouleauMeurt() {
        System.out.println("\nTest 9 - Un bouleau meurt de vieillesse (normal)\n");
        bouleau1.setDureeVie(1);
        System.out.println("Les caractéristiques du bouleau1 : " + bouleau1 + "\n");
        System.out.println("Nombre de bouleaux dans l'écosystème : " +
                foretTemperee.getBouleauxDansEco().size() + "\n");
        System.out.println("Appel de la méthode vieillir() \n");
        bouleau1.vieillir();

        System.out.println("Nombre de bouleaux dans l'écosystème : " +
                foretTemperee.getBouleauxDansEco().size() + "\n");
        System.out.println("\n\n\n");
    }


    // test 10 - Un bouleau vit un jour (normal)
    @Test
    @Order(10)
    public void testBouleauVitJour() throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        System.out.println("\nTest 10 - Un bouleau vit un jour (normal)\n");
        System.out.println("Les caractéristiques du bouleau2 : " + bouleau2 + "\n");
        System.out.println("Appel de la méthode vivreUnJour() \n");
        bouleau2.vivreUnJour();

        System.out.println("Les caractéristiques du bouleau2 : " + bouleau2 + "\n");
        System.out.println("\n\n\n");
    }


    // test 11 - Un corbeau mange (normal)
    @Test
    @Order(11)
    public void testCorbeauMange() {
        System.out.println("\nTest 11 - Un corbeau mange (normal)\n");
        corbeau1.setFaim(5);
        System.out.println("Les caractéristiques du corbeau1 :" + corbeau1 + "\n");
        biche1.mourrir();
        System.out.println("Les caractéristiques de la biche1 :" + biche1 + "\n");
        System.out.println("Appel de la méthode manger() \n");
        corbeau1.manger();
        System.out.println("Les caractéristiques du corbeau1 après avoir mangé :" + corbeau1 + "\n");
        System.out.println("\n\n\n");

    }


    // test 12 - Un corbeau mange un animal empoisonné et meurt (normal)
    @Test
    @Order(12)
    public void testCorbeauEmpoisonneMeurt() {
        System.out.println("\nTest 12 - Un corbeau mange un animal empoisonné et meurt (normal)\n");
        corbeau1.setFaim(5);
        System.out.println("Nombre de corbeaux dans l'écosystème: " + foretTemperee.getCorbeauxDansEco().size());
        System.out.println("Les caractéristiques du corbeau1 :" + corbeau1 + "\n");
        biche1.setEmpoisonne(true);
        biche1.setPoisonDepuis(2);
        biche1.mourrir();
        System.out.println("Les caractéristiques de la biche1 :" + biche1 + "\n");
        System.out.println("Appel de la méthode manger() \n");
        corbeau1.manger();
        System.out.println("Les caractéristiques du corbeau1 après avoir mangé :" + corbeau1 + "\n");

        System.out.println("Appel de la méthode vieillir() quatre fois \n");
        corbeau1.vieillir();
        corbeau1.vieillir();
        corbeau1.vieillir();
        corbeau1.vieillir();

        System.out.println("Les caractéristiques du corbeau1:" + corbeau1 + "\n");
        System.out.println("\n\n\n");
    }

    // test 13 - Un corbeau pond un oeuf (normal)
    @Test
    @Order(13)
    public void testCorbeauPondOeuf() throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        System.out.println("\nTest 13 - Un corbeau pond un oeuf (normal)\n");
        corbeau1.setSexe(Sexe.FEMELLE);
        corbeau1.setAge(2);
        System.out.println("Les caractéristiques du corbeau1 :" + corbeau1 + "\n");

        int nbOeufsEco = foretTemperee.getOeufsDansEco().size();
        System.out.println("Nombre d'oeufs dans l'écosystème :" +
                nbOeufsEco + "\n");

        System.out.println("Appel de la méthode pondreOeuf() \n");
        while (nbOeufsEco == foretTemperee.getOeufsDansEco().size()) {
            corbeau1.getReproduction().seReproduire();
        }

        System.out.println("Nombre d'oeufs dans l'écosystème :" +
                foretTemperee.getOeufsDansEco().size() + "\n");

        System.out.println("Liste des oeufs dans l'écosystème:");
        for (Oeuf oeuf : foretTemperee.getOeufsDansEco()) {
            System.out.println(oeuf);
        }
        System.out.println("\n\n\n\n");
    }


    // test 14 - Un corbeau fertilise un oeuf (normal)
    @Test
    @Order(14)
    public void testCorbeauFertiliseOeuf() throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        System.out.println("\nTest 14 - Un corbeau fertilise un oeuf (normal)\n");

        corbeau1.setSexe(Sexe.FEMELLE);
        corbeau1.setAge(2);
        corbeau1.setNbPetits(1);
        int nbOeufsEco = foretTemperee.getOeufsDansEco().size();
        while (nbOeufsEco == foretTemperee.getOeufsDansEco().size()) {
            corbeau1.getReproduction().seReproduire();
        }

        System.out.println("Nombre d'oeufs dans l'écosystème :" +
                foretTemperee.getOeufsDansEco().size() + "\n");


        corbeau2.setSexe(Sexe.MALE);
        corbeau2.setAge(2);
        corbeau2.setNbPetits(1);

        Oeuf oeufExemple = null;

        System.out.println("Liste des oeufs dans l'écosystème:");
        for (Oeuf oeuf : foretTemperee.getOeufsDansEco()) {
            System.out.println(oeuf);
            oeufExemple = oeuf;

        }

        assert oeufExemple != null;
        while (!(oeufExemple.isFertilise())) {
            corbeau2.getReproduction().seReproduire();
        }

        System.out.println("Liste des oeufs dans l'écosystème:");
        for (Oeuf oeuf : foretTemperee.getOeufsDansEco()) {
            System.out.println(oeuf);
        }
        System.out.println("\n\n\n\n");

    }


    // test 15 - Un oeuf de corbeau éclot (normal)
    @Test
    @Order(15)
    public void testOeufCorbeauEclot() throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        System.out.println("\nTest 15 - Un oeuf de corbeau éclot (normal)\n");

        corbeau1.setSexe(Sexe.FEMELLE);
        corbeau1.setAge(2);
        corbeau1.setNbPetits(1);
        int nbOeufsEco = foretTemperee.getOeufsDansEco().size();
        while (nbOeufsEco == foretTemperee.getOeufsDansEco().size()) {
            corbeau1.getReproduction().seReproduire();
        }

        System.out.println("Nombre d'oeufs dans l'écosystème :" +
                foretTemperee.getOeufsDansEco().size() + "\n");
        System.out.println("Nombre de corbeaux dans l'écosystème :" +
                foretTemperee.getCorbeauxDansEco().size() + "\n");


        corbeau2.setSexe(Sexe.MALE);
        corbeau2.setAge(2);
        corbeau2.setNbPetits(1);

        Oeuf oeufExemple = null;

        for (Oeuf oeuf : foretTemperee.getOeufsDansEco()) {
            oeufExemple = oeuf;

        }

        assert oeufExemple != null;
        while (!(oeufExemple.isFertilise())) {
            corbeau2.getReproduction().seReproduire();
        }

        System.out.println("Appel de la fonction vieillir:");

        while (oeufExemple.getEcosysteme() != null) {
            oeufExemple.vivreUnJour();
        }

        System.out.println("Nombre d'oeufs dans l'écosystème :" +
                foretTemperee.getOeufsDansEco().size() + "\n");
        System.out.println("Nombre de corbeaux dans l'écosystème :" +
                foretTemperee.getCorbeauxDansEco().size() + "\n");


        System.out.println("Liste des corbeaux dans l'écosystème:");
        for (Corbeau corbeau : foretTemperee.getCorbeauxDansEco()) {
            System.out.println(corbeau);
        }
        System.out.println("\n\n\n\n");
    }


    // test 16 - Un corbeau vit un jour (normal)
    @Test
    @Order(16)
    public void testCorbeauVitUnJour() throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        System.out.println("\nTest 16 - Un corbeau vit un jour \n");

        System.out.println("Caractéristiques du corbeau1: " + corbeau1 + "\n");
        System.out.println("Appel de la méthode vivreUnJour() \n");
        corbeau1.vivreUnJour();
        System.out.println("Caractéristiques du corbeau1: " + corbeau1 + "\n");
        System.out.println("\n\n\n");

    }



    // test 17 - Afficher les espèces de l'écosystème (normal)
    @Test
    @Order(17)
    public void testAfficherEspeceEco() {
        System.out.println("\nTest 17 - Afficher les espèces de l'écosystème (normal) \n");
        System.out.println("Les espèces de l'écosystème sont: ");
        foretTemperee.afficherEspece();
        System.out.println("\n\n\n\n");
    }


    // test 18 - Afficher le nombre d'individus des espèces de l'écosystème (normal)
    @Test
    @Order(18)
    public void testAfficherCompteEco() {
        System.out.println("\nTest 18 - Afficher le nombre de spéciments des différentes" +
                " espèces (normal) \n");
        foretTemperee.afficherCompteAnimauxVegetaux();
        System.out.println("\n\n\n\n");
    }

    // test 19 - Supprimer une espèce de l'écosystème (normal)
    @Test
    @Order(19)
    public void supprimerEspeceEco() {

        System.out.println("\nTest 19 - Supprimer une espèce de l'écosystème " +
                "(normal) \n");

        System.out.println("Nombre de corbeaux dans l'écosystème :" +
                foretTemperee.getCorbeauxDansEco().size() + "\n");

        System.out.println("Appel de la méthode supprimerEspece() \n");
        foretTemperee.supprimerEspece(Corbeau.class);

        System.out.println("Nombre de corbeaux dans l'écosystème :" +
                foretTemperee.getCorbeauxDansEco().size() + "\n");

        System.out.println("Nombre de rhubarbes dans l'écosystème :" +
                foretTemperee.getRhubarbesDansEco().size() + "\n");

        System.out.println("Appel de la méthode supprimerEspece() \n");
        foretTemperee.supprimerEspece(Rhubarbe.class);

        System.out.println("Nombre de rhubarbes dans l'écosystème :" +
                foretTemperee.getRhubarbesDansEco().size() + "\n");

        System.out.println("\n\n\n");
    }


    // test 20 - Une laitue se reproduit (normal)
    @Test
    @Order(20)
    public void testLaitueSeReproduit() throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        System.out.println("\nTest 20 - Une laitue se reproduit (normal)\n");
        System.out.println("Les caractéristiques de la laitue1 :" + laitue1 + "\n");
        System.out.println("Nombre de laitues dans l'écosystème :" +
                foretTemperee.getLaituesDansEco().size() + "\n");

        int nbLaitues = foretTemperee.getLaituesDansEco().size();
        System.out.println("Appel de la méthode seReproduire() \n");
        while (nbLaitues == foretTemperee.getLaituesDansEco().size()) {
            laitue1.seReproduire();
        }

        System.out.println("Nombre de laitues dans l'écosystème :" +
                foretTemperee.getLaituesDansEco().size() + "\n");

        System.out.println("Liste des laitues dans l'écosystème:");
        for (Laitue laitue : foretTemperee.getLaituesDansEco()) {
            System.out.println(laitue);
        }
        System.out.println("\n\n\n\n");
    }

    // test 21 - Une laitue meurt (normal)
    @Test
    @Order(21)
    public void testLaitueMeurt() {
        System.out.println("\nTest 21 - Une laitue meurt de vieillesse (normal)\n");
        laitue2.setDureeVie(1);
        System.out.println("Les caractéristiques de la laitue2 : " + laitue2 + "\n");
        System.out.println("Nombre de laitues dans l'écosystème : " +
                foretTemperee.getLaituesDansEco().size() + "\n");
        System.out.println("Appel de la méthode vieillir() \n");
        laitue2.vieillir();

        System.out.println("Nombre de laitues dans l'écosystème : " +
                foretTemperee.getLaituesDansEco().size() + "\n");
        System.out.println("\n\n\n");
    }


    // test 22 - Une laitue vit un jour (normal)
    @Test
    @Order(22)
    public void testLaitueVitUnJour() throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        System.out.println("\nTest 22 - Une laitue vit un jour (normal)\n");
        System.out.println("Les caractéristiques de la laitue2 : " + laitue2 + "\n");
        System.out.println("Appel de la méthode vivreUnJour() \n");
        laitue2.vivreUnJour();

        System.out.println("Les caractéristiques de la laitue2 : " + laitue2 + "\n");
        System.out.println("\n\n\n");
    }


    // test 23 - Un loup mange (normal)
    @Test
    @Order(23)
    public void testLoupMange() {
        System.out.println("\nTest 23 - Un loup mange (normal)\n");

        loup1.setFaim(5);
        loup1.setVitesse(16);

        System.out.println("Les caractéristiques du loup1 :" + loup1 + "\n");
        while (loup1.getFaim() < 10)
            loup1.manger();
        System.out.println("Les caractéristiques du loup1 après avoir mangé: " + loup1 + "\n");
        System.out.println("\n\n\n");
    }


    // test 24 - Un loup se reproduit (normal)
    @Test
    @Order(24)
    public void testLoupSeReproduit() throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        System.out.println("\nTest 24 - Un loup se reproduit (normal)\n");
        loup1.setSexe(Sexe.FEMELLE);
        loup1.setNbPetits(1);
        loup1.setAge(2);
        loup2.setSexe(Sexe.MALE);
        loup2.setAge(2);
        loup2.setNbPetits(null);
        System.out.println("Les caractéristiques du loup1 :" + loup1 + "\n");
        System.out.println("Les caractéristiques du loup2 :" + loup2 + "\n");
        System.out.println("Nombre de loups dans l'écosystème :" +
                foretTemperee.getLoupsDansEco().size() + "\n");

        int nbLoups = foretTemperee.getLoupsDansEco().size();
        while (nbLoups == foretTemperee.getLoupsDansEco().size()) {
            loup1.getReproduction().seReproduire();
        }

        System.out.println("Nombre de loups dans l'écosystème :" +
                foretTemperee.getLoupsDansEco().size() + "\n");

        System.out.println("Liste des loups dans l'écosystème:");
        for (Loup loup : foretTemperee.getLoupsDansEco()) {
            System.out.println(loup);
        }
        System.out.println("\n\n\n\n");

    }

    // test 25 - un loup meurt de faim (normal)
    @Test
    @Order(25)
    public void testLoupMeurt() {
        System.out.println("\nTest 25 - Un loup meurt de faim (normal)\n");
        loup1.setFaim(0);
        System.out.println("Les caractéristiques du loup1 :" + loup1 + "\n");
        System.out.println("Nombre de loups dans l'écosystème :" +
                loup1.getEcosysteme().getLoupsDansEco().size() + "\n");
        System.out.println("Appel de la méthode vieillir()\n");
        loup1.vieillir();
        System.out.println("Les caractéristiques du loup1 :" + loup1 + "\n");
        System.out.println("\n\n\n");
    }


    // test 26 - un loup vit un jour (normal)
    @Test
    @Order(26)
    public void testLoupVitUnJour() throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        System.out.println("\nTest 26 - Un loup vit un jour (normal)\n");
        System.out.println("Les caractéristiques du loup1 :" + loup1 + "\n");
        System.out.println("Appel de la méthode vivreUnJour()\n");
        loup1.vivreUnJour();
        System.out.println("Les caractéristiques du loup1 :" + loup1 + "\n");
        System.out.println("\n\n\n");
    }


    // test 27 - Une menthe se reproduit (normal)
    @Test
    @Order(27)
    public void testMentheSeReproduit() throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        System.out.println("\nTest 27 - Une menthe se reproduit (normal)\n");
        System.out.println("Les caractéristiques de la menthe1 :" + menthe1 + "\n");
        System.out.println("Nombre de menthes dans l'écosystème :" +
                foretTemperee.getMenthesDansEco().size() + "\n");

        int nbMenthes = foretTemperee.getMenthesDansEco().size();
        System.out.println("Appel de la méthode seReproduire() \n");
        while (nbMenthes == foretTemperee.getMenthesDansEco().size()) {
            menthe1.seReproduire();
        }

        System.out.println("Nombre de menthes dans l'écosystème :" +
                foretTemperee.getMenthesDansEco().size() + "\n");

        System.out.println("Liste des menthes dans l'écosystème:");
        for (Menthe menthe : foretTemperee.getMenthesDansEco()) {
            System.out.println(menthe);
        }
        System.out.println("\n\n\n\n");
    }

    // test 28 - Une menthe meurt (normal)
    @Test
    @Order(28)
    public void tesMentheMeurt() {
        System.out.println("\nTest 28 - Une menthe meurt de vieillesse (normal)\n");
        menthe2.setDureeVie(1);
        System.out.println("Les caractéristiques de la menthe2 : " + menthe2 + "\n");
        System.out.println("Nombre de menthes dans l'écosystème : " +
                foretTemperee.getMenthesDansEco().size() + "\n");
        System.out.println("Appel de la méthode vieillir() \n");
        menthe2.vieillir();

        System.out.println("Nombre de menthes dans l'écosystème : " +
                foretTemperee.getMenthesDansEco().size() + "\n");
        System.out.println("\n\n\n");
    }


    // test 29 - Une menthe vit un jour (normal)
    @Test
    @Order(29)
    public void testMentheVitUnJour() throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        System.out.println("\nTest 29 - Une menthe vit un jour (normal)\n");
        System.out.println("Les caractéristiques de la menthe2 : " + menthe2 + "\n");
        System.out.println("Appel de la méthode vivreUnJour() \n");
        menthe2.vivreUnJour();

        System.out.println("Les caractéristiques de la laitue2 : " + menthe2 + "\n");
        System.out.println("\n\n\n");
    }


    // test 30 - Un oeuf est mangé par un ovivore (normal)
    @Test
    @Order(30)
    public void testOeufEstMange() throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        System.out.println("\nTest 30 - Un oeuf est mangé par un ovivore (normal)\n");

        corbeau1.setSexe(Sexe.FEMELLE);
        corbeau1.setAge(2);
        int nbOeufsEco = foretTemperee.getOeufsDansEco().size();
        while (nbOeufsEco == foretTemperee.getOeufsDansEco().size()) {
            corbeau1.getReproduction().seReproduire();
        }

        System.out.println("Un oeuf de corbeau a été pondu par une femelle.");
        System.out.println("Nombre d'oeufs dans l'écosystème :" + foretTemperee.getOeufsDansEco().size());
        System.out.println("Appel de la méthode manger().");

        int nbOeufs = foretTemperee.getOeufsDansEco().size();

        while (nbOeufs == foretTemperee.getOeufsDansEco().size()){
            ours1.setFaim(4);
            ours1.manger();
        }

        System.out.println("Nombre d'oeufs dans l'écosystème :" + foretTemperee.getOeufsDansEco().size());
        System.out.println("\n\n\n\n");

    }

    // test 31 - Un oeuf pourrit (normal)
    @Test
    @Order(31)
    public void testOeufPourri() throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        System.out.println("\nTest 31 - Un oeuf pourrit (normal)\n");

        tortue2.setSexe(Sexe.FEMELLE);
        tortue2.setAge(2);
        tortue2.setNbPetits(1);
        int nbOeufsEco = foretTemperee.getOeufsDansEco().size();
        while (nbOeufsEco == foretTemperee.getOeufsDansEco().size()) {
            tortue2.getReproduction().seReproduire();
        }

        Oeuf oeufExemple = null;

        for (Oeuf oeuf : foretTemperee.getOeufsDansEco()) {
            oeufExemple = oeuf;
        }

        System.out.println("Appel de la méthode vieillir()");
        assert oeufExemple != null;
        oeufExemple.vieillir();
        oeufExemple.vieillir();
        oeufExemple.vieillir();
        oeufExemple.vieillir();
        oeufExemple.vieillir();
        oeufExemple.vieillir();

        System.out.println("Appel de la méthode oeufPourri()");
        oeufExemple.oeufPourri();
        System.out.println("\n\n\n\n");
    }

    // test 32 - Un oeuf vit un jour (normal)
    @Test
    @Order(32)
    public void testOeufVitJour() throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        System.out.println("\nTest 32 - Un oeuf vit un jour (normal)\n");

        tortue2.setSexe(Sexe.FEMELLE);
        tortue2.setAge(2);
        tortue2.setNbPetits(1);
        int nbOeufsEco = foretTemperee.getOeufsDansEco().size();
        while (nbOeufsEco == foretTemperee.getOeufsDansEco().size()) {
            tortue2.getReproduction().seReproduire();
        }

        Oeuf oeufExemple = null;

        System.out.println("Caractéristiques de l'oeuf:");
        for (Oeuf oeuf : foretTemperee.getOeufsDansEco()) {
            System.out.println(oeuf);
            oeufExemple = oeuf;
        }

        System.out.println("\nAppel de la méthode vivreUnJour()\n");
        assert oeufExemple != null;
        oeufExemple.vivreUnJour();

        System.out.println("Caractéristiques de l'oeuf:");
        for (Oeuf oeuf : foretTemperee.getOeufsDansEco()) {
            System.out.println(oeuf);
        }
        System.out.println("\n\n\n\n");
    }


    // test 33 - Un ours mange (illustration: un végétal) (normal)
    @Test
    @Order(33)
    public void testOursMangeVegetal() {
        System.out.println("\nTest 33 - Un ours mange (illustration: un végétal) (normal)\n");

        ours3.setFaim(5);

        System.out.println("Les caractéristiques de l'ours3 :" + ours3 + "\n");
        System.out.println("Nombre de végétaux dans l'écosystème :" +
                foretTemperee.getVegetauxDansEco().size() + "\n");

        int nbVege = foretTemperee.getVegetauxDansEco().size();
        System.out.println("Appel de la méthode manger() \n");
        while (nbVege == foretTemperee.getVegetauxDansEco().size()) {
            ours3.setFaim(4);
            ours3.manger();
        }

        System.out.println("Nombre de végétaux dans l'écosystème :" +
                foretTemperee.getVegetauxDansEco().size() + "\n");

        System.out.println("Les caractéristiques de l'ours3 :" + ours3 + "\n");
        System.out.println("\n\n\n");
    }


    // test 34 - Un ours mange (illustration: un animal) (normal)
    @Test
    @Order(34)
    public void testOursMangeAnimal() {
        System.out.println("\nTest 34 - Un ours mange (illustration: un animal) (normal)\n");

        ours3.setFaim(5);
        ours3.setVitesse(16);

        System.out.println("Les caractéristiques de l'ours3 :" + ours3 + "\n");
        System.out.println("Nombre d'animaux dans l'écosystème :" +
                foretTemperee.getAnimauxDansEco().size() + "\n");

        int nbAnimaux = foretTemperee.getAnimauxDansEco().size();

        System.out.println("Appel de la méthode manger() \n");
        while (nbAnimaux == foretTemperee.getAnimauxDansEco().size()) {
            ours3.setFaim(4);
            ours3.manger();
        }

        System.out.println("Nombre d'animaux dans l'écosystème :" +
                foretTemperee.getAnimauxDansEco().size() + "\n");

        System.out.println("Les caractéristiques de l'ours3 :" + ours3 + "\n");
        System.out.println("\n\n\n");
    }


    // test 35 - Un ours mange (illustration: un oeuf) (normal)
    @Test
    @Order(35)
    public void testOursMangeOeuf() throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        System.out.println("\nTest 35 - Un ours mange (illustration: un oeuf) (normal)\n");

        // une tortue pond un oeuf
        tortue2.setSexe(Sexe.FEMELLE);
        tortue2.setAge(2);
        tortue2.setNbPetits(1);
        int nbOeufsEco = foretTemperee.getOeufsDansEco().size();
        while (nbOeufsEco == foretTemperee.getOeufsDansEco().size()) {
            tortue2.getReproduction().seReproduire();
        }

        ours3.setFaim(5);

        System.out.println("Les caractéristiques de l'ours3 :" + ours3 + "\n");
        System.out.println("Nombre d'oeufs dans l'écosystème :" +
                foretTemperee.getOeufsDansEco().size() + "\n");

        int nbOeufs = foretTemperee.getOeufsDansEco().size();

        System.out.println("Appel de la méthode manger() \n");
        while (nbOeufs == foretTemperee.getAnimauxDansEco().size()) {
            ours3.setFaim(4);
            ours3.manger();
        }

        System.out.println("Nombre d'oeufs dans l'écosystème :" +
                foretTemperee.getOeufsDansEco().size() + "\n");

        System.out.println("Les caractéristiques de l'ours3 :" + ours3 + "\n");
        System.out.println("\n\n\n");
    }


    // test 36 - Un ours se reproduit (normal)
    @Test
    @Order(36)
    public void testOursSeReproduit() throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        System.out.println("\nTest 36 - Un ours se reproduit (normal)\n");

        ours1.setSexe(Sexe.FEMELLE);
        ours1.setNbPetits(1);
        ours1.setAge(2);
        ours2.setSexe(Sexe.MALE);
        ours2.setAge(2);
        ours2.setNbPetits(null);

        System.out.println("Les caractéristiques de l'ours1 :" + ours1 + "\n");
        System.out.println("Les caractéristiques de l'ours2 :" + ours2 + "\n");
        System.out.println("Nombre d'ours dans l'écosystème :" +
                foretTemperee.getOursDansEco().size() + "\n");

        System.out.println("Appel de la méthode seReproduire() \n");
        int nbOurs = foretTemperee.getOursDansEco().size();
        while (nbOurs == foretTemperee.getOursDansEco().size()) {
            ours1.getReproduction().seReproduire();
        }

        System.out.println("Nombre d'ours dans l'écosystème :" +
                foretTemperee.getOursDansEco().size() + "\n");

        System.out.println("Liste des ours dans l'écosystème:");
        for (Ours ours : foretTemperee.getOursDansEco()) {
            System.out.println(ours);
        }
        System.out.println("\n\n\n\n");
    }


    // test 37 - Un ours vit un jour (normal)
    @Test
    @Order(37)
    public void testOursVitJour() throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        System.out.println("\nTest 37 - Un ours vit un jour (normal)\n");
        System.out.println("Les caractéristiques de l'ours1 : " + ours1 + "\n");
        System.out.println("Appel de la méthode vivreUnJour() \n");
        ours1.vivreUnJour();

        System.out.println("Les caractéristiques de la biche3 : " + ours1 + "\n");
        System.out.println("\n\n\n");
    }


    // test 38 - Un ours meurt de vieillesse (normal)
    @Test
    @Order(38)
    public void testOursMeurt() {
        System.out.println("\nTest 38 - Un ours meurt de vieillesse (normal)\n");
        ours2.setAge(10);
        ours2.setEsperanceVie(0);
        System.out.println("Nombre d'ours dans l'écosystème :" +
                foretTemperee.getOursDansEco().size() + "\n");
        System.out.println("Les caractéristiques de l'ours2 : " + ours2 + "\n");
        System.out.println("Appel de la méthode vieillir() \n");
        ours2.vieillir();

        System.out.println("Les caractéristiques de l'ours2 : " + ours2 + "\n");
        System.out.println("\n\n\n");
    }


    // test 39 - Une rhubarbe se reproduit (normal)
    @Test
    @Order(39)
    public void testRhubarbeSeReproduit() throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        System.out.println("\nTest 39 - Une rhubarbe se reproduit (normal)\n");
        System.out.println("Les caractéristiques de la rhubarbe1 :" + rhubarbe1 + "\n");
        System.out.println("Nombre de rhubarbes dans l'écosystème :" +
                foretTemperee.getRhubarbesDansEco().size() + "\n");

        int nbRhubarbes = foretTemperee.getRhubarbesDansEco().size();
        System.out.println("Appel de la méthode seReproduire() \n");
        while (nbRhubarbes == foretTemperee.getRhubarbesDansEco().size()) {
            rhubarbe1.seReproduire();
        }

        System.out.println("Nombre de rhubarbes dans l'écosystème :" +
                foretTemperee.getRhubarbesDansEco().size() + "\n");

        System.out.println("Liste des asperges dans l'écosystème:");
        for (Rhubarbe rhubarbe : foretTemperee.getRhubarbesDansEco()) {
            System.out.println(rhubarbe);
        }
        System.out.println("\n\n\n\n");
    }


    // test 40 - Une rhubarbe meurt (normal)
    @Test
    @Order(40)
    public void testRhubarbeMeurt() {
        System.out.println("\nTest 40 - Une rhubarbe meurt de vieillesse (normal)\n");
        rhubarbe1.setDureeVie(1);
        System.out.println("Les caractéristiques de la rhubarbe1 : " + rhubarbe1 + "\n");
        System.out.println("Nombre de rhubarbes dans l'écosystème : " +
                foretTemperee.getRhubarbesDansEco().size() + "\n");
        System.out.println("Appel de la méthode vieillir() \n");
        rhubarbe1.vieillir();

        System.out.println("Nombre de rhubarbes dans l'écosystème : " +
                foretTemperee.getRhubarbesDansEco().size() + "\n");
        System.out.println("\n\n\n");
    }


    // test 41 - Une rhubarbe vit un jour (normal)
    @Test
    @Order(41)
    public void testRhubarbeVitJour() throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        System.out.println("\nTest 41 - Une rhubarbe vit un jour (normal)\n");
        System.out.println("Les caractéristiques de la rhubarbe2 : " + rhubarbe2 + "\n");
        System.out.println("Appel de la méthode vivreUnJour() \n");
        rhubarbe2.vivreUnJour();

        System.out.println("Les caractéristiques de la rhubarbe2 : " + rhubarbe2 + "\n");
        System.out.println("\n\n\n");
    }



    // test 42 - Une tortue mange (normal)
    @Test
    @Order(42)
    public void testTortueMange() {
        System.out.println("\nTest 42 - Une tortue mange (normal)\n");

        tortue1.setFaim(5);

        System.out.println("Les caractéristiques de la tortue1 :" + tortue1 + "\n");
        System.out.println("Le nombre de végétaux dans l'écosystème: "
                + foretTemperee.getVegetauxDansEco().size() + "\n");

        System.out.println("Appel de la méthode manger() \n");
        tortue1.manger();

        System.out.println("Les caractéristiques de la tortue1 après avoir mangé : " + tortue1 + "\n");
        System.out.println("Le nombre de végétaux dans l'écosystème: "
                + foretTemperee.getVegetauxDansEco().size() + "\n");

        System.out.println("\n\n\n");

    }

    // test 43 - Une tortue pond un oeuf (normal)
    @Test
    @Order(43)
    public void testTortuePondOeuf() throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        System.out.println("\nTest 43 - Une tortue pond un oeuf (normal)\n");
        tortue1.setSexe(Sexe.FEMELLE);
        tortue1.setAge(2);
        System.out.println("Les caractéristiques de la tortue1 :" + tortue1 + "\n");

        int nbOeufsEco = foretTemperee.getOeufsDansEco().size();
        System.out.println("Nombre d'oeufs dans l'écosystème :" +
                nbOeufsEco + "\n");

        System.out.println("Appel de la méthode pondreOeuf() \n");
        while (nbOeufsEco == foretTemperee.getOeufsDansEco().size()) {
            tortue1.getReproduction().seReproduire();
        }

        System.out.println("Nombre d'oeufs dans l'écosystème :" +
                foretTemperee.getOeufsDansEco().size() + "\n");

        System.out.println("Liste des oeufs dans l'écosystème:");
        for (Oeuf oeuf : foretTemperee.getOeufsDansEco()) {
            System.out.println(oeuf);
        }

        System.out.println("\n\n\n\n");
    }


    // test 44 - Une tortue fertilise un oeuf (normal)
    @Test
    @Order(44)
    public void testTortueFertiliseOeuf() throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        System.out.println("\nTest 44 - Une tortue fertilise un oeuf (normal)\n");

        tortue1.setSexe(Sexe.FEMELLE);
        tortue1.setAge(2);
        tortue1.setNbPetits(1);
        int nbOeufsEco = foretTemperee.getOeufsDansEco().size();
        while (nbOeufsEco == foretTemperee.getOeufsDansEco().size()) {
            tortue1.getReproduction().seReproduire();
        }

        System.out.println("Nombre d'oeufs dans l'écosystème :" +
                foretTemperee.getOeufsDansEco().size() + "\n");


        tortue2.setSexe(Sexe.MALE);
        tortue2.setAge(2);
        tortue2.setNbPetits(1);

        Oeuf oeufExemple = null;

        System.out.println("Liste des oeufs dans l'écosystème:");
        for (Oeuf oeuf : foretTemperee.getOeufsDansEco()) {
            System.out.println(oeuf);
            oeufExemple = oeuf;

        }

        assert oeufExemple != null;
        while (!(oeufExemple.isFertilise())) {
            tortue2.getReproduction().seReproduire();
        }

        System.out.println("Liste des oeufs dans l'écosystème:");
        for (Oeuf oeuf : foretTemperee.getOeufsDansEco()) {
            System.out.println(oeuf);
        }

        System.out.println("\n\n\n\n");
    }


    // test 45 - Un oeuf de tortue éclot (normal)
    @Test
    @Order(45)
    public void testOeufTortueEclot() throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        System.out.println("\nTest 45 - Un oeuf de tortue éclot (normal)\n");

        tortue1.setSexe(Sexe.FEMELLE);
        tortue1.setAge(2);
        tortue1.setNbPetits(1);
        int nbOeufsEco = foretTemperee.getOeufsDansEco().size();
        while (nbOeufsEco == foretTemperee.getOeufsDansEco().size()) {
            tortue1.getReproduction().seReproduire();
        }

        System.out.println("Nombre d'oeufs dans l'écosystème : " +
                foretTemperee.getOeufsDansEco().size() + "\n");
        System.out.println("Nombre de tortues dans l'écosystème : " +
                foretTemperee.getTortuesDansEco().size() + "\n");


        tortue2.setSexe(Sexe.MALE);
        tortue2.setAge(2);
        tortue2.setNbPetits(1);

        Oeuf oeufExemple = null;

        for (Oeuf oeuf : foretTemperee.getOeufsDansEco()) {
            oeufExemple = oeuf;

        }

        assert oeufExemple != null;
        while (!(oeufExemple.isFertilise())) {
            tortue2.getReproduction().seReproduire();
        }

        System.out.println("Appel de la fonction vieillir: ");

        while (oeufExemple.getEcosysteme() != null) {
            oeufExemple.vivreUnJour();
        }

        System.out.println("Nombre d'oeufs dans l'écosystème : " +
                foretTemperee.getOeufsDansEco().size() + "\n");
        System.out.println("Nombre de tortues dans l'écosystème : " +
                foretTemperee.getTortuesDansEco().size() + "\n");


        System.out.println("Liste des tortues dans l'écosystème: ");
        for (Tortue tortue : foretTemperee.getTortuesDansEco()) {
            System.out.println(tortue);
        }

        System.out.println("\n\n\n\n");
    }


    // test 46 - Une tortue vit un jour (normal)
    @Test
    @Order(46)
    public void testTortueVitUnJour() throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        System.out.println("\nTest 46 - Une tortue vit un jour \n");

        System.out.println("Caractéristiques de la tortue 1: " + tortue1 + "\n");
        System.out.println("Appel de la méthode vivreUnJour() \n");
        tortue1.vivreUnJour();
        System.out.println("Caractéristiques de la tortue 1: " + tortue1 + "\n");
        System.out.println("\n\n\n");

    }
}

