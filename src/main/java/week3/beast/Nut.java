package week3.beast;

import static java.lang.Math.random;

public class Nut {
    //от 4.0 до 12.0
    private final double weight = 4+random()*8;

    public double getWeight() {
        return weight;
    }
}
