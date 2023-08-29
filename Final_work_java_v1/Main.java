package Final_work_java_v1;
//Информация о проекте
//        Необходимо написать проект, для розыгрыша в магазине игрушек. Функционал
//        должен содержать добавление новых игрушек и задания веса для выпадения
//        игрушек.
//Задание
//        1) Напишите класс-конструктор у которого принимает минимум 3 строки,
//        содержащие три поля id игрушки, текстовое название и частоту выпадения
//        игрушки
//        2) Из принятой строки id и частоты выпадения(веса) заполнить минимум три
//        массива.
//        3) Используя API коллекцию: java.util.PriorityQueue добавить элементы в
//        коллекцию4) Организовать общую очередь 5) Вызвать Get 10 раз и записать результат в
//        файл
//Критерии оценки
//        Приложение должно запускаться, записывать значения в файл.


public class Main {
    public static void main(String[] args) {

        WriteFile writeFile = new WriteFile();

        String fileName = "Prize1";
        String directory = "dir";
        int count = 5;
        writeFile.writeToFile(fileName, directory, count);


        String fileName2 = "Prize1";
        writeFile.writeToFile(fileName2, directory, count);

        String fileName3 = "Prize1";
        writeFile.writeToFile(fileName3, directory, count);


    }
}
