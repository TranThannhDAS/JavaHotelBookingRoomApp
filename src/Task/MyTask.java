package Task;

import Entity.Booking;

import java.util.List;

public class MyTask {
    public double revenueByRoomType(String roomType, List<Booking> bookingList) {
        // CALCULATE REVENUE BY ROOM TYPE
        double revenueByRomtype = bookingList.stream()
                .filter(booking -> booking.getRoom().getRoomType().equals(roomType))
                .mapToDouble(booking -> booking.getRoom().getPrice_per_hour() * booking.getCheckIn().until(booking.getCheckOut()).getDays() * 24)
                .sum();
        return revenueByRomtype;
    }
    public List<Booking> searchBookingDataByCustomerName(String customerName, List<Booking> bookingList){
        List<Booking> bookingListByCustomerName = bookingList.stream()
                .filter(booking -> booking.getCustomer().getCustomerName().equals(customerName))
                .toList();
        return bookingListByCustomerName;
    }
    public List<Booking> searchBookingDataByRoomID(String roomID, List<Booking> bookingList){
        List<Booking> bookingListByRoomID = bookingList.stream()
                .filter(booking -> booking.getRoom().getRoomID().equals("R001"))
                .toList();
        return bookingListByRoomID;
    }
    public List<Booking> bookingListbyPhone(String customerPhone, List<Booking> bookingList){
        List<Booking> bookingListByPhone = bookingList.stream()
                .filter(booking -> booking.getCustomer().getCustomerPhone().equals(customerPhone))
                .toList();
        return bookingListByPhone;
    }
    public String highestRevenueRoomType(List<Booking> bookingList){
        String highestRevenueRoomType = bookingList.stream()
                .map(booking -> booking.getRoom().getRoomType())
                .distinct()
                .max((roomType1, roomType2) -> {
                    double revenueByRoomType1 = revenueByRoomType(roomType1, bookingList);
                    double revenueByRoomType2 = revenueByRoomType(roomType2, bookingList);
                    return Double.compare(revenueByRoomType1, revenueByRoomType2);
                })
                .get();
        return highestRevenueRoomType;
        //1. Tạo một Stream từ bookingList bằng cách sử dụng phương thức stream()
        //2. Áp dụng phương thức map() để chuyển đổi từng phần tử trong Stream thành loại phòng của nó.
        // Phương thức này sẽ trả về một Stream mới, mỗi phần tử của nó là loại phòng của một đặt phòng trong bookingList.
        //3. Áp dụng phương thức distinct() để loại bỏ các phần tử trùng lặp trong Stream.
        //4. Áp dụng phương thức max() để tìm ra phần tử có giá trị lớn nhất trong Stream.
        //5. Áp dụng phương thức get() để lấy ra phần tử có giá trị lớn nhất trong Stream.
    }
}
