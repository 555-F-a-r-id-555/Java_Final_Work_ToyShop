package Final_work_java_v3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {

    private GetToy getToy;

    public WriteFile(GetToy getToy) {
        this.getToy = getToy;
    }

    public void writeToFile(String fileName, String directoryName) {

        File dir = new File(directoryName);
        if (!dir.exists()) {
            dir.mkdir();
        }

        File file = new File(dir, fileName);

        try {
            if (file.exists()) {
                file.delete();
            }

            int size = getToy.queueSize();

            try (FileWriter writer = new FileWriter(file, true)) {
                for (int i = 0; i < size; i++) {
                    Toy toy = getToy.getToyFromQueue();
                    System.out.println(toy.toString());
                    writer.write(toy.toString() + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Ошибка записи в файл: " + e.getMessage());
        } finally {
            if (!file.exists()) {
                System.err.println("Произошла ошибка. Восстановление удаленного файла.");
                try {
                    file.createNewFile();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}

