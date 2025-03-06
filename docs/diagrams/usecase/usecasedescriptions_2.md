
---

### Use Case: Friend System
**Iteration:** 1
**Primary Actor:** User
**Goal in Context:** Allow users to add, remove, and manage friends.
**Preconditions:**
1. The user is logged in.

**Trigger:** The user navigates to the "Friends" section.

**Scenario:**
1. The user accesses the "Friends" section.
2. The user searches for a friend using their username.
3. The system displays matching users.
4. The user selects a user and sends a friend request.
5. The recipient receives a notification and accepts/declines the request.
6. If accepted, the users are added to each other's friend lists.

**Post Conditions:**
- The friend request is successfully sent and added to the friend list if accepted.

**Exceptions:**
1. The searched user does not exist.
2. The recipient declines the friend request.
3. There is a network or system error.

**Priority:** Medium – Encourages social interaction.
**When Available:** Within the first development iteration.
**Frequency of Use:** Occasionally.
**Channel to Actor:** GUI interface via keyboard and mouse/touchscreen.
**Secondary Actors:** Database for storing friend lists.
**Channel to Secondary Actors:** System interacts with the database via queries.
**Open Issues:**
1. Should there be a blocking feature?
2. Should there be friend request limits?

---

### Use Case: Invite to Game
**Iteration:** 1
**Primary Actor:** User
**Goal in Context:** Allow users to invite friends to join a game session.
**Preconditions:**
1. The user is logged in.
2. The user has friends added to their account.

**Trigger:** The user wants to invite a friend to a game.

**Scenario:**
1. The user selects a game.
2. The user opens the friends list and selects a friend.
3. The system sends an invitation to the selected friend.
4. The invited friend receives a notification.
5. If accepted, the friend is added to the game session.

**Post Conditions:**
- The invited friend successfully joins the game.

**Exceptions:**
1. The friend declines or does not respond to the invite.
2. The friend is already in another game.
3. There are connection or system issues.

**Priority:** Medium – Enhances social gameplay.
**When Available:** Within the first development iteration.
**Frequency of Use:** Occasionally.
**Channel to Actor:** GUI interface via keyboard and mouse/touchscreen.
**Secondary Actors:** Game server for matchmaking.
**Channel to Secondary Actors:** System interacts with the game server via network communication.
**Open Issues:**
1. Should there be a time limit for accepting invites?
2. Should there be an auto-join option for specific friends?

---

### Use Case: Report User
**Iteration:** 1
**Primary Actor:** User
**Goal in Context:** Allow users to report other users for inappropriate behavior.
**Preconditions:**
1. The user is logged in.
2. The user encounters another user violating community guidelines.

**Trigger:** The user selects the "Report" option.

**Scenario:**
1. The user clicks the "Report" button on another user's profile or chat.
2. The system displays a report form with reasons for reporting (e.g., harassment, cheating).
3. The user selects a reason and submits the report.
4. The system logs the report and forwards it to moderators.
5. The system confirms that the report has been submitted.

**Post Conditions:**
- The report is logged, and moderators can review it.

**Exceptions:**
1. The system fails to submit the report due to an error.
2. The user reports someone without valid reason (false report).

**Priority:** Medium – Essential for community management.
**When Available:** Within the first development iteration.
**Frequency of Use:** Rare.
**Channel to Actor:** GUI interface via keyboard and mouse/touchscreen.
**Secondary Actors:** Moderation system or admin panel.
**Channel to Secondary Actors:** System stores reports in a database.
**Open Issues:**
1. Should there be penalties for false reports?
2. Should users receive updates on report outcomes?

---

### Use Case: Achievements
**Iteration:** 1
**Primary Actor:** User
**Goal in Context:** Allow users to unlock and track achievements.
**Preconditions:**
1. The user is logged in.

**Trigger:** The user meets the conditions for an achievement.

**Scenario:**
1. The user performs an action that qualifies for an achievement.
2. The system checks if the achievement is unlocked.
3. If unlocked, the system notifies the user.
4. The achievement is added to the user’s profile.

**Post Conditions:**
- The user sees the new achievement on their profile.

**Exceptions:**
1. The system fails to record the achievement due to a technical issue.

**Priority:** Medium – Increases player engagement.
**When Available:** Within the first development iteration.
**Frequency of Use:** Occasionally.
**Channel to Actor:** GUI interface via keyboard and mouse/touchscreen.
**Secondary Actors:** Database for storing achievements.
**Channel to Secondary Actors:** System interacts with the database via queries.
**Open Issues:**
1. Should achievements grant in-game rewards?
2. Should there be hidden achievements?

---
