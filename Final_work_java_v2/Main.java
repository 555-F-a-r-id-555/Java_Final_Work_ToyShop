package Final_work_java_v2;
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


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Toy> toyInfoList = new ArrayList<>();
        toyInfoList.add(new Toy(ToyName.Robot, 2));
        toyInfoList.add(new Toy(ToyName.Lego, 3));
        toyInfoList.add(new Toy(ToyName.Barbie, 5));

        CreateRandomQueue createRandomQueue = new CreateRandomQueue(toyInfoList);
        GetToy getToy = new GetToy(createRandomQueue);
        WriteFile writeFile = new WriteFile(getToy);

        writeFile.writeToFile("toys.txt", "output", 10);
    }
}
