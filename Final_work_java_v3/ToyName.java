package Final_work_java_v3;

public enum ToyName {
    Robot(2), Lego(2), Barbie(4);

    private final int weight;

    ToyName(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
}
