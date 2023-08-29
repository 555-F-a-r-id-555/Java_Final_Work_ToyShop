package Final_work_java_v1;


public class Toy {
    private int id;
    private ToyName toyName;

    public Toy(ToyName name) {
        this.toyName = name;
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
