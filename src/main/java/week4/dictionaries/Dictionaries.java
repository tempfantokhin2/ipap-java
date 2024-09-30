package week4.dictionaries;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Dictionaries {
    public static void main(String[] args) {
        //example1();
        //example2();
        //example3();
        example4_suits();
    }

    private static void example4_suits() {
        //Подсчитаем, сколько в руке карт каждой масти
        List<PlayingCard> hand = new ArrayList<>();
        hand.add(new PlayingCard("черви", "дама"));
        hand.add(new PlayingCard("пики", "дама"));
        hand.add(new PlayingCard("черви", "десятка"));
        hand.add(new PlayingCard("трефы", "дама"));
        hand.add(new PlayingCard("черви", "туз"));
        hand.add(new PlayingCard("пики", "двойка"));
        hand.add(new PlayingCard("бубны", "двойка"));

        Map<String, Integer> table = new TreeMap<>();
        for (PlayingCard i: hand) {
            String key = i.getSuit();
            table.put(key, 1 + table.getOrDefault(key, 0));
        }
        System.out.println("table = " + table);

        //lol
        //UNTESTED
        for (Map.Entry<String, Integer> entry : table.entrySet())
            if(entry.getValue() >= 5) System.out.println("flash in hand: " + entry.getKey());
    }

    private static void example3() {
        //прочитать строку от пользователя и подсчитать сколько встречается кажое слово
        //на нужна "таблица", в которой ключ - это слова, а значение - счетчик
        Map<String, Integer> table = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите строку");
        String line = scanner.nextLine();
        for (String s : line.split(" ")) {
            //table.put(s, table.get(s) == null ? 0 : table.get(s) + 1);
            table.put(s, table.getOrDefault(s, 0) + 1);
        }
        System.out.println("table = " + table);
    }

    private static void example2() {
        Map<String, String> dict2 = new TreeMap<>();
        try (Scanner scanner = new Scanner(new File("diction.txt"))) {
            while (scanner.hasNext()) {
                String s = scanner.nextLine();
                String[] array = s.split(" ");
                dict2.put(array[0], array[1]);
            }
        } catch (FileNotFoundException ignored) {
            System.out.println("все сломалось");
        }
        System.out.println("Dict2 = " + dict2);
    }

    private static void example1() {
        Map<String, String> dict1 = new TreeMap<>();
        //https://www.stars21.com/translator/klingon/
        //dict1.put("yes", "HIja'");
        //dict1.put("no", "Qo'");
        //dict1.put("make", "HIs");
        //dict1.put("show", "'agh");
        //dict1.put("do", "HIs");
        //dict1.put("show", "much");
        //System.out.println(dict1);
        //{do=HIs, make=HIs, no=Qo', show=much, yes=HIja'} значения могут повторяться, а ключ нет
        dict1.put("yes", "да");
        dict1.put("no", "нет");
        dict1.put("make", "делать");
        dict1.put("show", "показать");
        dict1.put("do", "делать");
        dict1.put("show", "представление");
        System.out.println(dict1);
        //{do=делать, make=делать, no=нет, show=представление, yes=да} значения могут повторяться, а ключ нет

        String key = "make";
        String value = dict1.get(key);
        System.out.println("value = " + value);

        key = "developer";
        value = dict1.get(key);
        System.out.println("value = " + value);

        value = dict1.getOrDefault(key, "не могу перевести " + key);
        System.out.println("value = " + value);
    }


}
