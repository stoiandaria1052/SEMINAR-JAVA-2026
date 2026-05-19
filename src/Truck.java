public class Truck extends Vehicle {
    public Truck() {
        super();
    }

    public Truck(String brand, double speed) {
        super(brand, speed);
    }

    @Override
    public void move() {
        System.out.println("The TRUCK is moving\n");
    }
}