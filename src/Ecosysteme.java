import java.lang.reflect.InvocationTargetException;
import java.util.*;


public class Ecosysteme {

    private static int prochainId = 0; // variable statique pour générer un ID unique
    private int id; // ID de l'écosystème
    private String nom; // nom de l'écosystème
    private Set<Organisme> organismesDansEco = new HashSet<>(); // ensemble des organismes présents dans l'écosystème
    private Set<Animal> animauxDansEco = new HashSet<>(); // ensemble d'animaux présents dans l'écosystème
    private Set<Vegetal> vegetauxDansEco = new HashSet<>(); // ensemble de végétaux présents dans l'écosystème
    private Set<Oeuf> oeufsDansEco = new HashSet<>(); // ensemble des oeufs présents dans l'écosystème
    private Set<Class> especesDansEco = new HashSet<>(); // ensemble des espèces de l'écosystème
    private Set<Asperge> aspergesDansEco = new HashSet<>(); // ensemble des asperges de l'écosystème
    private Set<Biche> bichesDansEco = new HashSet<>(); // ensemble des biches de l'écosystème
    private Set<Bouleau>bouleauxDansEco = new HashSet<>(); // ensemble des bouleaux de l'écosystème
    private Set<Corbeau> corbeauxDansEco = new HashSet<>(); // ensemble des corbeaux de l'écosystème
    private Set<Laitue> laituesDansEco = new HashSet<>(); // ensemble des laitues de l'écosystème
    private Set<Loup> loupsDansEco = new HashSet<>(); // ensemble des loups de l'écosystème
    private Set<Menthe> menthesDansEco = new HashSet<>(); // ensemble des menthes de l'écosystème
    private Set<Ours> oursDansEco = new HashSet<>(); // ensemble des ours de l'écosystème
    private Set<Rhubarbe> rhubarbesDansEco = new HashSet<>(); // ensemble des rhubarbes de l'écosystème
    private Set<Tortue> tortuesDansEco = new HashSet<>(); // ensemble des tortues de l'écosystème


    // constructeur de la classe Ecosysteme
    public Ecosysteme(String nom) {
        this.id = prochainId; // assigne l'ID
        prochainId++; // incrémente pour le prochain écosystème
        this.nom = nom; // assigne le nom de l'écosystème
    }

    // getter et setter

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Set<Organisme> getOrganismesDansEco() {
        return organismesDansEco;
    }

    public void setOrganismesDansEco(Set<Organisme> organismesDansEco) {
        this.organismesDansEco = organismesDansEco;
    }

    public Set<Animal> getAnimauxDansEco() {
        return animauxDansEco;
    }

    public void setAnimauxDansEco(Set<Animal> animauxDansEco) {
        this.animauxDansEco = animauxDansEco;
    }

    public Set<Vegetal> getVegetauxDansEco() {
        return vegetauxDansEco;
    }

    public void setVegetauxDansEco(Set<Vegetal> vegetauxDansEco) {
        this.vegetauxDansEco = vegetauxDansEco;
    }

    public Set<Oeuf> getOeufsDansEco() {
        return oeufsDansEco;
    }

    public void setOeufsDansEco(Set<Oeuf> oeufsDansEco) {
        this.oeufsDansEco = oeufsDansEco;
    }

    public Set<Class> getEspecesDansEco() {
        return especesDansEco;
    }

    public void setEspecesDansEco(Set<Class> especesDansEco) {
        this.especesDansEco = especesDansEco;
    }

    public Set<Asperge> getAspergesDansEco() {
        return aspergesDansEco;
    }

    public void setAspergesDansEco(Set<Asperge> aspergesDansEco) {
        this.aspergesDansEco = aspergesDansEco;
    }

    public Set<Biche> getBichesDansEco() {
        return bichesDansEco;
    }

    public void setBichesDansEco(Set<Biche> bichesDansEco) {
        this.bichesDansEco = bichesDansEco;
    }

    public Set<Bouleau> getBouleauxDansEco() {
        return bouleauxDansEco;
    }

    public void setBouleauxDansEco(Set<Bouleau> bouleauxDansEco) {
        this.bouleauxDansEco = bouleauxDansEco;
    }

    public Set<Corbeau> getCorbeauxDansEco() {
        return corbeauxDansEco;
    }

    public void setCorbeauxDansEco(Set<Corbeau> corbeauxDansEco) {
        this.corbeauxDansEco = corbeauxDansEco;
    }

    public Set<Laitue> getLaituesDansEco() {
        return laituesDansEco;
    }

    public void setLaituesDansEco(Set<Laitue> laituesDansEco) {
        this.laituesDansEco = laituesDansEco;
    }

    public Set<Loup> getLoupsDansEco() {
        return loupsDansEco;
    }

    public void setLoupDansEco(Set<Loup> loupsDansEco) {
        this.loupsDansEco = loupsDansEco;
    }

    public Set<Menthe> getMenthesDansEco() {
        return menthesDansEco;
    }

    public void setMenthesDansEco(Set<Menthe> menthesDansEco) {
        this.menthesDansEco = menthesDansEco;
    }

    public Set<Ours> getOursDansEco() {
        return oursDansEco;
    }

    public void setOursDansEco(Set<Ours> oursDansEco) {
        this.oursDansEco = oursDansEco;
    }

    public Set<Rhubarbe> getRhubarbesDansEco() {
        return rhubarbesDansEco;
    }

    public void setRhubarbesDansEco(Set<Rhubarbe> rhubarbesDansEco) {
        this.rhubarbesDansEco = rhubarbesDansEco;
    }

    public Set<Tortue> getTortuesDansEco() {
        return tortuesDansEco;
    }

    public void setTortuesDansEco(Set<Tortue> tortuesDansEco) {
        this.tortuesDansEco = tortuesDansEco;
    }

    @Override
    public String toString() {
        return "Ecosysteme{" +
                "id=" + id +
                ", nom='" + nom +
                ", organismesDansEco=" + organismesDansEco +
                ", animauxDansEco=" + animauxDansEco +
                ", vegetauxDansEco=" + vegetauxDansEco +
                ", oeufsDansEco=" + oeufsDansEco +
                ", especesDansEco=" + especesDansEco +
                ", aspergesDansEco=" + aspergesDansEco +
                ", bichesDansEco=" + bichesDansEco +
                ", bouleauxDansEco=" + bouleauxDansEco +
                ", corbeauxDansEco=" + corbeauxDansEco +
                ", laituesDansEco=" + laituesDansEco +
                ", loupsDansEco=" + loupsDansEco +
                ", menthesDansEco=" + menthesDansEco +
                ", oursDansEco=" + oursDansEco +
                ", rhubarbesDansEco=" + rhubarbesDansEco +
                ", tortuesDansEco=" + tortuesDansEco +
                '}';
    }


    // méthode pour ajouter un animal à l'écosystème
        public void ajouterAnimal(Animal animal){
            // ajoute l'animal à l'éco
            this.getAnimauxDansEco().add(animal);
            // ajoute son espèce à la liste des espèces
            this.ajouterEspece(animal.getClass());
            // ajoute à la liste des organismes
            this.getOrganismesDansEco().add(animal);

    }

    // méthode pour supprimer un animal de l'écosystème
    public void supprimerAnimal(Animal animal){
        // supprime l'animal de l'éco
        this.getAnimauxDansEco().remove(animal);
        // retire l'animal des individus dans la sous-liste espèce
        animal.getEcosysteme().supprimerListeIndividuEspece(animal);
        // retire l'animal de la liste des organismes de l'écosystème
        this.getOrganismesDansEco().remove(animal);
        // passe l'éco de l'animal à null
        animal.setEcosysteme(null);
    }

    // ajoute un végétal à l'écosystème
    public void ajouterVegetal(Vegetal vegetal){
        // ajoute le végétal à l'éco
        this.getVegetauxDansEco().add(vegetal);
        // ajoute son espèce à la liste des espèces
        this.ajouterEspece(vegetal.getClass());
        // ajoute à la liste des organismes
        this.getOrganismesDansEco().add(vegetal);

    }

    // supprime un végétal de l'écosystème
    public void supprimerVegetal(Vegetal vegetal){
        // supprime le végétal de l'éco
        this.getVegetauxDansEco().remove(vegetal);

        // retire le végétal des individus dans la sous-liste espèce
        vegetal.getEcosysteme().supprimerListeIndividuEspece(vegetal);

        // retire le vegetal de la liste des organismes de l'écosystème
        this.getOrganismesDansEco().remove(vegetal);

        // passe son éco à null
        vegetal.setEcosysteme(null);

    }

    // ajoute un oeuf à l'écosystème
    public void ajouterOeuf(Oeuf oeuf){
        this.getOeufsDansEco().add(oeuf);
        // ajoute à la liste des organismes
        this.getOrganismesDansEco().add(oeuf);
    }


    // supprime un oeuf de l'écosystème
    public void supprimerOeuf(Oeuf oeuf){
        // retire l'oeuf de l'éco
        this.getOeufsDansEco().remove(oeuf);
        // retire l'oeuf de la liste des organismes de l'écosystème
        this.getOrganismesDansEco().remove(oeuf);
        // passe son éco à null
        oeuf.setEcosysteme(null);
    }


    // ajoute une espèce l'écosystème
    public void ajouterEspece(Class espece){
        this.getEspecesDansEco().add(espece);
    }



    // supprime une espèce de l'écosystème
    public void supprimerEspece(Class espece) {

        this.getEspecesDansEco().remove(espece);

        // obtient la liste de tous les animaux de l'éco
        Set<Animal> animauxEco = new HashSet<>(this.getAnimauxDansEco());
        // parcourt tous les animaux de l'environnement
        for (Animal animal : animauxEco){
            if (animal.getClass().equals(espece)){
                // si l'animal est de l'espèce qu'on veut supprimer
                // le supprime
                animal.getEcosysteme().supprimerAnimal(animal);
            }
        }

        // obtient la liste de tous les végétaux de l'éco
        Set<Vegetal> vegetauxEco = new HashSet<>(this.getVegetauxDansEco());
        // parcourt tous les végétaux de l'environnement
        for (Vegetal vegetal : vegetauxEco){
                if (vegetal.getClass().getSimpleName().equals(espece.getSimpleName())){
                    // si le végétal est de l'espèce qu'on veut supprimer, le supprime
                    vegetal.getEcosysteme().supprimerVegetal(vegetal);
                }
            }

        // obtient la liste de tous les oeufs de l'éco
        Set<Oeuf> oeufsEco = new HashSet<>(this.getOeufsDansEco());
        // parcourt tous les oeufs de l'éco
        for (Oeuf oeuf : oeufsEco){
            if (oeuf.getClass().getSimpleName().equals(espece.getSimpleName())){
                // si ce sont les oeufs qu'on veut supprimer
                oeuf.getEcosysteme().supprimerOeuf(oeuf);
            }
        }
    }

    // affiche les espèces de l'écosystème
    public void afficherEspece(){
        // obtient la liste des espèces de l'éco
        Set<Class> especesEco = new HashSet<>(this.getEspecesDansEco());
        for (Class espece : especesEco){
            // parcourt les différentes entrées
            // et affiche leur nom
            System.out.println(espece.getSimpleName());
        }
    }


    // retourne l'objet Animal d'après son id
    public Animal getAnimalParId(int idRecherche) {
        // obtient la liste de tous les animaux de l'éco
        Set<Animal> animauxEco = new HashSet<>(this.getAnimauxDansEco());
        // parcourt les animaux de l'éco
        for (Animal animal : animauxEco) {
            // si l'ID de l'animal est celui qu'on recherche
            if (animal.getId() == idRecherche) {
                // on renvoie l'animal correspondant à l'ID
                return animal;
            }
        }
        // on renvoie null s'il n'existe pas
        return null;
    }


    // compte le nombre d'instances d'une espèce
    public void afficherCompteAnimauxVegetaux() {
        // obtient la liste de tous les animaux de l'éco
        Set<Asperge> aspergesEco = new HashSet<>(this.getAspergesDansEco());
        Set<Biche> bichesEco = new HashSet<>(this.getBichesDansEco());
        Set<Bouleau>bouleauxEco = new HashSet<>(this.getBouleauxDansEco());
        Set<Corbeau> corbeauxEco = new HashSet<>(this.getCorbeauxDansEco());
        Set<Laitue> laituesEco = new HashSet<>(this.getLaituesDansEco());
        Set<Loup> loupsEco = new HashSet<>(this.getLoupsDansEco());
        Set<Menthe> menthesEco = new HashSet<>(this.getMenthesDansEco());
        Set<Ours> oursEco = new HashSet<>(this.getOursDansEco());
        Set<Rhubarbe> rhubarbesEco = new HashSet<>(this.getRhubarbesDansEco());
        Set<Tortue> tortuesEco = new HashSet<>(this.getTortuesDansEco());
        Set<Oeuf> oeufsEco = new HashSet<>(this.getOeufsDansEco());

        System.out.println("\nIl y a " + aspergesEco.size() + " asperges, " +
                        bichesEco.size() + " biches, " +
                        bouleauxEco.size() + " bouleaux, " +
                        corbeauxEco.size() + " corbeaux, " +
                        laituesEco.size() + " laitues, " +
                        loupsEco.size() + " loups, " +
                        menthesEco.size() + " menthes,  \n" +
                        oursEco.size() + " ours, " +
                        rhubarbesEco.size() + " rhubarbes, " +
                        tortuesEco.size() + " tortues et " +
                        oeufsEco.size() + " oeufs dans l'écosystème puis...\n");


    }


    // méthode pour supprimer un organisme de la sous-liste de son espèce
    public void supprimerListeIndividuEspece(Organisme organisme) {
        // sort si l'organisme n'appartient à un éco ou au bon éco
        if (organisme.getEcosysteme() == null
                || organisme.getEcosysteme() != this) {
            return;
        }
        switch (organisme) { // selon le type de l'organisme
            // on le supprime de la sous-liste associée
            case Asperge asperge -> aspergesDansEco.remove(asperge);
            case Biche biche -> bichesDansEco.remove(biche);
            case Bouleau bouleau -> bouleauxDansEco.remove(bouleau);
            case Corbeau corbeau -> corbeauxDansEco.remove(corbeau);
            case Laitue laitue -> laituesDansEco.remove(laitue);
            case Loup loup -> loupsDansEco.remove(loup);
            case Menthe menthe -> menthesDansEco.remove(menthe);
            case Ours ours -> oursDansEco.remove(ours);
            case Rhubarbe rhubarbe -> rhubarbesDansEco.remove(rhubarbe);
            case Tortue tortue -> tortuesDansEco.remove(tortue);
            default -> { // sort sinon
            }
        }
    }


    // méthode appelée pour le passage du temps
    public void passageTemps() throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {

        // on récupère le nombre d'animaux, de végétaux et d'oeufs dans l'écosystème
        Set<Animal> animauxTemp = new HashSet<>(this.getAnimauxDansEco());
        Set<Vegetal> vegetauxTemp = new HashSet<>(this.getVegetauxDansEco());
        Set<Oeuf> oeufsTemp = new HashSet<>(this.getOeufsDansEco());

        System.out.println("\nIl y a " + this.getAnimauxDansEco().size() + " animaux dans l'écosystème.");
        System.out.println("Il y a " + this.getVegetauxDansEco().size() + " végétaux dans l'écosystème.");
        System.out.println("Il y a " + this.getOeufsDansEco().size() + " oeufs dans l'écosystème.");

        this.afficherCompteAnimauxVegetaux();


        // appelle vivreUnJour() pour tous les animaux
        for (Animal animal : animauxTemp) {
            animal.vivreUnJour();
        }

        // appelle vivreUnJour() pour tous les végétaux
        for (Vegetal vegetal : vegetauxTemp) {
            vegetal.vivreUnJour();
            }

        // appelle vivreUnJour() pour tous les oeufs
        for (Oeuf oeuf : oeufsTemp){
            oeuf.vivreUnJour();
        }

    }

}
