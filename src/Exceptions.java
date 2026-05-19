public class Exceptions {
    public void validateAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException();
        }
    }
}