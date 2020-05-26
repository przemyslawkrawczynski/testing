package pl.pk.testing.qc.collections.interfaces;

public class CarRace {

    public static void main(String[] args) {

        Car bmw = new BmwCarImpl();
        Car opel = new OpelCarImpl();
        Car ford = new OpelCarImpl();

        doRace(bmw);
        doRace(opel);
        doRace(ford);

    }

    public static void doRace(Car car) {
        car.increaseSpeed();
        car.increaseSpeed();
        car.increaseSpeed();
        car.decreaseSpeed();
        car.decreaseSpeed();
        System.out.println("Prędkość auta: " + car.getSpeed());
    }
}
