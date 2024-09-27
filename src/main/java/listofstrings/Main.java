package listofstrings;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<String> txt = loadText("a.txt");
        System.out.println(txt);
        System.out.println("'Вася Пупкин' strings count: " + countTargetInList(txt, "Вася Пупкин"));
        System.out.println("Strings starting with 'Вася' count: " + countStartInList(txt, "Вася"));
        System.out.println("Unique strings list: " + filterUnqique(txt));

        List<String> shortStrings = filterStringsByLength(txt, 15);
        System.out.println("Filtered by length: " + shortStrings);

        // Reverse sorted by length
        List<String> sortedByReverseLength = sortStrings(txt, Comparator.comparing(String::length).reversed());
        System.out.println("Sorted by reverse length: " + sortedByReverseLength);

        // Sort alphabetically by first char
        List<String> sortedAlphabetical = sortStrings(txt, (s1, s2) -> {
            char ch1 = s1.charAt(0);
            char ch2 = s2.charAt(0);
            return Character.compare(ch1, ch2);
        });
        System.out.println("Sorted alphabetical by first char: " + sortedAlphabetical);

        replaceCharInStringsList(txt, 'В', 'V');
        System.out.println("В replaced to V: " + txt);
    }

    private static List<String> filterUnqique(List<String> stringsList) {
        //distinct() is slow
        return stringsList.stream().distinct().toList();
    }

    private static List<String> loadText(String file) {
        List<String> lines = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(file))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (!line.isEmpty()) {
                    lines.add(line);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + file);
        }
        return lines;
    }

    private static int countTargetInList(List<String> stringsList, String target) {
        int count = 0;
        for (String string : stringsList) {
            if (string.equals(target)) {
                count++;
            }
        }
        return count;
    }

    private static int countStartInList(List<String> stringsList, String start) {
        int count = 0;
        for (String string : stringsList) {
            if (string.startsWith(start)) {
                count++;
            }
        }
        return count;
    }

    private static List<String> filterStringsByLength(List<String> stringsList, int length) {
        ArrayList<String> filteredStrings = new ArrayList<>();
        for (String string : stringsList) {
            if (string.length() < length) {
                filteredStrings.add(string);
            }
        }
        return filteredStrings;
    }

    //in case I will implement other sort algorithms
    private static List<String> sortStrings(List<String> stringsList, Comparator<String> comparator) {
        return bubbleSort(stringsList, comparator);
    }

    // simple bubbleSort (not perfect)
    // unsure about comparator
    private static List<String> bubbleSort(List<String> list, Comparator<String> comparator) {
        for (int elementsSorted = 0; elementsSorted < list.size() - 1; elementsSorted++) {
            for (int i = 0; i < list.size() - 1 - elementsSorted; i++) {
                String firstElement = list.get(i);
                String secondElement = list.get(i + 1);

                // Comparing comparator
                int comparisonResult = comparator.compare(firstElement, secondElement);

                if (comparisonResult > 0) {
                    // Bubble
                    list.set(i, secondElement);
                    list.set(i + 1, firstElement);
                }
            }
        }
        return list;
    }

    //change parameter list for a change
    private static void replaceCharInStringsList(List<String> stringsList, char thisChar, char toThatChar) {
        //can be replaced with stringsList.replaceAll
        for(int i = 0; i<stringsList.size();i++) {
            stringsList.set(i, stringsList.get(i).replace(thisChar, toThatChar));
        }
    }

}
