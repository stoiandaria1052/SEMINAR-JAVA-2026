package ro.ase.parcauto;

public class Motocicleta extends Vehicul {

    private final int capacitateCilindrica;   // ex: 600, 1000 cc

    public Motocicleta(String numarInmatriculare, String producator, double vitezaMaxima, int kilometraj,
                       TipCombustibil combustibil, int capacitateCilindrica) {
        super(numarInmatriculare, producator, vitezaMaxima, kilometraj, combustibil);
        this.capacitateCilindrica = capacitateCilindrica;
    }

    @Override
    public boolean necesitaService() {
        // motocicletele au service mai des - la 6.000 km
        return getKilometraj() >= 6_000;
    }

    @Override
    public double pretInchiriere(int zile) {
        // pret de baza 30 lei/zi + crestere proportionala cu motorul
        return (30.0 + 0.02 * capacitateCilindrica) * zile;
    }

    @Override
    public String tipVehicul() {
        return "Motocicleta";
    }

    @Override
    public void deplasare() {
        System.out.println("Motocicleta " + getProducator() + " (" + capacitateCilindrica + "cc) zboara!");
    }

    public int getCapacitateCilindrica() { return capacitateCilindrica; }
}
