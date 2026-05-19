public class Car extends Vehicle {
    public Car() {
        super();
    }

    public Car(String brand, double speed, String id, int mileage, boolean rented) {
        super(brand, speed, id, mileage, rented);
    }

    @Override
    public void move() {
        System.out.println("The CAR is moving");
    }

    @Override
    public boolean equals(Object obj) {
        Car carObj = (Car) obj;
        // Folosim .equals pentru String-uri in loc de == pentru a evita bug-urile si a schimba codul
        return this.getSpeed() == carObj.getSpeed() && this.getBrand().equals(carObj.getBrand());
    }
}