package week4.automobiles2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

//Загрузить из файла строки, каждая из которых содержит:
//владельца, модель, год и цвет машины, разделенные ;
//
//спросить у пользователя, какая машина его интересует
//прочитать с консоли модель, год и цвет
//
//вывести имя владельца, если такой есть, иначе "машина на найденна"
public class Main {
    public static void main(String[] args) {
        Map<Car, String> cars = new HashMap<>();
        getCarsFromFile(cars);
        System.out.println("Cars = " + cars);
        System.out.println("Какая машина интересна? Марка, год, цвет:");
        Car targetCar = getTargetCar();
        System.out.println(cars.getOrDefault(targetCar, "машина не найдена"));
    }

    private static void getCarsFromFile(Map<Car, String> cars) {
        try (Scanner fileScanner = new Scanner(new File("cars.txt"))) {
            while (fileScanner.hasNext()) {
                String s = fileScanner.nextLine();
                String[] array = s.split("; ");
                cars.put(new Car(array[1], Integer.parseInt(array[2]), array[3]), array[0]);
            }
        } catch (FileNotFoundException ignored) {
            System.out.println("все сломалось");
        }
    }

    private static Car getTargetCar() {
        Scanner consoleScanner = new Scanner(System.in);
        return new Car(consoleScanner.nextLine(), Integer.parseInt(consoleScanner.nextLine()), consoleScanner.nextLine());
    }


}
