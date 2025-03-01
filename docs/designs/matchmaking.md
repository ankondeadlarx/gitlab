# Matchmaking and Player Statistics System Design

## Player Matchmaking:

***Motivation:***

Skill based matchmaking systems exist to encourage healthy competition by providing players with opponents who are at their exact same skill level. However, this comes with several downsides that should be addressed before making a traditional system.
1. Games are fundamentally designed for fun, and matchmaking creates a stale player experience by providing what is essentially the same game repeatedly, *forever*.
2. Matchmaking pushes players to always be playing at their best, which causes stress, dampens fun, and discourages players from playing when wanting to relax.
3. When a player gets too skilled at the game they struggle to find matches quickly because the game cannot find other players to match them with.

***Design:***
1. Players will have an experience level which represents their success over time. This level gradually increases as they play and earn points.
    - Each level will require more points than the last to reach the next level. This means that the first several levels will all be relatively close in skill, and that more skilled players will all be quite close in level.
    - This level does not depreciate over time, so it more accurately represents how long a player has played. Playing with high skill will increase their level faster, but playing non-seriously will not be punishing.
2. 