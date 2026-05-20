package ro.ase.parcauto;

import java.util.Objects;

/* Seminar 3: extinde clasa abstracta Vehicul si implementeaza metodele abstracte
 Seminar 4: override equals() pentru a putea compara doua masini pe baza de continut */
public class Masina extends Vehicul {

    public enum TipTransmisie { MANUALA, AUTOMATA }

    private final int numarLocuri;
    private final TipTransmisie transmisie;

    public Masina(String numarInmatriculare, String producator, double vitezaMaxima, int kilometraj,
                  TipCombustibil combustibil, int numarLocuri, TipTransmisie transmisie) {
        super(numarInmatriculare, producator, vitezaMaxima, kilometraj, combustibil);
        this.numarLocuri = numarLocuri;
        this.transmisie = transmisie;
    }

    @Override
    public boolean necesitaService() {
        // pentru masini service la fiecare 10.000 km
        return getKilometraj() >= 10_000;
    }

    @Override
    public double pretInchiriere(int zile) {
        // pret de baza 45 lei/zi + 15% daca e automata + 10 lei/zi daca are peste 5 locuri
        double pretBaza = 45.0 * zile;
        if (transmisie == TipTransmisie.AUTOMATA) pretBaza *= 1.15;
        if (numarLocuri > 5) pretBaza += 10.0 * zile;
        return pretBaza;
    }

    @Override
    public String tipVehicul() {
        return "Masina";
    }

    @Override
    public void deplasare() {
        System.out.println("Masina " + getProducator() + " accelereaza pana la " + getVitezaMaxima() + " km/h.");
    }

    /* Seminar 4: override equals - doua masini sunt "egale" daca au acelasi
     producator, transmisie si numar de locuri (NU si numarul de inmatriculare, care e unic).
     Daca nu suprascriem equals, comportamentul implicit ar fi comparare referinte (==) */
    @Override
    public boolean equals(Object alt) {
        if (this == alt) return true;
        if (!(alt instanceof Masina)) return false;
        Masina m = (Masina) alt;
        return numarLocuri == m.numarLocuri
                && transmisie == m.transmisie
                && Objects.equals(getProducator(), m.getProducator());
    }

    @Override
    public int hashCode() {
        // contract: daca equals returneaza true, hashCode trebuie sa fie egal
        return Objects.hash(getProducator(), numarLocuri, transmisie);
    }

    public int getNumarLocuri() { return numarLocuri; }
    public TipTransmisie getTransmisie() { return transmisie; }
}
