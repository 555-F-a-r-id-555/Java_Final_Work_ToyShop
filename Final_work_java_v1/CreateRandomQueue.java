package Final_work_java_v1;


import java.util.*;

public class CreateRandomQueue implements Iterator<Toy> {
    private int nextId = 1;
    private Random random = new Random();
    private PriorityQueue<Toy> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Toy::getId));


    public void getRandomQueue(int count) {
        addRandomToys(count);
    }

    public PriorityQueue<Toy> getPriorityQueue() {
        return priorityQueue;
    }

    private void addRandomToys(int count) {
        for (int i = 0; i < count; i++) {
            ToyName randomToyName = generateRandomToy();
            Toy newToy = new Toy(nextId++, randomToyName);
            priorityQueue.add(newToy);
        }

    }

    private ToyName generateRandomToy() {
        double randomValue = random.nextDouble()*100;
        double cumulativeWeight = 0.0;

        for (ToyName toyName : ToyName.values()) {
            cumulativeWeight += toyName.getWeight();
            if (randomValue <= cumulativeWeight) {
                return toyName;
            }
        }
        throw new IllegalStateException("Сюда не следует заходить");
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




