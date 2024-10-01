package week4.enums;

enum Suit{
    CLUBS, HEARTS, DIAMONDS, SPADES;

    @Override
    public String toString() {
        switch (this.ordinal()){
            case 0: return "трефы";
            case 1: return "червы";
            case 4: return "пики";
            case 3: return "бубны";
            default: return "some suit";
        }
    }
}