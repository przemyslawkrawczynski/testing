package pl.pk.testing.qc.collections.interfaces;

public class BmwCarImpl implements Car {

    private int speed = 0;
    private int changeValue = 3;

    public BmwCarImpl() {
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public void decreaseSpeed() {
        this.speed = (speed - changeValue) < 0 ? 0 : speed - changeValue;
        System.out.println("[BMW] Zmniejszam prędkość o " + changeValue + ". Aktualna prędkość: " + speed  + " km/h.");
    }

    @Override
    public void increaseSpeed() {
        this.speed = (speed + changeValue);
        System.out.println("[BMW] Zwiększam prędkość o " + changeValue + ". Aktualna prędkość: " + speed  + " km/h.");
    }
}
