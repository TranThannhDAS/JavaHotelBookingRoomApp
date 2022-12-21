package Task.HandleException;
import Exception.*;


public class CheckExceptionFunction {
    public static boolean isCustomerID(String customerID) throws InvalidCustomerIDException {
        boolean isCustomerID = true;
        if(!customerID.matches("KH-[0-9]{4}")){
            isCustomerID = false;
            throw new InvalidCustomerIDException("Customer ID must be in the format KH-XXXX (X is a number from 0-9)");
        }
        return isCustomerID;
    }
    public static boolean isCustomerName(String customerName) throws InvalidCustomerNameException {
        boolean isCustomerName = true;
        if(!customerName.matches("[A-Z][a-z]+")){
            isCustomerName = false;
            throw new InvalidCustomerNameException("Customer name must be capitalized");
        }
        return isCustomerName;
    }
    public static boolean isCustomerPhone(String customerPhone) throws InvalidCustomerPhoneException {
        boolean isCustomerPhone = true;
        if(!customerPhone.matches("0[0-9]{9}")){
            isCustomerPhone = false;
            throw new InvalidCustomerPhoneException("Customer phone must be in the format 0XXXXXXXXX (X is a number from 0-9)");
        }
        return isCustomerPhone;
    }
    public static boolean isDate(String date) throws InvalidDateException {
        boolean isDate = true;
        if(!date.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}")){
            isDate = false;
            throw new InvalidDateException("Date must be in the format dd/MM/yyyy");
        }
        return isDate;
    }
    public static boolean isRoomID(String roomID) throws InvalidRoomIDException {
        boolean isRoomID = true;
        if(!roomID.matches("RO-[0-9]{4}")){
            isRoomID = false;
            throw new InvalidRoomIDException("Room ID must be in the format RO-XXXX (X is a number from 0-9)");
        }
        return isRoomID;
    }
}
