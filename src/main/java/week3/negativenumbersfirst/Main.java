package week3.negativenumbersfirst;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Double> doublesList = readDoublesList(new File("negativenumbersfirst.txt"));
        placeNegativesInTheBeginning(doublesList);
        System.out.println(doublesList);
    }

    public static List<Double> readDoublesList(File sourceFile) {
        List<Double> doublesList = new ArrayList<>();
        try (Scanner scanner = new Scanner(sourceFile)) {
            String[] doublesAsStrings = scanner.nextLine().split(";");
            for (String i : doublesAsStrings) {
                try {
                    doublesList.add(Double.parseDouble(i));
                    System.out.println("Added: " + i);
                } catch (NumberFormatException e) {
                    System.err.println("Invalid double value: " + i);
                }
            }
        } catch (Exception e) {
            System.out.println("Problem with file " + sourceFile.getName() + ":\n" + e);
        }
        return doublesList;
    }

    public static void placeNegativesInTheBeginning(List<Double> doublesList) {
        doublesList.sort((a, b) -> {
            if (a < 0 && b >= 0) return -1;
            if (a > 0 && b <= 0) return 1;
            return 0;
        });
    }
}
