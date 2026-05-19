//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //        Vehicle[] array = { new Car() , new Motorcycle(), new Truck()};
        Car c0 = new Car("Ford", 150);
        Car c1 = new Car("Hyundai", 200);

        Motorcycle m0 = new Motorcycle("Yamaha", 250);
        Motorcycle m1 = new Motorcycle("Honda", 200);

        Truck t0 = new Truck("Brand1", 50);
        Truck t1 = new Truck("Brand2", 60);

        Vehicle[] vector = new Vehicle[] {c0, c1, m0, m1, t0, t1};

        for (Vehicle v : vector) {
            v.move();
        }
    }
}