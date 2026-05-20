import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercitii {
    public static void main(String[] args) {
        System.out.println("==================Exercitiul 1===========================");
        //1. Create a generic class that contains:
//     - private field of type T
//     - constructor
//     - getValue() and setValue()
//and test it at the end
        Putere<Integer> intPutere = new Putere<>(500);
        Putere<String> stringPutere = new Putere<>("Watts");
        Putere<Double> doublePutere = new Putere<>(356.26);

        System.out.println("Putere in int: " + intPutere.getValue());
        System.out.println("Tip string: " + stringPutere.getValue());


        System.out.println("\n==================Exercitiul 2===========================");
        //2. Create generic method printTwice(T value) and test it
        Integer[] numere = {45, 32, 54};
        String[] cuvinte = {"galben", "soare", "stele", "mare"};

        afisareTot(numere);
        System.out.println();
        afisareTot(cuvinte);

        System.out.println("\n==================Exercitiul 3===========================");
        //3. Create a method that introduces bounded types: public static <T extends Comparable<T>> T max(T a, T b)
        //Test with Integer and String
        Integer a =6, b=12;
        if(max(a, b) ==1 )
            System.out.println("Primul numar introdus este mai MARE decat al doilea.");
        else
            System.out.println("Primul numar introdus este mai MIC decat al doilea.");

        String nume1 = "Sebastian", nume2 = "Alex";
        if(max(nume1, nume2) >0)
            System.out.println("Primul nume are mai MULTE litere decat al doilea.");
        else
        if (max(nume1, nume2) < 0 )
            System.out.println("Primul nume are mai PUTINE litere decat al doilea.");
        else if (max(nume1, nume2) == 0)
            System.out.println("Ambele nume au acelasi numar de litere.");


        System.out.println("\n==================Exercitiul 4===========================");
        //4. Create a method countElements that takes in as a parameter a list of generic elements
        // and returns the total nr of elements inside that array
    }
    //1.
    static class Putere<T> {
        private T value;

        public Putere(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }

    //2.
    public static <T> void afisareTot(T[] array)
    {
        for (T item : array) {
            System.out.print(item + " ");
        }
    }

    //3.
    //Comparable - bun pt a sorta lista, dar unele liste nu pot accepta Comparable
    //daca nu e lista si e txt|| daca am folosit un set ca parametru, nu putem aplica Comparable
    public static <T extends Comparable<T>> int max(T a, T b)
    {
        return a.compareTo(b);
    }
}
