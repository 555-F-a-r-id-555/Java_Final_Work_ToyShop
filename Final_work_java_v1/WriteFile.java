package Final_work_java_v1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WriteFile {
    private GetToy getToy = new GetToy();


    public void writeToFile(String fileName, String directoryName,int count) {
        File dir = new File(directoryName);
        if (!dir.exists()) {
            dir.mkdir();
        }

        File file = new File(dir, fileName);


        for (int i = 0; i < count; i++) {
            Toy toy = getToy.getToyFromQueue(count);
            System.out.println(toy.toString());

            if (file.exists()) {
                try {
                    boolean lineExists = Files.lines(Paths.get(file.getAbsolutePath()))
                            .anyMatch(existingLine -> existingLine.equals(toy.toString()));
                    if (lineExists) {
                        System.err.println("Вы пытаетесь записать: " + toy.toString());
                        throw new RuntimeException("Такая запись уже существует");
                    }
                } catch (IOException e) {
                    throw new RuntimeException("Ошибка при чтении файла: " + e.getMessage());
                }
            }

            try (FileWriter writer = new FileWriter(file, true)) {
                writer.write(toy.toString() + "\n");
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Ошибка при записи файла: " + e.getMessage());
            }
        }


    }
}
