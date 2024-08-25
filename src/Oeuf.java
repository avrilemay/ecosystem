import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Oeuf extends Organisme {
    private int age = 0; // l'oeuf a 0 au début
    private Class<?> espece; // espèce de l'oeuf à éclore
    private boolean fertilise = false; // oeuf non fertilisé par défaut
    private int idMere; // ID de la mère
    private Integer idPere = null; // ID du père (null par défaut si pas de père)
    private int tailleMere; // taille de la mère
    private int poidsMere; // poids de la mère
    private boolean mereEmpoisonne; // mère est empoisonnée?
    private int mereVitesse; // vitesse de la mère
    private int mereNbPetits; // nb d'oeufs pondus par la mère
    private Integer taillePere = null; // (null par défaut si pas de père)
    private Integer poidsPere = null; // (null par défaut si pas de père)
    private boolean pereEmpoisonne;
    private Integer pereVitesse = null;; // (null par défaut si pas de père)
    private Integer pereNbPetits; // nb d'oeufs fécondés par le père

    // constructeur de la classe Oeuf
    public Oeuf(Ecosysteme ecosysteme, int idMere, Class espece) {
        super(ecosysteme); // constructeur classe parente
        this.idMere = idMere; // ID de la mère qui a pondu l'oeuf
        this.espece = espece; // espèce de l'animal à naître

        // on récupère la mère d'après son ID
        Animal mere = this.getEcosysteme().getAnimalParId(idMere);
        if (mere != null) { // si la mère existe
            // on extrait les infos nécessaires
            this.tailleMere = mere.getTaille();
            this.poidsMere = mere.getPoids();
            this.mereEmpoisonne = mere.isEmpoisonne();
            this.mereVitesse = mere.getVitesse();
            this.mereNbPetits = mere.getNbPetits();
        } else {
            // gestion de l'erreur
            throw new IllegalStateException("Aucun animal correspondant à l'ID de la mère trouvé.");
        }

        // ajoute l'oeuf à l'écosystème
        this.getEcosysteme().ajouterOeuf(this);
    }


    // méthodes getter et setter pour la classe Oeuf

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Class<?> getEspece() {
        return espece;
    }

    public void setEspece(Class<?> espece) {
        this.espece = espece;
    }

    public boolean isFertilise() {
        return fertilise;
    }

    public void setFertilise(boolean fertilise) {
        this.fertilise = fertilise;
    }

    public int getIdMere() {
        return idMere;
    }

    public void setIdMere(int idMere) {
        this.idMere = idMere;
    }

    public Integer getIdPere() {
        return idPere;
    }

    public void setIdPere(Integer idPere) {
        this.idPere = idPere;
    }

    public int getTailleMere() {
        return tailleMere;
    }

    public void setTailleMere(int tailleMere) {
        this.tailleMere = tailleMere;
    }

    public int getPoidsMere() {
        return poidsMere;
    }

    public void setPoidsMere(int poidsMere) {
        this.poidsMere = poidsMere;
    }

    public boolean isMereEmpoisonne() {
        return mereEmpoisonne;
    }

    public void setMereEmpoisonne(boolean mereEmpoisonne) {
        this.mereEmpoisonne = mereEmpoisonne;
    }

    public int getMereVitesse() {
        return mereVitesse;
    }

    public void setMereVitesse(int mereVitesse) {
        this.mereVitesse = mereVitesse;
    }

    public int getMereNbPetits() {
        return mereNbPetits;
    }

    public void setMereNbPetits(int mereNbPetits) {
        this.mereNbPetits = mereNbPetits;
    }

    public Integer getTaillePere() {
        return taillePere;
    }

    public void setTaillePere(Integer taillePere) {
        this.taillePere = taillePere;
    }

    public Integer getPoidsPere() {
        return poidsPere;
    }

    public void setPoidsPere(Integer poidsPere) {
        this.poidsPere = poidsPere;
    }

    public boolean isPereEmpoisonne() {
        return pereEmpoisonne;
    }

    public void setPereEmpoisonne(boolean pereEmpoisonne) {
        this.pereEmpoisonne = pereEmpoisonne;
    }

    public Integer getPereVitesse() {
        return pereVitesse;
    }

    public void setPereVitesse(Integer pereVitesse) {
        this.pereVitesse = pereVitesse;
    }

    public Integer getPereNbPetits() {
        return pereNbPetits;
    }

    public void setPereNbPetits(Integer pereNbPetits) {
        this.pereNbPetits = pereNbPetits;
    }


    @Override
    public String toString() { // méthode pour afficher sous format str
        return "Oeuf{" +
                super.toString() +
                ", age=" + age +
                ", espece=" + espece.getSimpleName() +
                ", fertilise=" + fertilise +
                ", idMere=" + idMere +
                ", idPere=" + idPere +
                ", tailleMere=" + tailleMere +
                ", poidsMere=" + poidsMere +
                ", mereEmpoisonne=" + mereEmpoisonne +
                ", mereVitesse=" + mereVitesse +
                ", mereNbPetits=" + mereNbPetits +
                ", taillePere=" + taillePere +
                ", poidsPere=" + poidsPere +
                ", pereEmpoisonne=" + pereEmpoisonne +
                ", pereVitesse=" + pereVitesse +
                ", pereNbPetits=" + pereNbPetits +
                '}';
    }


    // méthode pour la fertilisation de l'oeuf
    public void estFertilise(Animal animalPere) {

        // si les conditions ne sont pas remplies
        if (animalPere.getSexe() == Sexe.FEMELLE
                && !animalPere.isVivant()
                && !this.getEspece().getSimpleName().equals(animalPere.getClass().getSimpleName())
                && this.getEcosysteme() == null
                && animalPere.getEcosysteme() == null
                && this.getEcosysteme() != animalPere.getEcosysteme()){
            return;
        }

        // si les conditions sont remplies
        // la fertilisation a lieu
        this.setFertilise(true);

        // l'animal fertilisateur devient le père de l'oeuf
        // on rajoute les informations relatives au père
        this.setIdPere(animalPere.getId());
        this.setTaillePere(animalPere.getTaille());
        this.setPoidsPere(animalPere.getPoids());
        this.setPereEmpoisonne(animalPere.isEmpoisonne());
        this.setPereVitesse(animalPere.getVitesse());
        this.setPereNbPetits(animalPere.getNbPetits());

    }

    // méthode pour gérer le fait d'être mangé par un animal
    public void estMange(Animal animalMangeur){
        // retire l'oeuf de l'écosystème
        this.getEcosysteme().supprimerOeuf(this);
        // enlève la référence à l'écosystème
        this.setEcosysteme(null);

        // print pour suivre l'éco
        System.out.println("L'oeuf d'ID " + this.getId()+ " a été mangé " +
                "par l'animal d'ID " +
                animalMangeur.getId() + " et d'espèce " + animalMangeur.
                getClass().getSimpleName()
                + " et disparaît de l'écosystème.");
    }


    // méthode pour gérer le fait de pourrir
    public void oeufPourri() {

        // si conditions non remplies, sort
        if (this.getAge() < 5 || this.getEcosysteme() == null) {
            return;
        }

        // sinon, pourrit
        // print pour suivre l'évolution de l'éco
        System.out.println("L'oeuf d'ID " + this.getId() + " et d'espèce à éclore "
                + this.getEspece().getSimpleName() + " a pourri.");

        // si l'écosystème de l'oeuf n'est pas nul
        if (this.getEcosysteme() != null) {
            // il pourrit donc on le retire de l'éco
            this.getEcosysteme().supprimerOeuf(this);
            // on passe son éco à null
            this.setEcosysteme(null);
        }
    }

    // méthode pour gérer l'éclosion
    public void eclore() throws NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {

        // si l'oeuf a 3 jours, est fécondé et appartient à un écosystème
        if (this.getAge() == 3 && this.isFertilise()
                && this.getEcosysteme() != null && this.getEspece() != null) {

            // initie un objet Random
            Random rand = new Random();

            // définit les caractéristiques de l'animal à naître de façon aléatoire
            // parmi les caractéristiques des parents
            // pour les champs héritables
            int tailleBebe = rand.nextBoolean() ? this.getTailleMere() : this.getTaillePere();
            int poidsBebe = rand.nextBoolean() ? this.getPoidsMere() : this.getPoidsPere();
            boolean empoisonneBebe = rand.nextBoolean() ? this.isMereEmpoisonne() : this.isPereEmpoisonne();
            int vitesseBebe = rand.nextBoolean() ? this.getMereVitesse() : this.getPereVitesse();
            // nb d'oeufs à pondre si femelle et nombre d'oeufs à féconder si mâle
            int nbPetitsBebe = rand.nextBoolean() ? this.getMereNbPetits() : this.getPereNbPetits();

            // on récupère le constructeur de l'espèce à naître de l'oeuf
            Constructor<? extends Animal> constructor = (Constructor<? extends Animal>)
                    this.getEspece().getDeclaredConstructor(Ecosysteme.class);

            // le constructeur est accessible
            constructor.setAccessible(true);

            // on crée un nouvel animal de l'espèce souhaitée
            Animal nouveauNe = constructor.newInstance(this.getEcosysteme());

            // attribue au nouveau-né les caractéristiques héritées aléatoirement
            nouveauNe.setTaille(tailleBebe);
            nouveauNe.setPoids(poidsBebe);
            nouveauNe.setEmpoisonne(empoisonneBebe);
            // si le nouveau né est empoisonné de ses parents, on initialise à 0
            if (nouveauNe.isEmpoisonne()){
                nouveauNe.setPoisonDepuis(0);
            }
            nouveauNe.setVitesse(vitesseBebe);
            nouveauNe.setNbPetits(nbPetitsBebe);
            nouveauNe.setPere(this.getIdPere());
            nouveauNe.setMere(this.getIdMere());

            // print pour suivre l'évolution de l'éco
            System.out.println("L'oeuf de " + this.getEspece().getSimpleName() + " d'ID "
                    + this.getId() + " a éclot.");

            // print pour suivre facilement l'évolution de l'éco
            System.out.println("Un petit d'espèce " +  nouveauNe.getClass().getSimpleName() +
                    " et d'ID " + nouveauNe.getId() + " est né et a été ajouté à l'écosystème");

            // retire l'oeuf de l'écosystème
            this.getEcosysteme().supprimerOeuf(this);
            // enlève la référence à l'écosystème
            this.setEcosysteme(null);
        }
    }

    // méthode pour gérer le vieillissement de l'oeuf
    public void vieillir() {
        // l'âge de l'oeuf augmente
        this.setAge(this.getAge()+1);
    }

    // méthode pour le passage du temps
    public void vivreUnJour() throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        // l'oeuf vieillit, éclot (peut-être) ou pourrit (peut-être)
        this.vieillir();
        this.eclore();
        this.oeufPourri();
    }


}


