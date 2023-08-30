package Final_work_java_v3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

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
                    int randomIndex = random.nextInt(COLORS.length);
                    String randomColor = COLORS[randomIndex];
                    System.out.println(randomColor + toy.toString() + ANSI_RESET);

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

    private Random random = new Random();

    private final String ANSI_RESET = "\u001B[0m";
    private final String[] COLORS = {
            "\u001B[91m", "\u001B[31m", "\u001B[95m", "\u001B[35m", "\u001B[95m",
            "\u001B[92m", "\u001B[32m", "\u001B[96m", "\u001B[38;2;0;255;0m", "\u001B[34m",
            "\u001B[33m", "\u001B[30m"
    };

//    public static final String ANSI_RESET = "\u001B[0m";
//    //--------------------------------------------------
//    //    Ярко-красный: \u001B[91m
//    //    Темно-красный: \u001B[31m
//    //    Светло-красный: \u001B[95m
//    //    Бордовый: \u001B[35m
//    //    Розовый: \u001B[95m
//    //------------------------------------------------------------
//    //    Ярко-зеленый: \u001B[92m
//    //    Темно-зеленый: \u001B[32m
//    //    Светло-зеленый: \u001B[96m
//    //    Лаймовый: \u001B[38;2;0;255;0m
//    //    Зеленый синий: \u001B[34m
//    //-------------------------------------------------------------

}

