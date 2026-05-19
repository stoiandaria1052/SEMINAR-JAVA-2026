public class Motorcycle extends Vehicle {
    public Motorcycle() {
        super();
    }

    public Motorcycle(String brand, double speed, String id, int mileage, boolean rented) {
        super(brand, speed, id, mileage, rented);
    }

    @Override
    public void move() {
        System.out.println("The MOTORCYCLE is moving...");
    }
}