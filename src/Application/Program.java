package Application;

import java.util.Locale;
import java.util.Scanner;

import Model.Entities.Account;
import Model.Exceptions.DomainException;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc =  new Scanner(System.in);
        try {
            System.out.println("Enter account data");
            System.out.print("Number: ");
            int number =  sc.nextInt();

            sc.nextLine();    
            System.out.print("Holder: ");
            String holder =  sc.nextLine();

            System.out.print("Initial balance: ");
            Double amount =  sc.nextDouble();

            System.out.print("Withdraw limit: ");
            Double whithDrawLimit = sc.nextDouble();

            Account account = new Account(number, holder, whithDrawLimit);
            account.deposit(amount);

            System.out.print("Enter amount for withdraw: ");
            account.whithDraw(sc.nextDouble());

            System.out.println("New balance: " + String.format("%.2f", account.getBalance()));
        } catch (DomainException e) {
            System.out.println("Withdraw error: " + e.getMessage());
        }finally {
            sc.close();
        }
        
       
    }
    
}
