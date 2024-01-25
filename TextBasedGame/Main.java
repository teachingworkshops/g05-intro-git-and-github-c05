// Main.java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Room room1 = new Room("Room 1", "This is the starting room.");
        Room room2 = new Room("Room 2", "This room is dark and mysterious.");
        Room room3 = new Room("Room 3", "You see a light at the end of this room.");
        Room exitRoom = new Room("Exit Room", "Congratulations! You made it out!", true);

        room1.setLeftRoom(room2);
        room1.setRightRoom(room3);
        room3.setRightRoom(exitRoom); // Set the exit room at the end of room3

        Player player = new Player(room1);

        Scanner scanner = new Scanner(System.in);
        System.out.println("You don't know where you are other than the fact that you are in a room. There must be a way out of here...");

        while (true) {
            System.out.println("Description: " + player.getCurrentRoom().getDescription());
            System.out.println("Choose a door: (L)eft, (R)ight, (Q)uit");

            String choice = scanner.next();

            switch (choice.toUpperCase()) {
                case "L":
                    player.moveLeft();
                    break;
                case "R":
                    player.moveRight();
                    break;
                case "Q":
                    System.out.println("Exiting the game. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }

            if (player.getCurrentRoom().isExit()) {
                System.out.println("Congratulations! You made it out!");
                System.exit(0);
            }
        }
    }
}
