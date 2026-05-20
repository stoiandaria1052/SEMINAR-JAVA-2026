package ro.ase.parcauto;

import ro.ase.parcauto.Vehicul.TipCombustibil;
import ro.ase.parcauto.Masina.TipTransmisie;

public class Principal {

    public static void main(String[] args) {

        // polimorfism (seminar 3)
        System.out.println("Polimorfism: array de Vehicul");
        Vehicul[] demo = {
                new Masina("B-100-AAA", "Dacia Logan", 180, 4500, TipCombustibil.BENZINA, 5, TipTransmisie.MANUALA),
                new Motocicleta("B-200-MMM", "Kawasaki", 280, 3200, TipCombustibil.BENZINA, 1000),
                new Camion("B-300-TTT", "MAN TGX", 110, 8000, TipCombustibil.MOTORINA, 4, 18.5)
        };

        for (Vehicul v : demo) v.deplasare();

        // equals (seminar 4)
        System.out.println("\nComparare masini cu equals()");
        Masina ma = new Masina("B-001-AAA", "Skoda Octavia", 200, 1000, TipCombustibil.MOTORINA, 5, TipTransmisie.AUTOMATA);
        Masina mb = new Masina("B-002-AAA", "Skoda Octavia", 200, 9000, TipCombustibil.MOTORINA, 5, TipTransmisie.AUTOMATA);
        Masina mc = new Masina("B-003-AAA", "Ford Focus",    170, 0,    TipCombustibil.BENZINA,  5, TipTransmisie.MANUALA);
        System.out.println("ma.equals(mb) = " + ma.equals(mb) + " (acelasi producator/transmisie/locuri)");
        System.out.println("ma.equals(mc) = " + ma.equals(mc));

        System.out.println("\nDemo Garaj");
        Garaj garaj = new Garaj("FlotaCentrala", 6);

        garaj.adauga(ma);
        garaj.adauga(mb);
        garaj.adauga(new Motocicleta("B-500-YAM", "Yamaha MT-09", 240, 7800, TipCombustibil.BENZINA, 850));
        garaj.adauga(new Camion("B-700-VOL", "Volvo FH", 100, 16500, TipCombustibil.MOTORINA, 5, 24.0));
        garaj.adauga(mc);

        garaj.adauga(new Masina("B-001-AAA", "Alt producator", 100, 0, TipCombustibil.BENZINA, 4, TipTransmisie.MANUALA));

        System.out.println();
        garaj.estimeazaPret("B-001-AAA", 3);
        garaj.estimeazaPret("B-700-VOL", 7);

        // inchirieri si returnari (test pentru exceptii)
        System.out.println("\nInchirieri");
        garaj.inchiriaza("B-001-AAA");
        garaj.inchiriaza("B-500-YAM");
        garaj.inchiriaza("B-001-AAA");
        garaj.inchiriaza("XXXXX");

        // returnari
        System.out.println("\nReturnari");
        garaj.returneaza("B-001-AAA", 420);
        garaj.returneaza("B-002-AAA", 100);
        garaj.returneaza("B-500-YAM", -5);

        garaj.afiseazaRaport();
    }
}
