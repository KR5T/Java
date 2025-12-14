package examples;
import java.util.Scanner;

public class AccountTest {
    public static void main(String[] arg){
        
        
        Account account1 = new Account("Jane Green", 50);
        Account account2 = new Account("John Blue", -7.53);
        
        System.out.printf("Name: %s Balance: %f%n",account1.getName(), account1.getBalance());
        System.out.printf("Name: %s Balance: %f%n", account2.getName(), account2.getBalance());

        Scanner input = new Scanner(System.in);

        System.out.printf("Enter the deposit: ");
        double depositAmount1 = input.nextDouble();
        
        account1.deposit(depositAmount1);
        System.out.printf("%nName: %s Balance: %.2f",account1.getName(), account1.getBalance());
        System.out.printf("%nName: %s Balance: %.2f", account2.getName(), account2.getBalance());
        
        System.out.printf("%nEnter the deposit: ");
        double depositAmount2 = input.nextDouble();
        
        account2.deposit(depositAmount2);
        System.out.printf("%nName: %s Balance: %.2f",account1.getName(), account1.getBalance());
        System.out.printf("%nName: %s Balance: %.2f", account2.getName(), account2.getBalance());
    }
}
