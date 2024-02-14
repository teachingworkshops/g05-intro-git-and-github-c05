// Main.java
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
   

    public static void connectRooms(Room[] rooms) throws FileNotFoundException {
        int roomCount = rooms.length;
    
        // Special case for an empty array
        if (roomCount == 0) {
            return;
        }
    
        Room root = rooms[0];//sets entrance as root
    
        // use a queue to maintain the parent nodes for connecting children
        Queue<Room> queue = new LinkedList<>();
        queue.offer(root);//
    
        int i = 1;//ignores start room
    
        while (i < roomCount) {
            Room parent = queue.poll();//grabs current room to assign children to
    

            if(Math.random()>0.5){ //randomly assigns the next 2 rooms (50% left-right, 50% right-left)
                // Connect the left child
                if (i < roomCount) {
                    Room leftChild = rooms[i];
                    parent.setLeftRoom(leftChild);
                    leftChild.setBackRoom(parent); // Save back room
                    queue.offer(leftChild);
                    i++;
                }
        
                // Connect the right child
                if (i < roomCount) {
                    Room rightChild = rooms[i];
                    parent.setRightRoom(rightChild);
                    rightChild.setBackRoom(parent); // Save back room
                    queue.offer(rightChild);
                    i++;
                }
            }else{
                
        
                // Connect the right child
                if (i < roomCount) {
                    Room rightChild = rooms[i];
                    parent.setRightRoom(rightChild);
                    rightChild.setBackRoom(parent); // Save back room
                    queue.offer(rightChild);
                    i++;
                }

                // Connect the left child
                if (i < roomCount) {
                    Room leftChild = rooms[i];
                    parent.setLeftRoom(leftChild);
                    leftChild.setBackRoom(parent); // Save back room
                    queue.offer(leftChild);
                    i++;
                }
            }
        }
    }
    
    

    public static ArrayList<Room> makeRooms(String difficulty) throws FileNotFoundException{
        String fileName = "roomsConfig.txt";
        File configFile = new File(fileName);
        Scanner in = new Scanner(configFile);
        ArrayList<Room> rooms = new ArrayList<Room>();
        Random rand = new Random();

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
        

        if(difficulty.equalsIgnoreCase("H")){ //if the difficulty is H (Hard), a room will be selected randomly to have the item in it
            int randomInt = rand.nextInt(rooms.size());

            Room itemRoom = rooms.get(randomInt);
            System.out.println(randomInt);

            itemRoom.setHasItem(true);
        }

        rooms.add(exitRoom);

        /*for(Room room : rooms){
            System.out.println(room.getName() +" "+room.getDescription());
        }*/
        in.close();
        return rooms;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Maze Game!");
        String difficulty = "";
        while(!difficulty.equalsIgnoreCase("R") && !difficulty.equalsIgnoreCase("H")){
        System.out.println("You can pick two modes: (R)egular or (H)ard");
        difficulty = scanner.next();
        }
        
        ArrayList<Room> rooms = makeRooms(difficulty); // creates rooms from config file
        Room[] roomsArray = rooms.toArray(new Room[rooms.size()]);
        connectRooms(roomsArray); // connects rooms
        Player player = new Player(rooms.get(0), false);//creates player in start room
    
        System.out.println("You don't know where you are other than the fact that you are in a room. There must be a way out of here...");
    
        int steps = 0;
    
        while (true) {
            System.out.println("Description: " + player.getCurrentRoom().getDescription());
            System.out.println("Choose a door: (L)eft, (R)ight, (B)ack," + (player.getCurrentRoom().getHasItem() ? " (G)rab, " : "") + " (Q)uit\n-----------------------------------------------------");
    
            String choice = scanner.next();
    
            switch (choice.toUpperCase()) {
                case "L":
                    player.moveLeft();
                    steps++;
                    break;
                case "R":
                    player.moveRight();
                    steps++;
                    break;
                case "B":
                    player.moveBack();
                    steps++;
                    break;
                case "G": //Checks if the player grabs the key.
                    if(player.getCurrentRoom().getHasItem() && difficulty.equalsIgnoreCase("H")){
                        player.setHasItem(true);
                        player.getCurrentRoom().setHasItem(false);
                    } else {
                        System.out.println("Invalid choice. Try again.");
                    }
                    break;
                case "Q":
                    System.out.println("Exiting the game. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
    
            System.out.println("Running count of steps: " + steps); // Print the running count of steps

            
    
            if (player.getCurrentRoom().isExit()) {
                if(player.getHasItem() && difficulty.equalsIgnoreCase("H")|| difficulty.equalsIgnoreCase("R")){ // When player reaches exist, it is check what difficulty the game was set to also if the player has the item when it is hard difficulty
                scanner.close();
                System.out.println("Congratulations! You made it out in " + steps + " steps!");
                System.exit(0);
            } else {
                System.out.println("The exit seems to be locked. Go back and find the key.");
                player.moveBack();
            }
        }
        }
    }
    
}
