import java.util.*;
import java.io.*;

public class Bank implements HasMenu {

    private Admin admin;
    private ArrayList<Customer> customers;
    private Scanner input = new Scanner(System.in);

    public static void main(String[] args){
        new Bank();
    }

    public Bank(){

        admin = new Admin();

        // FIRST RUN ONLY (use once if needed)
        // loadSampleCustomers();
        // saveCustomers();

        loadCustomers();
        start();
        saveCustomers();
    }

    // ================= MAIN MENU =================

    public String menu(){
        return "\nBank Menu\n\n"
        + "0) Exit system\n"
        + "1) Login as admin\n"
        + "2) Login as customer\n";
    }

    public void start(){

        String choice;

        do{
            System.out.println(menu());
            System.out.print("Action: ");
            choice = input.nextLine();

            switch(choice){

                case "1":
                    if(admin.login()){
                        startAdmin();
                    }
                    break;

                case "2":
                    loginAsCustomer();
                    break;

                case "0":
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid option");
            }

        } while(!choice.equals("0"));
    }

    // ================= ADMIN CONTROL =================

    public void startAdmin(){

        String choice;

        do{
            System.out.println(admin.menu());
            System.out.print("Action: ");
            choice = input.nextLine();

            switch(choice){

                case "1":
                    reportAllUsers();
                    break;

                case "2":
                    addUser();
                    break;

                case "3":
                    applyInterest();
                    break;

                case "0":
                    break;

                default:
                    System.out.println("Invalid option");
            }

        } while(!choice.equals("0"));
    }

    public void reportAllUsers(){

        System.out.println("Full customer report");

        for(Customer c : customers){
            System.out.println(c.getReport());
        }
    }

    public void addUser(){

        System.out.print("Name: ");
        String name = input.nextLine();

        System.out.print("PIN: ");
        String pin = input.nextLine();

        Customer c = new Customer(name, pin);
        customers.add(c);

        System.out.println("User added.");
    }

    public void applyInterest(){

        System.out.println("Applying interest...");

        for(Customer c : customers){
            c.getSavings().calcInterest();
            System.out.println("New balance: " + c.getSavings().getBalanceString());
        }
    }

    // ================= CUSTOMER LOGIN =================

    public void loginAsCustomer(){

        System.out.print("User name: ");
        String user = input.nextLine();

        System.out.print("PIN: ");
        String pin = input.nextLine();

        Customer currentCustomer = null;

        for(Customer c : customers){
            if(c.login(user, pin)){
                currentCustomer = c;
                break;
            }
        }

        if(currentCustomer != null){
            currentCustomer.start();
        } else {
            System.out.println("Login failed");
        }
    }

    // ================= SAMPLE DATA =================

    public void loadSampleCustomers(){

        customers = new ArrayList<>();

        Customer a = new Customer("Alice", "0000");
        a.getChecking().setBalance(1000);
        a.getSavings().setBalance(1000);
        a.getSavings().setInterestRate(0.05);

        customers.add(a);
        customers.add(new Customer("Bob", "1111"));
        customers.add(new Customer("Cindy", "2222"));
    }

    // ================= SERIALIZATION =================

    public void saveCustomers(){

        try{
            ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("customers.dat")
            );

            out.writeObject(customers);
            out.close();

        } catch(Exception e){
            System.out.println("Error saving data");
        }
    }

    public void loadCustomers(){

        try{
            ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("customers.dat")
            );

            customers = (ArrayList<Customer>) in.readObject();
            in.close();

        } catch(Exception e){
            System.out.println("No existing data. Loading defaults.");
            loadSampleCustomers();
        }
    }
}
