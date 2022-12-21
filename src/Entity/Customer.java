package Entity;

public class Customer {
    private String customerID;
    private String customerName;
    private String customerPhone;

    public Customer() {
    }

    public Customer(String customerID, String customerName, String customerPhone) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    @Override
    public String toString() {
        return "Customer: " +
                "customerID=" + customerID +
                ", customerName='" + customerName + '\'' +
                ", customerPhone='" + customerPhone + '\'' +
                '.';
    }
}
