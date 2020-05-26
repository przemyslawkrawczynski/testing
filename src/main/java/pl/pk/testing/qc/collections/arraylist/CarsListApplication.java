package pl.pk.testing.qc.collections.arraylist;

import pl.pk.testing.qc.collections.arrays.CarUtils;
import pl.pk.testing.qc.collections.interfaces.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarsListApplication {

    private static CarUtils carUtils = new CarUtils();

    public static void main(String[] args) {
        List<Car> carList = new ArrayList<>();
        Random random  = new Random();

        for (int i = 0; i < 15; i++) {
            int carId = random.nextInt(3);
            carList.add(carUtils.createCar(carId));
       }

        System.out.println("Car list size: " + carList.size());

        //Remove
        Car car = carList.get(10);
        carList.remove(car);

        System.out.println("Car list size after remove: " + carList.size());
    }

}
