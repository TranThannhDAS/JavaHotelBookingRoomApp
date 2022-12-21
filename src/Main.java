import Entity.Booking;
import Task.Function.BookingFunc;
import Task.MyTask;

import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        BookingFunc bookingFunc = new BookingFunc();
        MyTask myTask = new MyTask();
        System.out.println("Welcome to the Booking Management System");
        System.out.println("Enter number of booking");
        Scanner sc = new Scanner(System.in);
        int numberOfBooking = sc.nextInt();
        for(int i = 0; i < numberOfBooking ; i++){
            bookingFunc.saveData();
        }
        List<Booking> myBookingList = bookingFunc.getData();

        System.out.println("Enter the searching room ID: ");
        myTask.searchBookingDataByRoomID(sc.next(),myBookingList);
        System.out.println("Enter the searching customer name: ");
        myTask.searchBookingDataByCustomerName(sc.next(),myBookingList);
        System.out.println("Enter the searching phone number: ");
        myTask.bookingListbyPhone(sc.next(),myBookingList);
        System.out.println("Enter the searching room type: ");
        double revenueByRoomType = myTask.revenueByRoomType(sc.next(),myBookingList);
        System.out.println("The revenue by room type is: " + revenueByRoomType);
        System.out.println("The highest revenue room type is: " + myTask.highestRevenueRoomType(myBookingList));


    }
}