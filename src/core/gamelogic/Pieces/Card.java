package core.gamelogic.Pieces;

public class Card extends GamePiece{
    private SuitType suit;
    private int rank;
    private boolean faceDown;

    public Card(SuitType suit, int rank, boolean faceDown) {
        this.suit = suit;
        this.rank = rank;
        this.faceDown = faceDown;
    }

    public SuitType getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    public boolean isFaceDown() {
        return faceDown;
    }

    public void flip() {
        faceDown = !faceDown;
    }

}