Simple Java Chat simulation App:
This is a basic Java console-based chatroom application that demonstrates user interaction, message storage, and mapping users to their respective chat histories.

Features:
-Prompt-based user interface via Scanner. 
-Users can join a chatroom and send messages.
-Messages are timestamped and stored.
-Maintains a chat history for each user using a HashMap<User, List<Message>>.
-Each User is uniquely identified by their username.
-Messages and users are stored and printed in a readable format.

Project Structure
  Main.java:
     -Entry point of the application.
     -Manages user input and interaction flow.
     -Stores and displays user-message mappings.

User.java:
   -Represents a user with a unique username. 
   -Implements Comparable for sorting.
   -Overrides equals() and hashCode() to ensure proper functioning in HashMap.
   -Stores a set of all users (although not used globally in the current design).

Message.java:
  -Represents a message with a timestamp.
  -Generic class allowing message of any type (T).
  -Implements Comparable to sort messages by timestamp.

How It Works:
-The app prompts the user: "You wanna join chatroom:"
-If the user replies yes, they are asked to input a username and a message.
-Each message is saved and associated with that User in the history map.
-Typing Exit or an empty username breaks the loop.
-After exiting, all chat history is displayed.


