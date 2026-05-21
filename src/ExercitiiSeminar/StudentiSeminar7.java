package ExercitiiSeminar;

import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;

/*
* lucrul cu fisiere

1. facem enitate (clasa care def un student) pt student: String name, Integer age, String specializare (serializare; avem deja datele intr-un fisier si noi le punem in clasa resp)
2. incarcam documentul in memoria programului (citim fiecare linie din fisier, adaugam intr un array list si facem prelucrari intermediare)
3. persistam in baza de date. (salvare), nu mai avem nevoie de fisierul initial
4. aducem informatiile din baza de date
5. expunere in front-end
* */

public class StudentiSeminar7 {
    String name;
    Integer age;
    String specializare;
    public StudentiSeminar7(String name, Integer age, String specializare) {
        this.name = name;
        this.age = age;
        this.specializare = specializare;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getSpecializare() {
        return specializare;
    }
    public void setSpecializare(String specializare) {
        this.specializare = specializare;
    }

//    public static void writeFile(Path path) {
//        try {
//            System.out.println("Writing to file...");
//            Files.write(path, List.of(
//                    "Ana,20",
//                    "Mihai,22",
//                    "Elena,19"
//            ));
//        } catch (IOException e) {
//            System.err.println("Error writing file: " + e.getMessage());
//        }
//    }

    public static final String separator= ",";
    public static void readFile(Path path) {
        try {
            System.out.println("\nReading file:");
            List<String> lines = Files.readAllLines(path);
            ArrayList<String> lista = new ArrayList<>();
            for (String line : lines) {
                lista.add(line);
            }
            //System.out.println(students);
            ArrayList<StudentiSeminar7> studenti = new ArrayList<>();
            for(String s : lista){
                String[] parts = s.split(",");

                String name = parts[0];
                int age = Integer.parseInt(parts[1]);
                String specializare = parts[2];

                StudentiSeminar7 student = new StudentiSeminar7(name, age, specializare);
                studenti.add(student);
            }
            System.out.println(studenti);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }


    }

    public static void main(String[] args) {
        Path path = Path.of("students.txt");
        readFile(path);
    }
}


