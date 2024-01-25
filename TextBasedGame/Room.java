// Room.java
public class Room {
    private String name;
    private String description;
    private boolean isExit;

    private Room leftRoom;
    private Room rightRoom;

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
    public boolean isExit() {
        return isExit;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
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
}
