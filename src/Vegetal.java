import java.lang.reflect.InvocationTargetException;
import java.util.Random;

public abstract class Vegetal extends Organisme{

    private boolean empoisonne; // indique si le végétal est empoisonné
    private boolean vivant; // indique si le végétal est vivant
    private boolean comestible; // indique si le végétal est comestible
    private int nbGraines; // indique le nombre de graines pour la reproduction
    private int dureeVie; // la durée de vie (décroissant)

    // constructeur de la classe Vegetal
    public Vegetal(Ecosysteme ecosysteme) {
        super(ecosysteme); // =constructeur =classe parente
    }

    // getter et setter pour la classe Vegetal

    public boolean isEmpoisonne() {
        return empoisonne;
    }

    public void setEmpoisonne(boolean empoisonne) {
        this.empoisonne = empoisonne;
    }

    public boolean isVivant() {
        return vivant;
    }

    public void setVivant(boolean vivant) {
        this.vivant = vivant;
    }

    public boolean isComestible() {
        return comestible;
    }

    public void setComestible(boolean comestible) {
        this.comestible = comestible;
    }

    public int getNbGraines() {
        return nbGraines;
    }

    public void setNbGraines(int nbGraines) {
        this.nbGraines = nbGraines;
    }

    public int getDureeVie() {
        return dureeVie;
    }

    public void setDureeVie(int dureeVie) {
        this.dureeVie = dureeVie;
    }


    @Override
    public String toString() { // méthode pour afficher sous forme de str
        return "Vegetal{" +
                super.toString() +
                ", espece=" + getClass().getSimpleName() +
                ", empoisonne=" + empoisonne +
                ", vivant=" + vivant +
                ", comestible=" + comestible +
                ", nbGraines=" + nbGraines +
                ", dureeVie=" + dureeVie +
                '}';
    }

    // méthode pour gérer le fait d'être mangé par un animal
    public void estMange(Animal animalMangeur) {

        // si le végétal mangé est empoisonné
        if (this.isEmpoisonne()) {
            // si l'animal mangeur n'est pas déjà empoisonné
            if (!(animalMangeur.isEmpoisonne())){
                System.out.println("L'animal d'ID " + animalMangeur.getId() +
                        " et d'espèce " + animalMangeur.getClass().getSimpleName() +
                        " a été empoisonné en mangeant le végétal d'ID " + this.getId() +
                        " et d'espèce " + this.getClass().getSimpleName());
                // empoisonne l'animal mangeur
                animalMangeur.setEmpoisonne(true);
                animalMangeur.setPoisonDepuis(0);
            }
        }

        // le végétal mangé meurt
        this.mourrir();


        // print pour suivre l'évolution de l'éco
        System.out.println("Le végétal ID " + this.getId() + " d'espèce " +
                this.getClass().getSimpleName() + " est mangé par l'animal ID "
                + animalMangeur.getId() + " d'espèce " + animalMangeur.getClass().getSimpleName()
                + " et disparaît de l'écosystème.");

        // enlève la référence à l'écosystème
        this.setEcosysteme(null);
    }


    // méthode pour vieillir
    public void vieillir(){

        // la durée de vie diminue
        if (this.getDureeVie() > 0){
            this.setDureeVie(this.getDureeVie()-1);
        }

        // quand le végétal meurt on le sort de l'écosystème
        if (this.getDureeVie() ==0){
            this.mourrir();
        }
    }


    // méthode pour mourrir
    public void mourrir(){

        // le végétal est mort
        this.setVivant(false);

        if (this.getEcosysteme() != null){
            // supprime l'instance du végétal de la liste des espèces
            this.getEcosysteme().supprimerListeIndividuEspece(this);
            // supprime le végétal de l'éco
            this.getEcosysteme().supprimerVegetal(this);
            this.setEcosysteme(null);
        }

        // print pour suivre l'évolution de l'éco
        System.out.println("Le végétal d'ID " + this.getId() + " d'espèce "
                + this.getClass().getSimpleName() + " est mort.");

    }


    // méthode pour définir la reproduction
    public boolean conditionSeReproduire(){

        // génération d'un objet Random
        Random rand = new Random();

        // génère un nombre aléatoire
        int randomNumber = rand.nextInt(6);

        // si le nombre est 0, retourne true
        // 15% de chance de vouloir se reproduire
        return randomNumber == 0;
    }


    // méthode pour la reproduction
    public void seReproduire() throws NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException {

        // sort si les conditions ne sont pas réunies
        if (!this.isVivant()
                || this.getEcosysteme() == null
                || !this.conditionSeReproduire()
                || this.getNbGraines() ==0 ){
            return; // sort
        }

        // si les conditions sont réunies
        // avec la refléxion, crée une nouvelle instance du végétal
        Vegetal nouveauNe = this.getClass().getDeclaredConstructor(Ecosysteme.class).
                newInstance(this.getEcosysteme());

        // on diminue le nb de graines du végétal qui s'est reproduite
        this.setNbGraines(this.getNbGraines() -1);

        // print pour suivre l'évolution de l'éco
        System.out.println("Le végétal d'espèce " + this.getClass().getSimpleName() +
                " d'ID " + this.getId() + " s'est reproduit.");

        // print pour suivre facilement l'évolution de l'éco
        System.out.println("Un végétal d'espèce " +  nouveauNe.getClass().getSimpleName() +
                " et d'ID " + nouveauNe.getId() + " a été ajouté à l'écosystème");
    }


    // méthode pour le passage du temps
    public void vivreUnJour() throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        // les végétaux vieillissent et se reproduisent
        this.vieillir();
        this.seReproduire();
    }

}
