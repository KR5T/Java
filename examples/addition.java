package examples;
import java.util.Scanner;
class addition {
    public static void main(String[] arg){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the num1: ");
        int num1 = input.nextInt();

        System.out.print("Enter the num2: ");
        int num2 = input.nextInt();  

        int sum = num1 + num2;

        System.out.printf("sum: %d%n",sum);
    }
}
