public abstract class Organisme {
    private static int prochainId = 0; // Générateur d'ID commun
    private int id; // ID de l'organisme
    private Ecosysteme ecosysteme; // Écosystème de l'organisme

    public Organisme(Ecosysteme ecosysteme) { // constructeur classe Organisme
        this.id = prochainId; // assignation de l'ID
        prochainId++; // incrémentation
        this.ecosysteme = ecosysteme;
    }

    // getter et setter

    public int getId() {
        return id;
    }

    public Ecosysteme getEcosysteme() {
        return ecosysteme;
    }

    public void setEcosysteme(Ecosysteme ecosysteme) {
        this.ecosysteme = ecosysteme;
    }

    @Override
    public String toString() {
        String nomEcosysteme = (this.getEcosysteme() != null) ? this.getEcosysteme().getNom() : null;
        return "Organisme{" +
                "id=" + id +
                ", ecosysteme=" + nomEcosysteme +
                '}';
    }
}