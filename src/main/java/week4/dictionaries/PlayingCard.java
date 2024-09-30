package week4.dictionaries;

public class PlayingCard {
    private String suit;
    private String rank;

    public PlayingCard(String suit, String rank) {
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

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }
}
