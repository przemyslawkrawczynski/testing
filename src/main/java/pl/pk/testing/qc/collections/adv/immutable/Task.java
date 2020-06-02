package pl.pk.testing.qc.collections.adv.immutable;

public final class Task {

    private String title;
    private int duration;

    public Task(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    public final String getTitle() {
        return title;
    }

    public final int getDuration() {
        return duration;
    }
}
