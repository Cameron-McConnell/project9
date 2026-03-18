import java.util.Scanner;

public class Customer extends User {

    private CheckingAccount checking;
    private SavingAccount savings;

    private Scanner input = new Scanner(System.in);

    public Customer() {

        setUserName("Alice");
        setPIN("0000");

        checking = new CheckingAccount();
        savings = new SavingAccount();

    }

    public Customer(String username, String pin) {

        setUserName(username);
        setPIN(pin);

        checking = new CheckingAccount();
        savings = new SavingAccount();

    }

    public static void main(String[] args) {

        Customer c = new Customer();

        if(c.login()) {
            c.start();
        }

    }

    public String menu() {

        return "\nCustomer Menu\n\n"
        + "0) Exit\n"
        + "1) Manage Checking Account\n"
        + "2) Manage Savings Account\n"
        + "3) change PIN\n";

    }

    public void start() {

        int choice;

        do {

            System.out.println(menu());
            System.out.print("Action (0-3): ");
            choice = input.nextInt();
            input.nextLine();

            switch(choice) {

                case 1:
                    System.out.println("Checking Account");
                    checking.start();
                    break;

                case 2:
                    System.out.println("Savings Account");
                    savings.start();
                    break;

                case 3:
                    changePin();
                    break;

            }

        } while(choice != 0);

    }

    public void changePin() {

        System.out.print("Enter new PIN: ");
        String newPin = input.nextLine();
        setPIN(newPin);

        System.out.println("PIN updated.");

    }

    public String getReport() {

        return "Customer: " + getUserName()
        + "\nChecking Balance: " + checking.getBalanceString()
        + "\nSavings Balance: " + savings.getBalanceString();

    }

}
