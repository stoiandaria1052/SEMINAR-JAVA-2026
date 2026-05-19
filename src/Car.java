public class Car extends Vehicle {
    public Car() {
        super();
    }

    public Car(String brand, double speed) {
        super(brand, speed);
    }

    @Override
    public void move() {
        System.out.println("The CAR is moving\n");
    }
}