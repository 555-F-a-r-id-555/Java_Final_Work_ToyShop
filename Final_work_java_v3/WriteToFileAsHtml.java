package Final_work_java_v3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class WriteToFileAsHtml {
    private GetToy getToy;

    public WriteToFileAsHtml(GetToy getToy) {
        this.getToy = getToy;
    }

    private Random random = new Random();

    private final String ANSI_RESET = "\u001B[0m";
    private final String[] COLORS = {
            "red", "darkred", "lightcoral", "purple", "lightpink",
            "lime", "green", "lightgreen", "lime", "blue",
            "gold", "black"
    };
    private final String[] COLORS2 = {
            "\u001B[91m", "\u001B[31m", "\u001B[95m", "\u001B[35m", "\u001B[95m",
            "\u001B[92m", "\u001B[32m", "\u001B[96m", "\u001B[38;2;0;255;0m", "\u001B[34m",
            "\u001B[33m", "\u001B[30m"
    };


    public void writeToFileAsHtml(String fileName, String directoryName) {
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

            try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
                writer.println("<html><body>");

                for (int i = 0; i < size; i++) {
                    Toy toy = getToy.getToyFromQueue();
                    int randomIndex = random.nextInt(COLORS.length);
                    String randomColor = COLORS[randomIndex];
                    int randomIndex2 = random.nextInt(COLORS2.length);
                    String randomColor2 = COLORS2[randomIndex2];
                    System.out.println(randomColor2 + toy.toString() + ANSI_RESET);

                    writer.println("<p style='color:" + randomColor + "'>" + toy.toString() + "</p>");
                }

                writer.println("</body></html>");
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
