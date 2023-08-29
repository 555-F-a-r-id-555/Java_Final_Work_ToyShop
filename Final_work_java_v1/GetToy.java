package Final_work_java_v1;

public class GetToy {
    private CreateRandomQueue createRandomQueue = new CreateRandomQueue();

    public Toy getToyFromQueue(int count) {
        createRandomQueue.getRandomQueue(count);
        return createRandomQueue.getPriorityQueue().remove();
    }

}

