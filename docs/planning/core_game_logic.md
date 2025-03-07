# Core Game Logic System Design

## General

***Preamble:***

Every game will have some universal functionalities that will be made as parental classes within the `gamelogic` directory whose functionality will be inherited by child classes for specific games inside the subdirectories `connect4`, `checkers`, and `whist` respectively.

***Design:***

Universal Functionalities:
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

| Attributes               | Description                                            |
|--------------------------|--------------------------------------------------------|
| GameType (Enum) {}       | Available Game Types: CONNECT4, CHECKERS, WHIST        |
| + gameType (GameType)    | The specific game being played                         |
| + players (Player Array) | The list of all players participating in the Game      |
| - avgPlays (int)         | The average plays a Game takes to conclude             |
| - winner (Player)        | The Player declared winner of the Game                 |
| - firstTurn (Player)     | The Player declared the first to take a turn in a Game |


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

Technical Aspects:
- This game uses playing cards, so there will be a `Card` class which stores all the information pertaining to each card

| Attributes           | Description                                                        |
|----------------------|--------------------------------------------------------------------|
| SuitType (enum) {}   | Available Suit Types: CLUBS, SPADES, HEARTS, DIAMONDS              |
| - rank (int)         | The Numerical Rank of the Card                                     |
| - suit (SuitType)    | The Suit Type of the Card                                          |
| - held (boolean)     | The Holder of the Card. true = One Player, false = All Players     |
| - faceDown (boolean) | The Visibility of the Card for the Holder. true = Down, false = Up |

- This game uses multiple piles of cards, so there will be a `Pile` class which stores an array of cards

| Attribute              | Description                                                           |
|------------------------|-----------------------------------------------------------------------|
| + cards (Card Array)   | The Array of all Cards this Pile Contains                             |
| + visibleTop (boolean) | The Visibility of the topmost Card. true = Face-Up, false = Face-Down |

- There will be a `WhistGame` class which inherits from the `Game` class and handles the logic of the game

| Unique Attributes | Description                                   |
|-------------------|-----------------------------------------------|
| + deck (Pile)     | The initial Deck of 52 Cards, randomly sorted |
| + draw (Pile)     | The Pile for Players to draw from             |
| + discard (Pile)  | The Pile for Discarded Cards                  |

Goal of Play:
- Over multiple rounds, the first player to reach 6 points is declared the winner. The current round is displayed in the top right corner with the names and score of each player beneath. The average number of rounds to win is 8.

Order of Play:
1. At the start of the game, a Pile called `deck` will be made
2. At the onset of each round, the Dealer must be selected. To select the dealer, the players must both draw a card at the same time from a face-down deck of 52 cards splayed out on the screen. Whoever selects the lowest ranked card is deemed the dealer. 


