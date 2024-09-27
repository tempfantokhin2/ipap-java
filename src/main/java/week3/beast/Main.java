package week3.beast;

public class Main {
    public static void main(String[] args) {
        Tree testTree = new Tree();
        Beast newBeast = new Beast();

        testTree.growNuts(15);
        newBeast.takeNuts(testTree.giveNuts());
        newBeast.takeNuts(testTree.giveNuts());
    }
}
