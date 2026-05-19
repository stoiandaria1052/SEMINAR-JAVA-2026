/* * NOTITE TEORIE:
 * Exceptie: un eveniment care apare in timpul executiei unui program si i intrerupe rularea
 * Ex: index invalid, referinte nule, file not found, invalid user input
 * Eroare: executia programului se inchide complet. (Nu pot fi tratate)
 * Exceptiile: pot fi tratate ca rularea sa continue.
 * * Throwable -> 1. Errors
 * -> 2. Exceptions (pot fi tratate):
 * - RuntimeExceptions (NullPointerException)
 * - CheckedExceptions (IOException, SQLException)
 *
 * In interioriul blocului catch: la prima exceptie intalnita iese, nu mai continua.
 * Continua doar cand iese din catch (sau in finally).
 */

public class Main {
    public static void main(String[] args) {

        Car myCar = new Car("Ford", 350.0, "10", 5000, false);
        myCar.setRented(true);

        try {
            myCar.rent();
        } catch (Exception e) {
            // afiseaza mesajul erorii preluat din clasa
            System.out.println(e.getMessage());
        } finally {
            // finally se va executa mereu, indiferent daca s-a prins sau nu o exceptie
            // util pentru inchiderea unor conexiuni/resurse
            System.out.println("Acest bloc se executa intotdeauna.");
        }
    }
}