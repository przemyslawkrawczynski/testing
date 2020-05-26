package pl.pk.testing.qc.collections.arrays;

import pl.pk.testing.qc.collections.interfaces.Car;

import java.util.Random;

public class CarsApplication {

    private static CarUtils carUtils = new CarUtils();

    public static void main(String[] args) {

        Car[] cars = new Car[15];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = drawCar();
        }

        for (Car car: cars) {
            carUtils.showCarInfo(car);
        }

    }

    private static Car drawCar() {
        Random random = new Random();
        int carNum = random.nextInt(3);
        int increaseSpeedTimes = random.nextInt(10);

        Car car = carUtils.createCar(carNum);
        for (int i = 0; i < increaseSpeedTimes; i++) {
            car.increaseSpeed();
        }

        return car;
    }

}
