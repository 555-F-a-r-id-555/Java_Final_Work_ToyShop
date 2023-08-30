package Final_work_java_v3;


import java.util.*;

public class CreateRandomQueue implements Iterator<Toy> {
    private int nextId = 1;
    private Random random = new Random();
    private PriorityQueue<Toy> priorityQueue = new PriorityQueue<>(this::compareTo);

    private int compareTo(Toy toy1, Toy toy2) {
        int weight = random.nextInt();
        return Integer.compare(toy1.getToyName().getWeight(), toy2.getToyName().getWeight() + weight);
    }

    public CreateRandomQueue(List<Toy> toyList) {
        List<Toy> shuffledToyInfoList = new ArrayList<>(toyList);
        Collections.shuffle(shuffledToyInfoList);
        addRandomToys(shuffledToyInfoList);
    }

    private void addRandomToys(List<Toy> toyList) {
        for (Toy toy : toyList) {
            ToyName toyName = toy.getToyName();
            int weight = toyName.getWeight();
            for (int i = 0; i < weight; i++) {
                Toy newToy = new Toy(nextId++, toyName);
                priorityQueue.add(newToy);
            }
        }
    }

    public int size() {
        return priorityQueue.size();
    }
    @Override
    public boolean hasNext() {
        return !priorityQueue.isEmpty();
    }

    @Override
    public Toy next() {
        if (!hasNext()) {
            throw new IllegalStateException("Игрушек больше нет");
        }
        return priorityQueue.poll();
    }


}



