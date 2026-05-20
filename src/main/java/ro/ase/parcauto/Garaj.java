package ro.ase.parcauto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/* Seminar 5: ArrayList - structura dinamica, flexibila (spre deosebire de array fix)
 Nu mai trebuie sa tinem manual o variabila "size" - lista stie singura cati membri are*/
public class Garaj {

    private final String denumire;
    private final List<Vehicul> flota = new ArrayList<>();   // lista dinamica
    private final int capacitateMaxima;

    public Garaj(String denumire, int capacitateMaxima) {
        this.denumire = denumire;
        this.capacitateMaxima = capacitateMaxima;
    }

    public boolean adauga(Vehicul v) {
        if (flota.size() >= capacitateMaxima) {
            System.out.println("Garajul " + denumire + " este plin (max " + capacitateMaxima + ").");
            return false;
        }
        // verificare duplicat dupa numarul de inmatriculare
        if (cautaDupaNumar(v.getNumarInmatriculare()).isPresent()) {
            System.out.println("Exista deja un vehicul cu numarul " + v.getNumarInmatriculare());
            return false;
        }
        flota.add(v);
        System.out.println("Adaugat: " + v);
        return true;
    }

    /* Optional<T> - util pentru a NU returna null direct
     Forteaza apelantul sa trateze explicit cazul "nu exista" si previne NullPointerException */
    public Optional<Vehicul> cautaDupaNumar(String numar) {
        return flota.stream()
                .filter(v -> v.getNumarInmatriculare().equalsIgnoreCase(numar))
                .findFirst();
    }

    public void inchiriaza(String numar) {
        cautaDupaNumar(numar).ifPresentOrElse(
                v -> {
                    try {
                        v.inchiriere();
                        System.out.println("Inchiriere reusita: " + numar);
                    } catch (RuntimeException ex) {
                        // Seminar 4: prindem exceptia si printam mesajul ei
                        System.out.println("ESEC inchiriere: " + ex.getMessage());
                    }
                },
                () -> System.out.println("Vehicul inexistent: " + numar)
        );
    }

    public void returneaza(String numar, int kilometriParcursi) {
        cautaDupaNumar(numar).ifPresentOrElse(
                v -> {
                    try {
                        v.returnare(kilometriParcursi);
                        System.out.println("Returnat OK: " + numar + " (+ " + kilometriParcursi + " km)");
                    } catch (RuntimeException ex) {
                        System.out.println("ESEC returnare: " + ex.getMessage());
                    }
                },
                () -> System.out.println("Vehicul inexistent: " + numar)
        );
    }

    public List<Vehicul> disponibile() {
        return flota.stream()
                .filter(v -> !v.esteInchiriat())
                .collect(Collectors.toList());
    }

    public List<Vehicul> auNevoieDeService() {
        return flota.stream()
                .filter(Vehicul::necesitaService)
                .collect(Collectors.toList());
    }

    public void estimeazaPret(String numar, int zile) {
        cautaDupaNumar(numar).ifPresentOrElse(
                v -> System.out.println("Estimare " + numar + " / " + zile + " zile = "
                        + String.format("%.2f", v.pretInchiriere(zile)) + " lei"),
                () -> System.out.println("Vehicul inexistent: " + numar)
        );
    }

    public void afiseazaRaport() {
        System.out.println("\nRaport garaj '" + denumire + "' (" + flota.size() + "/" + capacitateMaxima + ")");
        flota.forEach(System.out::println);
        System.out.println("Disponibile: " + disponibile().size());
        System.out.println("Au nevoie de service: " + auNevoieDeService().size());
    }
}
