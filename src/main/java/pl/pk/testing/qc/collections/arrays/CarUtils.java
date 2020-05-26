package pl.pk.testing.qc.collections.arrays;

import pl.pk.testing.qc.collections.interfaces.BmwCarImpl;
import pl.pk.testing.qc.collections.interfaces.Car;
import pl.pk.testing.qc.collections.interfaces.FordCarImpl;
import pl.pk.testing.qc.collections.interfaces.OpelCarImpl;

public class CarUtils {

    public void showCarInfo(Car car) {
        System.out.println("----------------------------------");
        System.out.println("Car name: " + getCarName(car));
        System.out.println("Speed: " + car.getSpeed() + " km/h");
    }

    public Car createCar(Integer carId) {
        if (carId == 0) return new BmwCarImpl();
        if (carId == 1) return new FordCarImpl();
        if (carId == 2) return new OpelCarImpl();
        else
            return null;
    }

    private String getCarName(Car car) {

        if (car instanceof BmwCarImpl) return "BMW";
        if (car instanceof OpelCarImpl) return "Opel";
        if (car instanceof FordCarImpl) return "Ford";
        else
            return "Unknown Car name";


    }
}
