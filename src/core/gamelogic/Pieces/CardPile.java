package core.gamelogic.Pieces;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.*;

public class CardPile {

    private static int randomNum(int cardAmount) { //generates a random number for the size of the deck needed
        Random random = new Random();
        int randomNumber = random.nextInt(cardAmount);
        return randomNumber;
    }

    /*
        Takes a deck of cards and shuffles it like a riffle shuffle
        Returns shuffled deck
     */
    public static List<Card> riffleShuffle(List<Card> cards) {
        List<Card> shuffledCards = new ArrayList<>();
        int deckLength = (int) (cards.size()/2); //keeps the original size stored and keeps as whole number

        //Make 2 lists for top and bottom half of deck
        List<Card> topHalf = new ArrayList<>();
        List<Card> bottomHalf = new ArrayList<>();

        for (int i = 0; i < deckLength; i++) {
            bottomHalf.add(cards.get(i));
        }
        for (int i = deckLength; i < cards.size(); i++) {
            topHalf.add(cards.get(i));
        }

        while (shuffledCards.size() < cards.size()) {
            int randomNum = randomNum(2); //random number will decide if top or bottom half is placed first

            if (randomNum == 0) {
                shuffledCards.add(bottomHalf.getLast());
                shuffledCards.add(topHalf.getLast());

                //remove placed cards
                bottomHalf.removeLast();
                topHalf.removeLast();
            } else if (randomNum == 1) {
                shuffledCards.add(topHalf.getLast());
                shuffledCards.add(bottomHalf.getLast());

                //remove placed cards
                topHalf.removeLast();
                bottomHalf.removeLast();
            }
        }
        return shuffledCards;
    }

    public static String toString(List<Card> cards) { //prints out a deck in the order it is in the pile
        String cardList = "[";
        //Index and size to track when the last element comes
        int index = 0;
        int size = cards.size();
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
            //Only add a comma if not the last element
            if (index < size - 1) {
                cardList = cardList + ", ";
            }
            index++;
        }
        cardList = cardList + "]";
        return cardList;
    }
}

