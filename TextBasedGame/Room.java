// Room.java
public class Room {
    private String name;
    private String description;
    private boolean isExit;
    private boolean hasItem; // boolean to check if a room contains an item

    private Room leftRoom;
    private Room rightRoom;
    private Room backRoom;


    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.isExit = false;

    }

    public Room(String name, String description, boolean isExit) {
        this.name = name;
        this.description = description;
        this.isExit = isExit;
    }

    public void setHasItem(boolean hasItem){
        this.hasItem = hasItem;
    }
    public boolean getHasItem(){
        return hasItem;
    }
    public boolean isExit() {
        return isExit;
    }

    public String getName() {
        return name;
    }

    public String getDescription() { // added to method that if hasItem is true it will add an extra line of text regarding the item
        return (hasItem) ? description + "There seems to be a key hanging off a wall. Grab it?" : description;
    }

    public Room getBackRoom() {
        return backRoom;
    }

    public void setBackRoom(Room backRoom) {
        this.backRoom = backRoom;
    }

    public Room getLeftRoom() {
        return leftRoom;
    }

    public void setLeftRoom(Room leftRoom) {
        this.leftRoom = leftRoom;
    }

    public Room getRightRoom() {
        return rightRoom;
    }

    public void setRightRoom(Room rightRoom) {
        this.rightRoom = rightRoom;
    }

    public void stringify (){
        System.out.printf("Name: %s, Left: %s, Right: %s",this.name,this.leftRoom.name,this.rightRoom.name);
    }

    
}
