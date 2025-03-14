package core.gamelogic.Pieces;

/**
 * Handles the creation and handling of Cards for Playing Card Games.
 *
 * @authors Sameer Askar
 * @date March 13, 2025
 */
public class Card extends GamePiece {
    // ATTRIBUTES
    private SuitType suit;
    private int rank;
    private boolean faceDown;


    public Card(SuitType suit, int rank, boolean faceDown) {
        this.suit = suit;
        this.rank = rank;
        this.faceDown = faceDown;
    }


    // GETTERS

    public String getSuit() {
        return suit.getDisplayName();
    }

    public int getRank() {
        return rank;
    }

    public boolean isFaceDown() {
        return faceDown;
    }


    // METHODS

    public void flip() {
        faceDown = !faceDown;
    }

}