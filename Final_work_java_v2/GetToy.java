package Final_work_java_v2;

import java.util.NoSuchElementException;

public class GetToy {
    private CreateRandomQueue createRandomQueue;

    public GetToy(CreateRandomQueue createRandomQueue) {
        this.createRandomQueue = createRandomQueue;
    }

    public Toy getToyFromQueue() {
        if (createRandomQueue.hasNext()) {
            return createRandomQueue.next();
        } else {
            throw new NoSuchElementException("No more toys in the queue");
        }
    }
}