# Core Game Logic System Design

## General

***Preamble:***

Every game will have some universal functionalities that will be made as parental classes within the `gamelogic` directory whose functionality will be inherited by child classes for specific games inside the subdirectories `connect4`, `checkers`, and `whist` respectively.

***Design:***

*Universal Functionalities:*
- There will be a `Player` class which handles the logic and features all players have

| Attributes        | Description                                             |
|-------------------|---------------------------------------------------------|
| - accountID (int) | The account number of this Player                       |
| + name (String)   | The name within the account                             |
| + gameLevel (int) | The player's experience level in a specific Game Type   |
| + plays (int)     | The number of turns/rounds in a Game made by the Player |
| + score (int)     | The score the Player has earned in a Game               |
| + hand (Array)    | The items in possession of the Player                   |

- There will be a `Game` class which handles the logic and features all games have

| Attributes               | Description                                       |
|--------------------------|---------------------------------------------------|
| GameType (Enum) {}       | Available Game Types: CONNECT4, CHECKERS, WHIST   |
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

*Goal of Play:*
- Over multiple rounds, the first player to reach 6 points is declared the winner. The current round is prominently displayed in the top right corner. The points to win is prominently displayed in the top left corner with the names and score of each player beneath. The average number of rounds to win is 8.

*Order of Play:*
- At the onset of each round, the Dealer must be selected to shuffle up the deck and deal out the cards
    - The players are given a prompt to choose a card to compete for the Dealer position.
    - To select the dealer, the players must both draw a card at the same time from a face-down deck of 52 cards splayed out on the screen. 
    - Each player's selection is displayed and whoever selects the lowest ranked card is deemed the Dealer (they get the first turn). 
    - The drawn cards are then placed back to the bottom of the deck.
    - There is a 10 second timer for selection. *(All Timers will be implemented once Real-Time Interactions exist)*

*Gameplay:*

The Game has entered the Dealing Stage, which is displayed under the current round in the top right corner.
1. The Deck is given to the Dealer who must perform three shuffles on the deck.
    - The Dealer is given a text prompt to shuffle the Deck, including how many shuffles they have to perform.
    - To perform each shuffle, the Dealer must click on one of the few types of shuffles that will be shown at the bottom of the screen, glowing white.
    - There will be a 10 second timer through the whole shuffling process.
2. The shuffled Deck is retained by the Dealer as they still have to deal out the cards.
    - The Dealer is given a text prompt to deal the cards and the topmost card of the Deck will glow white.
    - To deal the cards, the Dealer must click the topmost card repeatedly, which will alternate between giving the Opponent and the Dealer a single card. Dealing the cards will be complete once each Player has 13 cards.
    - When a card is clicked, it is removed from the Deck pile and put into the appropriate Player's hand.
    - The remaining cards in the Deck pile are transferred into the Draw pile, which is in the middle of the table and off to the right.
3. The Dealer must now reveal the Trump Suit for the round to enter the first stage of play.
    - The Dealer is given a text prompt to reveal the Trump Suit, and the topmost card on the Draw pile will glow white.
    - To reveal the Trump Suit, the Dealer must click the topmost card on the Draw pile.
    - Both players will be given a text prompt showing the Trump Suit of the round.

The Game has entered the Drafting Stage, with the Trump Suit and Stage being displayed under the current round in the top right corner.
1. 

