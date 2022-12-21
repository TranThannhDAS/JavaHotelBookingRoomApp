package Task.Function;

import Entity.Booking;
import Entity.Customer;
import Entity.Room;
import Task.Inteface.IBookingHotel;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Task.HandleException.CheckExceptionFunction.isDate;
import Exception.*;
public class BookingFunc implements IBookingHotel<Booking> {
    public static final String rootPath = System.getProperty("user.dir");
    public static final String bookingPath = rootPath.replace("\\", "/") + "/src/Data/BookingData.txt";
    public static final List<Booking> bookingList = new ArrayList<Booking>();
    Scanner scanner = new Scanner(System.in);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public void saveData() {
        try {
            CustomerFunc customerFunc = new CustomerFunc();
            RoomFunc roomFunc = new RoomFunc();
            customerFunc.saveData();
            roomFunc.saveData();

            System.out.println("Please enter the booking ID: ");
            int bookingID = scanner.nextInt();
            System.out.println("Please enter the check in date: ");
            String checkInDate = scanner.next();
            System.out.println("Please enter the check out date: ");
            String checkOutDate = scanner.next();
            // Check date
            if(isDate(checkInDate)&&isDate(checkOutDate)){
                LocalDate checkIn = LocalDate.parse(scanner.next(), formatter);
                LocalDate checkOut = LocalDate.parse(scanner.next(), formatter);
                Booking booking = new Booking(bookingID,roomFunc.getRoom(),customerFunc.getCustomer(), checkIn, checkOut);
                FileWriter fileWriter = new FileWriter(bookingPath, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(booking.getId() +
                        "," + booking.getRoom().getRoomID() + "," + booking.getRoom().getRoomType() + "," + booking.getRoom().getPrice_per_hour() +
                        "," + booking.getCustomer().getCustomerID() + "," + booking.getCustomer().getCustomerName() + "," + booking.getCustomer().getCustomerPhone() +
                        "," + booking.getCheckIn() + "," + booking.getCheckOut());
                System.out.println("Booking information saved successfully!");
                bufferedWriter.newLine();
                bufferedWriter.close();
            }
        } catch (InvalidDateException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Booking> getData() {
        try {
            BufferedReader bufferedReaderBooking = new BufferedReader(new FileReader(bookingPath));
            String line;
            while ((line = bufferedReaderBooking.readLine()) != null){
                String[] bookingData = line.split(",");
                Booking booking = new Booking(Integer.parseInt(bookingData[0]),
                        new Room(bookingData[1], bookingData[2], Double.parseDouble(bookingData[3])),
                        new Customer(bookingData[4], bookingData[5], bookingData[6]),
                        LocalDate.parse(bookingData[7], formatter), LocalDate.parse(bookingData[8], formatter));
                bookingList.add(booking);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return bookingList;
    }
}

