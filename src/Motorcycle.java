public class Motorcycle extends Vehicle {
    public Motorcycle() {
        super();
    }

    public Motorcycle(String brand, double speed) {
        super(brand, speed);
    }

    @Override
    public void move() {
        System.out.println("The MOTORCYCLE is moving\n");
    }
}