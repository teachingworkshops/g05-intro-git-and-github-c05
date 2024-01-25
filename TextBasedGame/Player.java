// Player.java
public class Player {
    private Room currentRoom;

    public Player(Room startingRoom) {
        this.currentRoom = startingRoom;
    }


    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void moveLeft() {
        if (currentRoom.getLeftRoom() != null) {
            setCurrentRoom(currentRoom.getLeftRoom());
        } else {
            System.out.println("Cannot move left. No room available.");
        }
    }

    public void moveRight() {
        if (currentRoom.getRightRoom() != null) {
            setCurrentRoom(currentRoom.getRightRoom());
        } else {
            System.out.println("Cannot move right. No room available.");
        }
    }
}
