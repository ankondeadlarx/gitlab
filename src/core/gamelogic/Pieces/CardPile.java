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
     * Scramble shuffle algorithm
     * Simulates a shuffle method where the cards are dispersed at random on the table and brought back togehter
     *
     * @Param cards Given a list of cards to scramble
     *
     * @Return The list of cards in the scrambled order
     */
    public static List<Card> scrambleShuffle(List<Card> cards) {
        List<Card> shuffledCards = new ArrayList<>(); //create list for shuffled cards
        int deckSize = cards.size(); //int stored for purpose of loop parameter

        while (shuffledCards.size() < deckSize) {
            int randomNum = randomNum(cards.size()); //randomly chooses a valid index for cards to add
            shuffledCards.add(cards.get(randomNum)); //add random card to shuffled list
            cards.remove(randomNum); //remove the card from the original list to avoid duplicates
        }

        return shuffledCards; //return shuffled deck
    }

    /**
     * Cut algorithm
     * Cuts a deck at a random point and flips the top half to the bottom and bottom to top
     *
     * @Param cards list
     *
     * @Return cards list after being cut
     */
    public static List<Card> cut (List<Card> cards) {
        List<Card> cutDeck = new ArrayList<>(); //list that will be returned at the end
        int randomNum = randomNum(cards.size()); //will find a spot in the deck to cut

        //for loops that will add the bottom part of the deck first and then the top part
        for (int i = randomNum; i < cards.size(); i++) { //bottom part
            cutDeck.add(cards.get(i));
        }
        for (int i = 0; i < randomNum; i++) { //top part
            cutDeck.add(cards.get(i));
        }

        //return cut deck
        return cutDeck;
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

