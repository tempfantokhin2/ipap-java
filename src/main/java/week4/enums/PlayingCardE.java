package week4.enums;

public class PlayingCardE {
    private Suit suit;
    private String rank;

    public PlayingCardE(Suit suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "PlayingCard{" +
                "suit='" + suit + '\'' +
                ", rank='" + rank + '\'' +
                '}';
    }

    public Suit getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }
}
