# Core Game Logic System Design

## General

***Preamble:***

Every game will have some universal functionalities that will be made as parental classes within the `gamelogic` directory whose functionality will be inherited by child classes for specific games inside the subdirectories `connect4`, `checkers`, and `whist` respectively.

***Design:***

*Universal Functionalities:*
- There will be a `GameType` enum which declares the type of game

| Enum     | Description                      |
|----------|----------------------------------|
| CONNECT4 | Declares the Connect 4 Game Type |
| CHECKERS | Declares the Checker Game Type   |
| WHIST    | Declares the Whist Game Type     |

- There will be a `Player` class which handles the logic and features all players have

| Attributes        | Description                                             |
|-------------------|---------------------------------------------------------|
| - accountID (int) | The account number of this Player                       |
| + name (String)   | The name within the account                             |
| + gameLevel (int) | The player's experience level in a specific Game Type   |
| + plays (int)     | The number of turns/rounds in a Game made by the Player |
| + score (int)     | The score the Player has earned in a Game               |
| + hand (Array)    | The items in possession of the Player                   |
| + spoils (Array)  | The items the Player has captured                       |

- There will be a `Game` class (Perhaps Interface?) which handles the logic and features all games have

| Attributes               | Description                                       |
|--------------------------|---------------------------------------------------|
| + gameType (GameType)    | The specific game being played                    |
| + players (Player Array) | The list of all players participating in the Game |
| - avgPlays (int)         | The average plays a Game takes to conclude        |
| - winner (Player)        | The Player declared winner of the Game            |
| - currentTurn (Player)   | The Player who is currently taking a turn         |


- There will be a 

## Connect 4

***Preamble:***

This game will be the most casual of the games available to our users, but that does not mean it has no competitive rigor! One needs to get 4 pieces in a row while preventing their opponent from doing the same by blocking them. Each player will be assigned to the red or yellow colour and will compete to connect 4 pieces.

***Design:***

Order of Play:
- blag

## Checkers

***Preamble:***

This game will be one of our more competitive options, as it has a lot of space for skill expression. 

***Design:***



## Whist

***Preamble:***

This game will be our most paced game, as it is played over multiple rounds and so will take some time. This slower pace and round based format allows for exciting comebacks and requires strategic endurance on the part of both players. Players must compete to win tricks in two stages, trying to ensure that their hand is as good as possible while keeping in mind the possible hand of the other player.

***Design:***

*Technical Aspects:*

- This game used playing cards, so there will be a `SuitType` enum which contains all the available suits

| Enum     | Description               |
|----------|---------------------------|
| CLUBS    | Declares the Club Suit    |
| SPADES   | Declares the Spade Suit   |
| HEARTS   | Declares the Heart Suit   |
| DIAMONDS | Declares the Diamond Suit |

- This game uses playing cards, so there will be a `Card` class which stores all the information pertaining to each card

| Attributes           | Description                                                        |
|----------------------|--------------------------------------------------------------------|
| - rank (int)         | The Numerical Rank of the Card                                     |
| - suit (SuitType)    | The Suit Type of the Card                                          |
| - held (boolean)     | The Holder of the Card. true = One Player, false = All Players     |
| - faceDown (boolean) | The Visibility of the Card for the Holder. true = Down, false = Up |

- This game uses multiple piles of cards, so there will be a `Pile` class which stores an array of cards

| Attribute              | Description                                                           |
|------------------------|-----------------------------------------------------------------------|
| + cards (Card Array)   | The Array of all Cards this Pile Contains                             |

- There will be a `WhistGame` class which inherits from the `Game` class and handles the logic of the game

| Unique Attributes  | Description                                                                                |
|--------------------|--------------------------------------------------------------------------------------------|
| + round (int)      | The Numerical Round of the Game                                                            |
| + stage (String)   | The Current Stage of the Round                                                             |
| + trump (SuitType) | The Trump Suit for the Round                                                               |
| - deck (Pile)      | The initial Deck of 52 Cards. These are in standard order, are not held, and are Face-Down |
| - draw (Pile)      | The Pile for Players to draw from                                                          |
| - discard (Pile)   | The Pile for Discarded Cards                                                               |

- The cards are valued by rank from highest to lowest as 14 (Ace), 13 (King), 12 (Queen), 11 (Jack), 10, 9, 8, 7, 6, 5, 4, 3, 2.

*Goal of Play:*
- Over multiple rounds, the first player to reach 6 points is declared the winner. The current round is prominently displayed in the top right corner. The points to win is prominently displayed in the top left corner with the names and score of each player beneath. The average number of rounds to win is 8.

*Order of Play:*
- At the onset of each round, the Dealer must be selected to shuffle up the deck and deal out the cards
    - The players are given a prompt to choose a card to compete for the Dealer position.
    - To select the dealer, the players must both draw a card at the same time from a face-down deck of 52 cards splayed out on the screen. 
    - Each player's selection is displayed and whoever selects the lowest ranked card is deemed the Dealer (The Dealer is put into the currentTurn of the Game). 
    - The drawn cards are then placed back to the bottom of the deck.
    - There is a 10 second timer for selection. *(All Timers will be implemented once Real-Time Interactions exist)*

*Gameplay:*

The Game has entered the Dealing Stage, which is displayed under the current round in the top right corner.
1. The Deck is given to the Dealer who must perform three shuffles on the deck.
    - The Dealer is given a text prompt to shuffle the Deck, including how many shuffles they have to perform.
    - To perform each shuffle, the Dealer must click on one of the few types of shuffles that will be shown at the bottom of the screen, glowing white.
    - There will be a 7 second timer through the whole shuffling process.
2. The shuffled Deck is retained by the Dealer as they still have to deal out the cards.
    - The Dealer is given a text prompt to deal the cards and the topmost card of the Deck will glow white.
    - To deal the cards, the Dealer must click the topmost card repeatedly, which will alternate between giving the Opponent and the Dealer a single card. Dealing the cards will be complete once each Player has 13 cards.
    - When a card is clicked, it is removed from the Deck pile and put into the appropriate Player's hand (The given card's held attribute becomes true).
    - The remaining cards in the Deck pile are transferred into the Draw pile, which is in the middle of the table and off to the right.
    - There will be a 7 second timer through the whole dealing process.
3. The Dealer must now reveal the Trump Suit for the round to enter the first stage of play.
    - The Dealer is given a text prompt to reveal the Trump Suit, and the topmost card on the Draw pile will glow white.
    - To reveal the Trump Suit, the Dealer must click the topmost card on the Draw pile (The topmost card's faceDown attribute becomes false).
    - Both players will be given a text prompt showing the Trump Suit of the round.
    - The Dealer has concluded their turn (The opponent is put into the currentTurn of the Game).
    - The cards in the Players' hands are revealed to them (The faceDown attribute of all cards in each Players' hands becomes false).
    - There will be a 5 second timer for the revealing process.

The Game has entered the Drafting Stage, with the Trump Suit and Stage being displayed under the current round in the top right corner. This section of the Game loops until the Draw pile has been depleted.
1. The Trick begins, and the Player whose turn it is must select a card to lead the trick.
    - If the revealed card on the Draw deck is of the Trump Suit or has a Rank greater than 10, it will glow gold to indicate desirability.
    - The Player is given a text prompt to select a card to lead the trick.
    - To select a card, the Player must click on any one of the cards in their hand, which will be placed in the middle of the table face-up (The played card's held attribute becomes false).
    - The turn is now given over to the other Player.
    - There will be a 15 second timer for the trick leading process.
2. The Trick continues, and the Player whose turn it is must select a card to compete in the trick.
    - If the Player has cards that match the suit of the card in play, then they are given a text prompt to follow suit to complete the trick. All of their cards which do not match the played suit will be grayed out and unclickable.
    - If the Player does not have cards that match the suit of the card in play, then they are given a text prompt to select any card to complete the trick.
    - To select a card, the Player must click on any one of the available cards in their hand, which will be placed next to the leading card face-up (The played card's held attribute becomes false).
    - There will be a 15 second timer for the trick completing process.
3. The trick is complete, and the winner of this trick must be determined to see who gets the revealed card on the Draw pile.
    - The winner of the trick is determined by whichever played card has the highest rank (Trump Suited cards have their rank valued as rank + 14).
    - Each player's hand is checked to see if they possess the more valuable card.
    - The turn is now given to the Player who won the trick.
    - The played cards are both moved from the Players' hands into the Discard pile in the middle of the table to the left (Both card's faceDown attribute becomes true and their held attribute becomes false).
4. The Players must now draw one card each from the Draw pile, with the person whose turn it is going first.
    - Each Player, with the winner of the trick going first, will be given a text prompt to draw the topmost card. The topmost card in the Draw pile will be glowing white.
    - To take their card, the Player must click the Draw pile, which will move the topmost card into their hand (The drawn card's held attribute becomes true and its faceDown attribute becomes false).
    - The last Player to take a card will be given a text prompt to reveal the next prize card. The topmost card in the Draw pile will be glowing white.
    - To reveal the next prize card, the Player must click the Draw pile (The topmost card's faceDown attribute becomes false).
    - There will be a 5 second timer for each player for the drawing process.
    - If the Draw pile is not empty, the game will go through another loop of the Drafting Stage. If the Draw pile is empty, the game will move on to the next stage.

The Game has entered the Dueling Stage, with the Trump Suit and Stage being displayed under the current round in the rop right corner. This section of the Game loops until everyone's hand is empty.
1. The Trick begins, and the Player whose turn it is must select a card to lead the trick.
    - The Player is given a text prompt to select a card to lead the trick.
    - To select a card, the Player must click on any one of the cards in their hand, which will be placed in the middle of the table face-up (The played card's held attribute becomes false).
    - The turn is now given over to the other Player.
    - There will be a 15 second timer for the trick leading process.
2. The Trick continues, and the Player whose turn it is must select a card to compete in the trick.
    - If the Player has cards that match the suit of the card in play, then they are given a text prompt to follow suit to complete the trick. All of their cards which do not match the played suit will be grayed out and unclickable.
    - If the Player does not have cards that match the suit of the card in play, then they are given a text prompt to select any card to complete the trick.
    - To select a card, the Player must click on any one of the available cards in their hand, which will be placed next to the leading card face-up (The played card's held attribute becomes false).
    - There will be a 15 second timer for the trick completing process.
3. The trick is complete, and the winner of this trick must be determined to see who gets the revealed card on the Draw pile.
    - The winner of the trick is determined by whichever played card has the highest rank (Trump Suited cards have their rank valued as rank + 14).
    - Each player's hand is checked to see if they possess the more valuable card.
    - The turn is now given to the Player who won the trick.
    - The played cards are both moved from the Players' hands into the Winning Player's spoils and placed as a pair to the right of them (Both card's faceDown attribute becomes true).
    - If the Player's hands are not empty, the game will go through another loop of the Dueling Stage. If their hands are empty, the game will move on to the next stage.

The Round is now over, so the Game will calculate how many points each player earned that round to determine if the next round is to start.
1. The Game will calculate the score of each Player and compare it to the score needed to win the game
    - The score of each Player is calculated by taking the total number of pairs in their spoils and subtracting that number by 6.
    - The score of each Player is given to them and displayed in the top left corner.
    - If no score meets the required score to win, the game will go through another round of play. If one Player's score meets the required score to win, the game will conclude.

*Conclusion:*

When the game reaches its final state, it will use the parental class to declare the winner, calculate the experience points to award players, and communicate these results and other relevant information to the player's account.


