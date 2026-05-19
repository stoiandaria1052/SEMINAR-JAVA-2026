public class Truck extends Vehicle {
    public Truck() {
        super();
    }

    public Truck(String brand, double speed, String id, int mileage, boolean rented) {
        super(brand, speed, id, mileage, rented);
    }

    @Override
    public void move() {
        System.out.println("The TRUCK is moving...");
    }
}