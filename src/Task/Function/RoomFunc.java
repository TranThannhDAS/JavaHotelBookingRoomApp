package Task.Function;

import Entity.Room;
import Task.Inteface.IBookingHotel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Enum.RoomType;
import Exception.*;
import static Task.HandleException.CheckExceptionFunction.isRoomID;

public class RoomFunc implements IBookingHotel<Room> {
    public static final String rootPath = System.getProperty("user.dir");
    public static final String roomPath = rootPath.replace("\\", "/") + "/src/Data/Room.txt";
    public static final List<Room> roomList = new ArrayList<Room>();
    private final Room room = new Room();
    public Room getRoom(){
        return this.room;
    }
    Scanner scanner = new Scanner(System.in);
    public String bookingRoomType(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Please enter the room type you want to book:
                1. Single
                2. Double
                3. Queen
                4. Quad
                5. Triple
                """);
        int roomType = scanner.nextInt();
        switch (roomType){
            case 1:
                return RoomType.SINGLE.toString();
            case 2:
                return RoomType.DOUBLE.toString();
            case 3:
                return RoomType.QUEEN.toString();
            case 4:
                return RoomType.QUAD.toString();
            case 5:
                return RoomType.TRIPPLE.toString();
            default:
                System.out.println("Invalid room type");
                return null;
        }
    }
    @Override
    public void saveData() {
        try {
            System.out.println("Please enter the room ID: format RO-XXXX (X is a number from 0-9)");
            String roomID = scanner.nextLine();
            // check room ID is valid
            if(isRoomID(roomID)){
                room.setRoomID(roomID);
            }
            System.out.println("Please enter the room type: ");
            room.setRoomType(bookingRoomType());
            System.out.println("Please enter the price per hour: ");
            room.setPrice_per_hour(scanner.nextDouble());

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(roomPath, true));
            bufferedWriter.write(room.getRoomID() + "," + room.getRoomType() + "," + room.getPrice_per_hour());
            bufferedWriter.newLine();
            bufferedWriter.close();
        }
        catch (InvalidRoomIDException e){
            System.out.println(e.getMessage());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Room> getData() {
        BufferedReader bufferedReaderRoom = null;
        try {
            bufferedReaderRoom = new BufferedReader(new FileReader(roomPath));
            String line;
            while ((line = bufferedReaderRoom.readLine()) != null){
                String[] roomData = line.split(",");
                Room room = new Room(roomData[0], roomData[1], Double.parseDouble(roomData[2]));
                roomList.add(room);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return this.roomList;
    }

}

