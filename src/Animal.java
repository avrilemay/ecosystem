import java.lang.reflect.InvocationTargetException;
import java.util.*;

public abstract class Animal extends Organisme {
    private int age = 0; // l'animal a 0 an lorsqu'il naît
    private int taille; // taille de l'animal
    private int poids; // poids de l'animal

    // crée un objet Random
    private Random rand = new Random();
    // le sexe de l'animal est choisi au hasard
    private Sexe sexe = rand.nextBoolean() ? Sexe.FEMELLE : Sexe.MALE;
    private boolean empoisonne = false; // l'animal n'est pas empoisonné à la naissance
    private boolean vivant = true; // l'animal est vivant à la naissance
    private int vitesse; // vitesse de l'animal
    private int esperanceVie; // espérance de vie (décroissante)
    private int faim = 10; // faim de l'animal initialisée à 10
    private Integer poisonDepuis = null; // NA si non empoisonné
    private Integer pere = null; // l'ID du pere (null par défaut, si pas de parent)
    private Integer mere = null; // l'ID de la mere (null par défaut, si pas de parent)
    private Integer nbPetits = null; // nombre de petits ou oeufs par reproduction
    private Set<Regime> regimes; // régime(s) alimentaire
    private Reproduction reproduction; // mode de reproduction

    // constructeur de la classe Animal
    public Animal(Ecosysteme ecosysteme, Set<Regime> regimes) {
        super(ecosysteme); // constructeur de la classe parente
        this.regimes = regimes;
    }

    // getter et setter

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

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

    public int getVitesse() {
        return vitesse;
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

    public int getEsperanceVie() {
        return esperanceVie;
    }

    public void setEsperanceVie(int esperanceVie) {
        this.esperanceVie = esperanceVie;
    }

    public int getFaim() {
        return faim;
    }

    public void setFaim(int faim) {
        this.faim = faim;
    }

    public int getPoisonDepuis() {
        return poisonDepuis;
    }

    public void setPoisonDepuis(int poisonDepuis) {
        this.poisonDepuis = poisonDepuis;
    }

    public Integer getPere() {
        return pere;
    }

    public void setPere(Integer pere) {
        this.pere = pere;
    }

    public Integer getMere() {
        return mere;
    }

    public void setMere(Integer mere) {
        this.mere = mere;
    }

    public Integer getNbPetits() {
        return nbPetits;
    }

    public void setNbPetits(Integer nbPetits) {
        this.nbPetits = nbPetits;
    }

    public Set<Regime> getRegimes() {
        return regimes;
    }

    public void setRegimes(Set<Regime> regimes) {
        this.regimes = regimes;
    }

    public Reproduction getReproduction() {
        return reproduction;
    }

    public void setReproduction(Reproduction reproduction) {
        this.reproduction = reproduction;
    }

    @Override
    public String toString() { // pour obtenir au format str
        return "Animal{" +
                super.toString() +
                ", espece=" + this.getClass().getSimpleName() +
                ", age=" + age +
                ", reproduction=" + reproduction.getClass().getSimpleName() +
                ", regimes=" + regimes.toString() +
                ", nbPetits=" + nbPetits +
                ", mere=" + mere +
                ", pere=" + pere +
                ", poisonDepuis=" + poisonDepuis +
                ", faim=" + faim +
                ", esperanceVie=" + esperanceVie +
                ", vitesse=" + vitesse +
                ", vivant=" + vivant +
                ", empoisonne=" + empoisonne +
                ", sexe=" + sexe +
                ", poids=" + poids +
                ", taille=" + taille +
                '}';
    }


    // méthode pour savoir si un animal implément un type de régime alimentaire
    public boolean suitRegime(Class<? extends Regime> regimeType) {
        // parcourt la liste des régimes alimentaires
        for (Regime regime : this.getRegimes()) {
            // retourne vrai si l'animal suit le régime recherché
            if (regimeType.isInstance(regime)) {
                // sinon retourne faux
                return true;
            }
        }
        return false;
    }


    // méthode pour gérer le fait d'être mangé par un animal
    public void estMange(Animal mangeur) {

        // si l'animal mangé est empoisonné
        if (this.isEmpoisonne()) {

            // si l'animal mangeur n'est pas déjà empoisonné
            if (!mangeur.isEmpoisonne()) {
                // empoisonne l'animal mangeur
                mangeur.setEmpoisonne(true);
                mangeur.setPoisonDepuis(0);
            }

            // print pour suivre l'évolution de l'éco
            System.out.println("L'animal d'ID " + mangeur.getId() + " d'espèce "
                    + mangeur.getClass().getSimpleName() + " a été empoisonné en mangeant " +
                    "l'animal d'ID " + this.getId() + " et d'espèce " + this.getClass().getSimpleName());
        }

        //  print pour suivre l'évolution de l'éco
        System.out.println("L'animal ID " + this.getId() + " d'espèce " +
                this.getClass().getSimpleName() + " est mangé par l'animal ID "
                + mangeur.getId() + " d'espèce " + mangeur.getClass().getSimpleName()
                + " et disparaît de l'écosystème.");

        // si l'animal mangé n'est pas déjà mort
        if (this.isVivant()) {
            // l'animal mangé meurt
            this.mourrir();
        }

        // si l'écosystème de l'animal n'est pas null
        if(this.getEcosysteme() !=null){
            // supprime l'instance de l'animal de la liste des espèces
            this.getEcosysteme().supprimerListeIndividuEspece(this);

            // supprime l'animal de l'écosystème
            this.getEcosysteme().supprimerAnimal(this);
            this.setEcosysteme(null); // met l'écosystème de l'animal à null
        }

    }


    // méthode pour gérer le temps qui passe (vieillir)
    public void vieillir() {

        // seulement les animaux vivants peuvent vieillir
        if (this.isVivant()) {

            // si en âge de mourir
            if (this.getEsperanceVie() == 0) {
                // l'animal meurt
                this.mourrir();
            }

            // si trop jeune pour mourir
            if (this.getEsperanceVie() > 0) {
                // l'espérance de vie diminue et l'âge augmente
                this.setEsperanceVie(this.getEsperanceVie() - 1);
                this.setAge(this.getAge() + 1);
            }

            // si l'animal meurt de faim
            if (this.getFaim() == 0) {
                this.mourrir();
            }

            // si l'animal n'a pas mangé
            if (this.getFaim() > 0) {
                // sa faim augmente
                this.setFaim(this.getFaim() - 1);
            }

            // si meurt à cause du poison
            if (this.isEmpoisonne()
                    && this.getPoisonDepuis() == 3) {
                this.mourrir();
            }

            // si est empoisonné
            if (this.isEmpoisonne()
                    && this.getPoisonDepuis() < 3) {
                this.setPoisonDepuis(this.getPoisonDepuis() + 1);
                // compte les jours depuis l'empoisonnement
            }
        }
    }

    // méthode pour gérer le fait de mourir
    public void mourrir() {

        // si l'animal est déjà mort, ne fait rien
        if (!isVivant()) {
            return;
        }

        this.setVivant(false); // l'animal meurt
        // on print pour suivre dans l'éco
        System.out.println("L'animal ID " + this.getId() + " d'espèce " +
                this.getClass().getSimpleName() + " est mort.");
        this.setEsperanceVie(0); // 0 espérance de vie
        this.setVitesse(0); // ni de vitesse
        this.setFaim(0); // ni de faim
        this.setNbPetits(null); // ni de petits à avoir
    }


    // méthode pour gérer le fait de vouloir se reproduire (25%)
    public boolean souhaiteSeReproduire() {
        // génération d'un objet Random
        Random rand = new Random();

        // génère un nombre aléatoire
        int randomNumber = rand.nextInt(3);

        // si le nombre est 0, retourne true
        // 25% de chance de vouloir se reproduire
        return randomNumber == 0;

    }


    // méthode pour manger selon le régime alimentaire de l'animal
    public void manger() {
        if (!this.isVivant() // vérifie les conditions: vivant, dans éco et a faim
                || this.getEcosysteme() == null
                || this.getFaim() > 5) {
            return; // sort si conditions non remplies pour se nourrir
        }

        List<Organisme> lstOrganismes = new ArrayList<>(this.getEcosysteme().getOrganismesDansEco());
        // obtient la liste des animaux
        Collections.shuffle(lstOrganismes);  // mélange pour obtenir un ordre aléatoire


        List<Regime> regimesList = new ArrayList<>(this.getRegimes()); // crée une liste à partir des régimes
        Collections.shuffle(regimesList);  // mélange pour obtenir un ordre aléatoire


        // parcourt les différents régimes alimentaires
        for (Regime regime : regimesList) {

            // la proie qui va être mangée
            Organisme proie = trouverProie(lstOrganismes, regime);
            if (proie != null) { // si la proie existe
                if (proie instanceof Animal) { // et est animal
                    ((Animal) proie).estMange(this);
                }
                if (proie instanceof Vegetal) { // et est végétal
                    ((Vegetal) proie).estMange(this);
                }
                if (proie instanceof Oeuf) { // et est un oeuf
                    ((Oeuf) proie).estMange(this);
                }

                this.setFaim(10); // remet la faim à 10 après avoir mangé
                return; // sort après avoir mangé une fois
            }
        }
    }


    // méthode pour renvoyer une proie dans l'éco selon le régime alimentaire
    private Organisme trouverProie(List<Organisme> organismes, Regime regime) {

        // pour chaque organisme de la liste des organismes de l'éco
        for (Organisme organisme : organismes) {

            // si Carnivore et proie animale
            if (regime instanceof Carnivore && organisme instanceof Animal) {
                Animal animalProie = (Animal) organisme;
                // pour que la proie puisse être mangée, l'animal doit être plus rapide
                if (regime.peutManger(animalProie)
                        && this.getVitesse() > animalProie.getVitesse()
                        && animalProie.getEcosysteme() == this.getEcosysteme()) {
                    return animalProie;
                }

            // pour les autres régimes alimentaires, vérifie si peut manger et éco
            } else if (regime.peutManger(organisme)
                    && organisme.getEcosysteme() == this.getEcosysteme()) {
                return organisme;
            }
        }
        return null; // aucune proie trouvée
    }


    // méthode pour gérer un jour qui passe
    public void vivreUnJour() throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        // l'animal vieillit, se reproduit et mange
        this.vieillir();
        this.getReproduction().seReproduire();
        this.manger();
    }


    // méthode pour donner naissance à une nouvelle instance d'un animal d'une espèce lors de la reproduction
    public void bebeDeReproduction(Animal mere, Animal pere) throws NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException {

        // les parents doivent être de la même classe/espèce
        if (this.getClass() != pere.getClass()) {
            throw new IllegalArgumentException("Les parents doivent être de la même espèce");
        }

        Random rand = new Random();
        Ecosysteme ecosystemeBebe = mere.getEcosysteme();  // les parents ont le même éco

        // choisit aléatoirement pour le bébé: la taille, le poids, s'il est empoisonné d'après les parents
        // et la vitesse
        int tailleBebe = rand.nextBoolean() ? mere.getTaille() : pere.getTaille();
        int poidsBebe = rand.nextBoolean() ? mere.getPoids() : pere.getPoids();
        boolean empoisonneBebe = rand.nextBoolean() ? mere.isEmpoisonne() : pere.isEmpoisonne();
        int vitesseBebe = rand.nextBoolean() ? mere.getVitesse() : pere.getVitesse();

        // avec la refléxion, crée une nouvelle instance de la classe des parents
        Animal nouveauNe = this.getClass().getDeclaredConstructor(Ecosysteme.class).newInstance(ecosystemeBebe);
        // print pour suivre
        System.out.println("Un petit d'espèce " + nouveauNe.getClass().getSimpleName() +
                " et d'ID " + nouveauNe.getId() + " est né.");

        // définit les attributs principaux
        nouveauNe.setTaille(tailleBebe);
        nouveauNe.setPoids(poidsBebe);
        nouveauNe.setEmpoisonne(empoisonneBebe);
        nouveauNe.setVitesse(vitesseBebe);
        // si le bébé a été empoisonné par ses parents
        // initialise poison depuis
        if (nouveauNe.isEmpoisonne()) {
            nouveauNe.setPoisonDepuis(0);
        }
        nouveauNe.setMere(mere.getId());
        nouveauNe.setPere(pere.getId());

        // si c'est une femelle, récupère l'attribut de la mère
        if (nouveauNe.getSexe() == Sexe.FEMELLE) {
            nouveauNe.setNbPetits(mere.getNbPetits());
        }

    }

}


