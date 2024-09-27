package week3.beast;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    private List<List<Nut>> envokation = new ArrayList<>();

    public void growNuts(int amount) {
        List<Nut> grownNuts = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            grownNuts.add(new Nut());
        }
        envokation.add(grownNuts);
    }

    public Nut[] giveNuts() {
        if (envokation.isEmpty()) return new Nut[0];

        Nut[] nuts = envokation.getFirst().toArray(new Nut[]{});
        envokation.removeFirst();

        return nuts;
    }
}
