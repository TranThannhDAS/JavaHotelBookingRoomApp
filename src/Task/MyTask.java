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
        //1. T???o m???t Stream t??? bookingList b???ng c??ch s??? d???ng ph????ng th???c stream()
        //2. ??p d???ng ph????ng th???c map() ????? chuy???n ?????i t???ng ph???n t??? trong Stream th??nh lo???i ph??ng c???a n??.
        // Ph????ng th???c n??y s??? tr??? v??? m???t Stream m???i, m???i ph???n t??? c???a n?? l?? lo???i ph??ng c???a m???t ?????t ph??ng trong bookingList.
        //3. ??p d???ng ph????ng th???c distinct() ????? lo???i b??? c??c ph???n t??? tr??ng l???p trong Stream.
        //4. ??p d???ng ph????ng th???c max() ????? t??m ra ph???n t??? c?? gi?? tr??? l???n nh???t trong Stream.
        //5. ??p d???ng ph????ng th???c get() ????? l???y ra ph???n t??? c?? gi?? tr??? l???n nh???t trong Stream.
    }
}
