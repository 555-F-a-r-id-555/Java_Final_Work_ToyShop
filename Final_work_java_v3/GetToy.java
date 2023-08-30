package Final_work_java_v3;

import java.util.ArrayList;
import java.util.List;
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
            throw new NoSuchElementException("Нет игрушек в очереди :(");
        }
    }

    public int queueSize() {
       return createRandomQueue.size();
    }

    public List<Toy> getAllToys() {
        List<Toy> toyList = new ArrayList<>();
        while (createRandomQueue.hasNext()){
            toyList.add(createRandomQueue.next());
        }
        return  toyList;
    }
}