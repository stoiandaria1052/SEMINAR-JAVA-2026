public abstract class Vehicle {
    private String brand;
    private double speed;

    public Vehicle() {
        this.brand = "N/A";
        this.speed = 0.0;
    }

    public Vehicle(String brand, double speed) {
        this.brand = brand;
        this.speed = speed;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getSpeed() {
        return this.speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public abstract void move();
}
