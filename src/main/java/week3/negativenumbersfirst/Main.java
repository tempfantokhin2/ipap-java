package week3.negativenumbersfirst;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Double> doublesList = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("negativenumbersfirst.txt"))) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine().trim();
                try {
                    double value = Double.parseDouble(line);
                    doublesList.add(value);
                    System.out.println("Added: " + value);
                } catch (NumberFormatException e) {
                    System.err.println("Invalid double value: " + line);
                }
            }
        } catch (Exception e) {
            System.out.println("Problem with file negativenumbersfirst.txt:\n"+e);
        }

        placeNegativesInTheBeginning(doublesList);
        System.out.println(doublesList);
    }

    public static void placeNegativesInTheBeginning(List<Double> doublesList) {
        doublesList.sort((a, b) -> {
            if (a < 0 && b >= 0) return -1;
            if (a > 0 && b <= 0) return 1;
            return 0;
        });
    }
}
