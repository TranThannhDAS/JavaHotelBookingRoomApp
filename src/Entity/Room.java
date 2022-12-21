package Entity;

public class Room {
    private String roomID;
    private String roomType;
    private double price_per_hour;

    public Room() {
    }

    public Room(String roomID, String roomType, double price_per_hour) {
        this.roomID = roomID;
        this.roomType = roomType;
        this.price_per_hour = price_per_hour;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getPrice_per_hour() {
        return price_per_hour;
    }

    public void setPrice_per_hour(double price_per_hour) {
        this.price_per_hour = price_per_hour;
    }

    @Override
    public String toString() {
        return "Room: " +
                "roomID=" + roomID +
                ", roomType='" + roomType + '\'' +
                ", price_per_hour='" + price_per_hour + '\'' +
                '.';
    }
}
