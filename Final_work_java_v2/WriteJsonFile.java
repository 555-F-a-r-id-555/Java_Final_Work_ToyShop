package Final_work_java_v2;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteJsonFile {

    private GetToy getToy;

    public WriteJsonFile(GetToy getToy) {
        this.getToy = getToy;
    }

    public void writeToJsonFile(String fileName, String directoryName) {

        List<Toy> toys = getToy.getAllToys();

        Gson gson = new Gson();
        String json = gson.toJson(toys);

        File dir = new File(directoryName);
        if (!dir.exists()) {
            dir.mkdir();
        }

        File file = new File(dir, fileName);

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(json);
            System.out.println("Запись выполнена успешно");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Ошибка записи файла JSON: " + e.getMessage());
        }
    }
}

