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
        for (int k = 0; k < colectieNumere.size() / 2; k++) {
            int aux = colectieNumere.get(k);
            colectieNumere.set(k, colectieNumere.get(colectieNumere.size() - k - 1));
            colectieNumere.set(colectieNumere.size() - k - 1, aux);
        }
        System.out.println(colectieNumere);

        //4. Unique Words Counter
        //Given a sentence, split it into words
        Set<String> multimeCuvinte = new HashSet<>();
        multimeCuvinte.add("seminarul 5 de java wow");
        System.out.println(multimeCuvinte);

        String[] tablouStringuri = new String[multimeCuvinte.size()];


        // 5. Word Frequency Counter
        // TEORIE: Structura de tip Map stochează perechi Cheie-Valoare și NU permite chei duplicate.
        // Metoda getOrDefault(cheie, valoareImplicita) este extrem de utilă:
        // - Dacă cheia există deja, îi returnează valoarea curentă.
        // - Dacă cheia NU există (e prima dată când găsim cuvântul), returnează valoarea implicită (0).

        Map<String, Integer> wordFrequency = new HashMap<>();
        String sentence = "apple banana apple orange banana apple";
        String[] words = sentence.split(" ");

        for (String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }

        System.out.println("Frecventa cuvinte");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }


        // 6. Phone Book
        // TEORIE: Căutarea într-un HashMap prin .get(cheie)

        Map<String, String> phoneBook = new HashMap<>();
        phoneBook.put("Ionel", "0712345678");
        phoneBook.put("Gigel", "0723456789");
        phoneBook.put("Costel", "0734567890");

        String searchName = "Gigel";
        System.out.println("\nCăutare telefon pentru " + searchName + ": " + phoneBook.getOrDefault(searchName, "not found"));


        // 7. Students Management System
        // Numele cheia unică, iar nota valoarea

        Map<String, Integer> studentsMap = new HashMap<>();
        studentsMap.put("Ionel", 8);
        studentsMap.put("Gigel", 10);
        studentsMap.put("Costel", 7);

        System.out.println("\nNote studenți");
        for (Map.Entry<String, Integer> entry : studentsMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        String bestStudent = "";
        int highestGrade = -1; // Inițializăm cu o notă imposibil de mică

        for (Map.Entry<String, Integer> entry : studentsMap.entrySet()) {
            if (entry.getValue() > highestGrade) {
                highestGrade = entry.getValue();
                bestStudent = entry.getKey();
            }
        }
        System.out.println("Highest grade: " + bestStudent + " (" + highestGrade + ")");



        // 8. Sort Students

        // TEORIE: Un HashMap este prin definiție NEORDONAT în memorie. Nu îl poți sorta direct.
        // Ca să îl sortăm, trebuie să extragem setul de intrări (studentsMap.entrySet())
        // și să îl punem într-o Listă de tip `Map.Entry`. Listele pot fi sortate ușor cu un Comparator.

        // A) Sortare după NUME
        List<Map.Entry<String, Integer>> sortedByNames = new ArrayList<>(studentsMap.entrySet());
        sortedByNames.sort((a, b) -> a.getKey().compareTo(b.getKey()));

        System.out.println("\nSortat după nume alfabetic:");
        for (Map.Entry<String, Integer> entry : sortedByNames) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // B) Sortare după NOTĂ
        List<Map.Entry<String, Integer>> sortedByGrades = new ArrayList<>(studentsMap.entrySet());
        // (b - a) asigură ordinea descrescătoare (de la mare la mic)
        sortedByGrades.sort((a, b) -> b.getValue() - a.getValue());

        System.out.println("\nSortat după notă descrescător:");
        for (Map.Entry<String, Integer> entry : sortedByGrades) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }


        // 9. Remove Duplicates
        // Pentru a simula o listă inițială care conține duplicate, folosim o listă
        // de obiecte Map.Entry create cu Map.entry(cheie, valoare)
        // Folosim un Set<String> pentru a memora numele pe care le-am procesat deja.
        // Truc: Metoda set.add(element) returnează TRUE doar dacă elementul
        // NU exista deja în set. Dacă există deja, returnează FALSE și nu îl mai adaugă.

        List<Map.Entry<String, Integer>> withDuplicates = new ArrayList<>();
        withDuplicates.add(Map.entry("Ionel", 8));
        withDuplicates.add(Map.entry("Gigel", 10));
        withDuplicates.add(Map.entry("Ionel", 8)); // Duplicat evident

        List<Map.Entry<String, Integer>> noDuplicates = new ArrayList<>();
        Set<String> seenNames = new HashSet<>();

        for (Map.Entry<String, Integer> entry : withDuplicates) {
            if (seenNames.add(entry.getKey())) {
                noDuplicates.add(entry);
            }
        }

        System.out.println("\nLista finală fără duplicate:");
        for (Map.Entry<String, Integer> entry : noDuplicates) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

    }
}