package Final_work_java_v2;


public class Toy {
    private int id;
    private ToyName toyName;
    private int weight;

    public Toy(ToyName toyName, int weight) {
        this.toyName = toyName;
        this.weight = weight;
    }

    public Toy(int id, ToyName name) {
        this.id = id;
        this.toyName = name;
    }


    public int getId() {
        return id;
    }
    public ToyName getToyName() {
        return toyName;
    }
    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "id=" + id +
                ", name='" + toyName + '\'' +
                '}';
    }
}
