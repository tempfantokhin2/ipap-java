package week3.beast;

import java.util.ArrayList;
import java.util.List;

public class Beast {
    private List<Nut> nutsStash = new ArrayList<>();

    public void takeNuts(Nut[] nuts) {
        double nutsWeightCounter = 0;
        for (Nut i: nuts) {
                //take the nut
                System.out.println("ура, еще орех!");
                nutsWeightCounter += i.getWeight();
                nutsStash.add(i);
        }
        System.out.println(nutsWeightCounter);
    }
}
