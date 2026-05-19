public abstract class Vehicle {
    private String brand;
    private double speed;
    private String id;
    private int mileage;
    private boolean rented;

    public Vehicle() {
        this.brand = "N/A";
        this.speed = 0.0;
        this.id = "N/A";
        this.mileage = 0;
        this.rented = false;
    }

    public Vehicle(String brand, double speed, String id, int mileage, boolean rented) {
        this.brand = brand;
        this.speed = speed;
        this.id = id;
        this.mileage = mileage;
        this.rented = rented;
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

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMileage() {
        return this.mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public boolean isRented() {
        return this.rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    public void rent() throws Exception {
        if (this.rented) {
            throw new Exception("Vehiculul este deja inchiriat!");
        }
    }

    public void returnVehicle(int drivenKm) throws Exception {
        if (!this.rented) {
            throw new Exception("Vehiculul nu este inchiriat! Nu poate fi returnat!");
        } else if (drivenKm <= 0) {
            throw new Exception("Numarul de kilometri introdus nu este valid!");
        } else {
            this.mileage += drivenKm;
            this.rented = false;
        }
    }
}