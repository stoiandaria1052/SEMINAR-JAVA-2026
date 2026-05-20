package ro.ase.parcauto;

public class Camion extends Vehicul {

    private final int numarAxe;
    private final double tonajMaxim;        // capacitate maxima in tone

    public Camion(String numarInmatriculare, String producator, double vitezaMaxima, int kilometraj,
                  TipCombustibil combustibil, int numarAxe, double tonajMaxim) {
        super(numarInmatriculare, producator, vitezaMaxima, kilometraj, combustibil);
        this.numarAxe = numarAxe;
        this.tonajMaxim = tonajMaxim;
    }

    @Override
    public boolean necesitaService() {
        // camioanele mai mult kilometraj intre service-uri (15.000 km)
        return getKilometraj() >= 15_000;
    }

    @Override
    public double pretInchiriere(int zile) {
        // pret per zi proportional cu numarul de axe si tonajul
        return (75.0 + 10.0 * numarAxe + 3.0 * tonajMaxim) * zile;
    }

    @Override
    public String tipVehicul() {
        return "Camion";
    }

    @Override
    public void deplasare() {
        System.out.println("Camionul " + getProducator() + " transporta " + tonajMaxim + " tone.");
    }

    public int getNumarAxe() { return numarAxe; }
    public double getTonajMaxim() { return tonajMaxim; }
}
