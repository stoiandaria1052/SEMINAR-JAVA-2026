import java.sql.Array;
import java.util.ArrayList;
import java.util.*; //trebuie neaparat ca sa putem adauga liste

/* =========================================================================
 * NOTITE TEORIE:
 * * Colectii: o solutie complexa de structuri de date pentru manipularea obiectelor.
 * Adauga functionalitati de array-uri dinamice.
 * * Liste: structuri de date dinamice.
 * Este mai usor sa recuperezi date dintr-un ArrayList decat dintr-un LinkedList.
 * ArrayList este cea mai utilizata implementare.
 * - sort(): metoda incorporata (built-in), ruleaza in mod implicit.
 * - Iteratorul: se creeaza pe baza unei colectii; are rolul de a parcurge (itera).
 * - next(): returneaza obiectul curent si valideaza ca mai exista si altele dupa el.
 * =========================================================================
 * * Seturi: setul contine doar elemente unice.
 * Ca sa generezi un set, trebuie sa il transformi dintr-o lista sau o structura similara.
 * HashSet este implementarea standard folosita pentru seturi.
 * Pastreaza elemente unice, fara a pastra o ordine specifica a acestora.
 * =========================================================================
 * * HashMap: similar cu structura de dictionar (dict) din Python.
 * Functioneaza pe sistemul cheie-valoare.
 * Se utilizeaza in principal metodele put() si remove().
 * Modul de parcurgere si extragere a datelor pentru un hashmap "hm":
 * for(Map.Entry<String,Integer> entry : hm.entrySet()){
 * System.out.println(entry.getKey());
 * System.out.println(entry.getValue());
 * }
 */

public class ExSeminar {
    public static void main(String[] args) {

        //1. Create an ArrayList<String> of student names

        //Add at least 5 names
        List<String> listaStudenti = new ArrayList<>();
        listaStudenti.add("Ionel");
        listaStudenti.add("Gigel");
        listaStudenti.add("Costel");
        listaStudenti.add("Florinel");
        listaStudenti.add("Titi");

        //Print all names
        System.out.println(listaStudenti); // printează toată lista

        // listaStudenti.stream().forEach(x -> System.out.println(x)); // printează elementele listei pe câte un rând
        //
        // for(String s : listaStudenti) // printează elementele listei pe câte un rând
        //     System.out.println(s);


        //Remove the 3rd name
        listaStudenti.remove(2);
        System.out.println(listaStudenti);


        //2. Sum of Integers

        // Create a List<Integer>
        List<Integer> colectieNumere = new ArrayList<>();

        //Add 10 numbers
        for (int k = 0; k < 10; k++) {
            colectieNumere.add(k);
        }
        System.out.println(colectieNumere);

        // Calculate the sum and average
        // stream - transformă dintr-un array într-o succesiune de numere
        // mapToInt: Returnează un IntStream format din rezultatele aplicării funcției date asupra elementelor acestui stream
        int sum = colectieNumere.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);

        // Păstrat exact aceeași comandă repetată pentru medie, așa cum era în original
        float avg = (colectieNumere.stream().mapToInt(Integer::intValue).sum()) / (float) colectieNumere.size();
        System.out.println(avg);


        //3. Reverse a list:    Given a list of integers, reverse it manually
       // for(int k = 0; k < colectieNumere.size() / 2; k++)
        // {
        //     int aux = colectieNumere.get(k);
        //     colectieNumere.add(k, colectieNumere.get(colectieNumere.size() - k - 1));
        //     colectieNumere.add(colectieNumere.size() - k - 1, aux);
        // }
        // System.out.println(colectieNumere);


        //4. Unique Words Counter
        //Given a sentence, split it into words
        Set<String> multimeCuvinte = new HashSet<>();
        multimeCuvinte.add("seminarul 5 de java wow");
        System.out.println(multimeCuvinte);

        String[] tablouStringuri = new String[multimeCuvinte.size()];

    }
}