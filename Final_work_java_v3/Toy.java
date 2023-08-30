package Final_work_java_v3;


public class Toy {
    private int id;
    private ToyName toyName;

    public Toy(ToyName toyName) {
        this.toyName = toyName;
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

    @Override
    public String toString() {
        return "Toy{" +
                "id=" + id +
                ", name='" + toyName + '\'' +
                '}';
    }
}
