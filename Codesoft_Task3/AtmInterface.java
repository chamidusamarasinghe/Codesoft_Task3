import java.util.Scanner;

class Atm
{
    private BankAccount bankaccount;
    Scanner sc = new Scanner(System.in);

    public Atm(BankAccount bankAccount)
    {
        this.bankaccount = bankAccount;
    }
    void menu()
    {
        char again;
        do
        {
            System.out.println("Hi !! Welcome to the ATM");
            System.out.println("1.Check Balance.");
            System.out.println("2.Withdrow");
            System.out.println("3.Deposit");
            System.out.println("4.Exit.");
            System.out.println("Select number from the menu :");

            int choice =sc.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.println("Your Current Balance : $"+bankaccount.getBalance());
                    break;
                case 2:
                    System.out.println("Enter withdraw amount : $");
                    double withdrawAmount =sc.nextDouble();
                    bankaccount.withdraw(withdrawAmount);
                    break;    
                case 3:
                    System.out.println("Enter deposit amount : $");
                    double depositAmount = sc.nextDouble();
                    bankaccount.deposit(depositAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice!!! plese enter correct choice");
                    break;
            }
            System.out.println("Do you want to run program again:");
            again =sc.next().charAt(0);
        }
        while (again == 'y' || again == 'Y') ;
        {
            System.out.println("Thank you for using Atm");
        }
    }

}
class BankAccount
{
    private double balance;
    public BankAccount(double intialBalance)
    {
        this.balance =intialBalance;
    }

    public double getBalance()
    {
        return balance;
    }

    public double withdraw(double withdrawAmount)
    {
        if(withdrawAmount > 0 && withdrawAmount <= balance)
        {
            balance -= withdrawAmount;
            System.out.println("Withdraw Complete.");
            System.out.println(("new balace : $"+balance));
        }
        else if(withdrawAmount > balance)
        {
            System.out.println("Insufficient balance. Withdrawal failed.");
        }
        else
        {
            System.out.println("Invalid amount. Please enter a positive amount.");
        }
        return 0;
    }

    public double deposit(double depositAmount)
    {
        if(depositAmount > 0)
        {
            balance += depositAmount;
            System.out.println(("Deposit complete. new balance : $"+balance));
        }
        else
        {
            System.out.println("Invalid amount. Please enter a positive amount.");
        }
        return 0;
    }
}
public class AtmInterface 
{
    public static void main(String[] args) 
    {
        BankAccount bankaccount = new BankAccount(1000.00);
        Atm atm = new Atm(bankaccount);

        atm.menu();

    }

}
