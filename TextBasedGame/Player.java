// Player.java
public class Player {
    private Room currentRoom;
    private boolean hasItem; // boolean that checks if player has grabbed the item

    public Player(Room startingRoom, boolean hasItem) {
        this.currentRoom = startingRoom;
        this.hasItem = hasItem;
    }


    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public boolean getHasItem(){
        return hasItem;
    }

    public void setHasItem(boolean hasItem){
        this.hasItem = hasItem;
    }

    public void moveLeft() {
        if (currentRoom.getLeftRoom() != null) {
            setCurrentRoom(currentRoom.getLeftRoom());
        } else {
            System.out.println("////THE LEFT DOOR WON'T OPEN!////");
        }
    }

    public void moveRight() {
        if (currentRoom.getRightRoom() != null) {
            setCurrentRoom(currentRoom.getRightRoom());
        } else {
            System.out.println("////THE RIGHT DOOR WON'T OPEN!////");
        }
    }

    public void moveBack() {
        if (currentRoom.getBackRoom() != null) {
            setCurrentRoom(currentRoom.getBackRoom());
        } else {
            System.out.println("////THE BACK DOOR WON'T OPEN!////");
        }
    }
}
