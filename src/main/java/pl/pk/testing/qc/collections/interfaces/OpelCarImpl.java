package pl.pk.testing.qc.collections.interfaces;

public class OpelCarImpl implements Car {

    private int speed = 0;
    private int changeValue = 2;

    public OpelCarImpl() {
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public void decreaseSpeed() {
        this.speed = (speed - changeValue) < 0 ? 0 : speed - changeValue;
        System.out.println("[OPEL] Zmniejszam prędkość o " + changeValue + ". Aktualna prędkość: " + speed  + " km/h.");
    }

    @Override
    public void increaseSpeed() {
        this.speed = (speed + changeValue);
        System.out.println("[FORD] Zwiększam prędkość o " + changeValue + ". Aktualna prędkość: " + speed  + " km/h.");
    }
}
