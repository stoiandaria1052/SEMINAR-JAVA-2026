package ro.ase.parcauto;

/*
 * Seminar 3: clasa abstracta - nu poate fi instantiata direct
  - obligatoriu sa contina cel putin o metoda abstracta
  - subclasele trebuie sa implementeze metodele abstracte

  Seminar 4: tratarea exceptiilor cu throw/throws
  Ierarhia: Throwable -> Error (nu poate fi tratat)
                      -> Exception -> RuntimeException (NullPointerException, IllegalArgumentException, ...)
                                   -> Checked (IOException, SQLException, ...)
 */
public abstract class Vehicul {

    // enum pentru tipul de combustibil - in loc de String avem validare automata
    public enum TipCombustibil { BENZINA, MOTORINA, ELECTRIC, HIBRID }

    private final String numarInmatriculare;   // identificator unic
    private String producator;
    private double vitezaMaxima;
    private int kilometraj;
    private TipCombustibil combustibil;
    private boolean esteInchiriat;

    protected Vehicul(String numarInmatriculare, String producator, double vitezaMaxima,
                      int kilometraj, TipCombustibil combustibil) {
        this.numarInmatriculare = numarInmatriculare;
        this.producator = producator;
        this.vitezaMaxima = vitezaMaxima;
        this.kilometraj = kilometraj;
        this.combustibil = combustibil;
        this.esteInchiriat = false;
    }

    // metoda concreta, comuna pentru toate vehiculele
    public void deplasare() {
        System.out.println("[" + numarInmatriculare + "] " + producator + " se deplaseaza...");
    }

    /* Seminar 4: aruncam o exceptie cu throw
     IllegalStateException e RuntimeException -> nu trebuie declarata cu throws,
     dar e bine sa o documentam ca sa stie apelantul ce sa prinda. */
    public void inchiriere() {
        if (esteInchiriat) {
            throw new IllegalStateException("Vehiculul " + numarInmatriculare + " este deja inchiriat!");
        }
        esteInchiriat = true;
    }

    public void returnare(int kilometriParcursi) {
        // verificam in ordine: stare invalida, apoi input invalid
        if (!esteInchiriat) {
            throw new IllegalStateException("Vehiculul " + numarInmatriculare + " nu este inchiriat, nu poate fi returnat!");
        }
        if (kilometriParcursi <= 0) {
            throw new IllegalArgumentException("Numarul de kilometri parcursi trebuie sa fie pozitiv, primit: " + kilometriParcursi);
        }
        kilometraj += kilometriParcursi;
        esteInchiriat = false;
    }

    // metode abstracte - fiecare subclasa decide propria logica
    public abstract boolean necesitaService();
    public abstract double pretInchiriere(int zile);
    public abstract String tipVehicul();

    // getters / setters
    public String getNumarInmatriculare() { return numarInmatriculare; }
    public String getProducator() { return producator; }
    public void setProducator(String producator) { this.producator = producator; }
    public double getVitezaMaxima() { return vitezaMaxima; }
    public void setVitezaMaxima(double vitezaMaxima) { this.vitezaMaxima = vitezaMaxima; }
    public int getKilometraj() { return kilometraj; }
    public TipCombustibil getCombustibil() { return combustibil; }
    public boolean esteInchiriat() { return esteInchiriat; }

    @Override
    public String toString() {
        return tipVehicul() + " " + producator + " [" + numarInmatriculare + "] - "
                + kilometraj + " km, " + combustibil
                + (esteInchiriat ? " (INCHIRIAT)" : "");
    }
}
