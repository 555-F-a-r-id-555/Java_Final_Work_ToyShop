package Final_work_java_v1;

public enum ToyName {
    Robot(20), Lego(30), Barbie(50);

    private final double weight;

    ToyName(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }
}
