//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        Scanner in = new Scanner(System.in);
        String userInput;
        System.out.println("Welcome to Prime number!");
        System.out.println("Please enter a number (Q to exit): ");
        boolean primeNumber;
        int number;
        do{
            userInput = in.next();
            if(!userInput.equals("q")){
                number = Integer.parseInt(userInput);
                primeNumber = new Main().isPrime(number);
                String response = primeNumber ? "Yes, this: "+number+" is prime number" : "No ,this: "+number+" is not a prime number";
                System.out.println(response);
            }
            System.out.println("Enter another number(Q to exit): ");
        } while (!userInput.equalsIgnoreCase("q"));
        System.out.println("Thank you");
    }

    public boolean isPrime(int n) {
        //check if n is a multiple of 2
        if (n%2==0) return false;
        //if not, then just check the odds
        for(int i=3;i*i<=n;i+=2) {
            if(n%i==0)
                return false;
        }
        return true;
    }
}