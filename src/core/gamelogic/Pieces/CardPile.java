package core.gamelogic.Pieces;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.*;

/**
 * Handles the creation and handling of Piles of Cards for Playing Card Games.
 *
 * @authors Sameer Askar
 * @date March 13, 2025
 */
public class CardPile {

    private static int randomNum(int cardAmount) { //generates a random number for the size of the deck needed
        Random random = new Random();
        int randomNumber = random.nextInt(cardAmount);
        return randomNumber;
    }


    /**
     * Performs a Riffle Shuffle on a given Card Pile
     *
     * @param cards The given Card List to Riffle Shuffle
     *
     * @return The newly shuffled Card List
     */
    public static List<Card> riffleShuffle(List<Card> cards) {
        // The List which will store the shuffle result
        List<Card> shuffledCards = new ArrayList<>();
        // The size of half the Card Pile
        int deckHalf = (int) (cards.size() / 2);

        // The Lists for storing each half of the Card Pile after splitting it
        List<Card> topHalf = new ArrayList<>();
        List<Card> bottomHalf = new ArrayList<>();

        // Loops through the Card List, first from the start to the midpoint, then from the midpoint to the end
        // Each half is placed into separate Lists
        for (int i = 0; i < deckHalf; i++) {
            topHalf.add(cards.get(i));
        }
        for (int i = deckHalf; i < cards.size(); i++) {
            bottomHalf.add(cards.get(i));
        }

        // Performs the Riffle Shuffle on the Card Pile until all the Cards are in the Shuffled Cards List
        while (shuffledCards.size() < cards.size()) {
            // Randomly generates a number to determine which half of the Cards goes first
            int randomNum = randomNum(2);

            // Checks the random number
            if (randomNum == 1) {
                // Adds the bottom card of the top half first.
                shuffledCards.add(topHalf.getLast());
                shuffledCards.add(bottomHalf.getLast());

                // Removes those Cards from each half.
                topHalf.removeLast();
                bottomHalf.removeLast();

            } else if (randomNum == 0) {
                // Adds the bottom card of the bottom half first.
                shuffledCards.add(bottomHalf.getLast());
                shuffledCards.add(topHalf.getLast());

                // Removes those Cards from each half.
                bottomHalf.removeLast();
                topHalf.removeLast();
            }
        }

        // Returns the resulting list of shuffled Cards
        return shuffledCards;
    }


    /**
     * Creates a String which represents a given Card Pile
     *
     * @param cards The given Card List to make into a String
     *
     * @return The ordered Card List as a String
     */
    public static String toString(List<Card> cards) {
        // Initialized String to return
        String cardList = "[";

        // Variables the track when last element comes
        int index = 0;
        int size = cards.size();

        // Loops through the Card Pile to print the name of each Card within
        for (Card card : cards) {
            if (card.getRank() == 1) {
                cardList = cardList + "Ace of " + card.getSuit();
            } else if (card.getRank() == 11) {
                cardList = cardList + "Jack of " + card.getSuit();
            } else if (card.getRank() == 12) {
                cardList = cardList + "Queen of " + card.getSuit();
            } else if (card.getRank() == 13) {
                cardList = cardList + "King of " + card.getSuit();
            } else {
                cardList = cardList + card.getRank() + " of " + card.getSuit();
            }

            // Adds a common between entried only if it is not the final element
            if (index < size - 1) {
                cardList = cardList + ", ";
            }

            // Increments the index
            index++;
        }

        // Finalizes the String and returns it
        cardList = cardList + "]";
        return cardList;
    }
}

