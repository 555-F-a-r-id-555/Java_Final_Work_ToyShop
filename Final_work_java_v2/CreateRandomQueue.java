package Final_work_java_v2;


import java.util.*;

public class CreateRandomQueue implements Iterator<Toy> {
    private int nextId = 1;
    private Random random = new Random();
    private PriorityQueue<Toy> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Toy::getId));


    public CreateRandomQueue(List<Toy> toyInfoList) {
        List<Toy> shuffledToyInfoList = new ArrayList<>(toyInfoList);
        Collections.shuffle(shuffledToyInfoList);
        addRandomToys(shuffledToyInfoList);
    }

    private void addRandomToys(List<Toy> toyInfoList) {
        for (Toy toyInfo : toyInfoList) {
            ToyName toyName = toyInfo.getToyName();
            int weight = toyInfo.getWeight();
            for (int i = 0; i < weight; i++) {
                Toy newToy = new Toy(nextId++, toyName);
                priorityQueue.add(newToy);
            }
        }
    }


    @Override
    public boolean hasNext() {
        return !priorityQueue.isEmpty(); // Используем priorityQueue
    }

    @Override
    public Toy next() {
        if (!hasNext()) {
            throw new IllegalStateException("Игрушек больше нет");
        }
        return priorityQueue.poll(); // Извлекаем из priorityQueue
    }
}




