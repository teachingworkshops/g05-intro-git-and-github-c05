// Main.java
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
   

    public static void connectRooms(ArrayList<Room> rooms) throws FileNotFoundException{
        // Loop through each room except the last one
        

        for (int i = 0; i < rooms.size() - 1; i++) {
            Room currentRoom = rooms.get(i);
            Room nextRoom = rooms.get(i + 1);

            // Set the right room for the current room
            currentRoom.setRightRoom(nextRoom);

            // Set the left room for the next room
            nextRoom.setLeftRoom(currentRoom);
        }
    }

    public static ArrayList<Room> makeRooms() throws FileNotFoundException{
        String fileName = "C:\\Users\\shneydermand\\Documents\\GitHub\\g05-intro-git-and-github-c05\\TextBasedGame\\roomsConfig.txt";
        File configFile = new File(fileName);
        Scanner in = new Scanner(configFile);
        ArrayList<Room> rooms = new ArrayList<Room>();

        Room entranceRoom = new Room("Entrance Room", "You are in the Entrance Hall. Moss-covered walls surround you, and the air is damp. The faint glow reveals a path leading deeper into the dungeon.");
        Room exitRoom = new Room("Exit Room", "Congratulations! You made it out!", true);

        rooms.add(entranceRoom);

        int roomID = 1;
        String description = "";
        while(in.hasNextLine()){
            description=in.nextLine();
            rooms.add(new Room("Room "+roomID,description));
            roomID++;
        }
        rooms.add(exitRoom);

        for(Room room : rooms){
            System.out.println(room.getName() +" "+room.getDescription());
        }
        in.close();
        return rooms;
    }

    public static void main(String[] args) throws FileNotFoundException{

        
        ArrayList<Room> rooms = makeRooms();//creates rooms from config file
        connectRooms(rooms);//connects rooms
        Player player = new Player(rooms.get(0));

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
