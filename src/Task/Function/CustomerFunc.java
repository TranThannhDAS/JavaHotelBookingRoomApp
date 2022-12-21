package Task.Function;

import Entity.Customer;
import Task.Inteface.IBookingHotel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Exception.*;
import static Task.HandleException.CheckExceptionFunction.*;


public class CustomerFunc implements IBookingHotel<Customer> {
    public static final String rootPath = System.getProperty("user.dir");
    public static final String customerPath = rootPath.replace("\\", "/") + "/src/Data/Customer.txt";
    public static final List<Customer> customerList = new ArrayList<Customer>();
    private final Customer customer = new Customer();
    Scanner scanner = new Scanner(System.in);
    public Customer getCustomer(){
        return this.customer;
    }
    @Override
    public void saveData() {
        try {
            //check cutomerID and customerName
            System.out.println("Please enter the customer ID: KH-XXXX (X is a number from 0-9) ");
            String customerID = scanner.nextLine();
            System.out.println("Please enter the customer name: capitalized name");
            String customerName = scanner.nextLine();
            System.out.println("Please enter the customer phone number: 0XXXXXXXXX (X is a number from 0-9) ");
            String customerPhone = scanner.nextLine();
            if(isCustomerID(customerID) && isCustomerName(customerName)&& isCustomerPhone(customerPhone)){
                customer.setCustomerID(customerID);
                customer.setCustomerName(customerName);
                customer.setCustomerPhone(customerPhone);
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(customerPath, true));
            bufferedWriter.write(customer.toString());
            bufferedWriter.newLine();
            bufferedWriter.close();
        }
        catch (InvalidCustomerIDException|InvalidCustomerNameException|InvalidCustomerPhoneException e){
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
    public List<Customer> getData() {
        try{
            String line;
            BufferedReader bufferedReaderCustomer = new BufferedReader(new FileReader(customerPath));
            while ((line = bufferedReaderCustomer.readLine()) != null){
                String[] customerData = line.split(",");
                Customer customer = new Customer(customerData[0], customerData[1], customerData[2]);
                customerList.add(customer);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return this.customerList;
    }
}
