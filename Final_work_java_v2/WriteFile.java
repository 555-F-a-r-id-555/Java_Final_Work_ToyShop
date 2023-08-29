package Final_work_java_v2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {

    private GetToy getToy;

    public WriteFile(GetToy getToy) {
        this.getToy = getToy;
    }

    public void writeToFile(String fileName, String directoryName, int count) {
        File dir = new File(directoryName);
        if (!dir.exists()) {
            dir.mkdir();
        }

        File file = new File(dir, fileName);

        try (FileWriter writer = new FileWriter(file, true)) {
            for (int i = 0; i < count; i++) {
                Toy toy = getToy.getToyFromQueue();
                System.out.println(toy.toString());

                if (file.exists()) {
                    file.delete();
                }
//                if (file.exists()) {
//                    boolean lineExists = Files.lines(Paths.get(file.getAbsolutePath()))
//                            .anyMatch(existingLine -> existingLine.equals(toy.toString()));
//                    if (lineExists) {
//                        System.err.println("You are trying to write: " + toy.toString());
//                        throw new RuntimeException("Such entry already exists");
//                    }
//                }

                writer.write(toy.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error writing to file: " + e.getMessage());
        }
    }
}
