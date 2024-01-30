// Room.java
public class Room {
    private String name;
    private String description;
    private boolean isExit;
    private boolean visited;

    private Room leftRoom;
    private Room rightRoom;
    private Room backRoom;


    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.isExit = false;
        this.visited = false;

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

    public void visit(){
        this.visited = true;
    }

    public boolean isVisited(){
        return this.visited;
    }
}
