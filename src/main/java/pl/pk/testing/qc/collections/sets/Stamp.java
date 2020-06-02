package pl.pk.testing.qc.collections.sets;

import java.util.Objects;

public class Stamp {

    private String name;
    private Double height;
    private Double width;
    private boolean isStamped;

    public Stamp(String name, Double height, Double width, boolean isStamped) {
        this.name = name;
        this.height = height;
        this.width = width;
        this.isStamped = isStamped;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public boolean isStamped() {
        return isStamped;
    }

    public void setStamped(boolean stamped) {
        isStamped = stamped;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stamp stamp = (Stamp) o;
        return isStamped() == stamp.isStamped() &&
                getName().equals(stamp.getName()) &&
                getHeight().equals(stamp.getHeight()) &&
                getWidth().equals(stamp.getWidth());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getHeight(), getWidth(), isStamped());
    }
}
