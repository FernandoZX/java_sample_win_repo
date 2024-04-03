//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.Scanner;

import objects.experimentals.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        Scanner in = new Scanner(System.in);
        Main main = new Main();
        main.menuOptions(in);
        System.out.println("Thank you");

    }

    public void menuOptions(Scanner in) throws InterruptedException {
        String userInput;
        do {
            System.out.println("1. Prime number:");
            System.out.println("2. Stack:");
            System.out.println("Please enter a option (Q to exit): ");
            userInput = in.next();
            if (!userInput.equals("q")) {
                if (validNumericInput(userInput)) {
                    int option = Integer.parseInt(userInput);
                    switch (option) {
                        case 1:
                            primeNumberOption(userInput, in);
                        case 2:
                            stackOption(userInput, in);
                        default:
                            System.out.println("wrong option!");
                    }
                }
            }

        } while (!userInput.equalsIgnoreCase("q"));
    }

    public void stackOption(String userInput, Scanner in) throws InterruptedException {
        System.out.println("Welcome to Stack!");
        StackArr stack = new StackArr(0);
        do {
            System.out.println("1. Define stack size:");
            System.out.println("2. Check size stack:");
            System.out.println("3. Push Element:");
            System.out.println("4. Pop Element:");
            System.out.println("Please enter a option (Q to exit): ");
            userInput = in.next();

            if (!userInput.equals("q")) {
                if (validNumericInput(userInput)) {
                    int option = Integer.parseInt(userInput);
                    switch (option) {
                        case 1:
                            if (stack.size() == 0) {
                                System.out.println("Please enter a number to define a size : ");
                                int size = 0;

                                userInput = in.next();
                                if (validNumericInput(userInput)) {
                                    size = Integer.parseInt(userInput);
                                    stack = new StackArr(size);
                                }
                                System.out.println("starting size " + stack.size());
                            } else {
                                System.out.println("Stack size defined is:" + stack.size());
                            }
                        case 2:
                            System.out.println("stack current size " + stack.size());
                        case 3:
                            pushElement(stack, userInput, in);
                        case 4:
                            int result = stack.pop();
                            System.out.println("stack element was popped " + result);
                        default:
                            System.out.println("wrong option!");
                    }
                }
            }
        } while (!userInput.equalsIgnoreCase("q"));
        System.out.println("Thank you using Stack option");
    }

    public void pushElement(StackArr stack, String userInput, Scanner in) throws InterruptedException {
        System.out.println("Please enter a number to push in the stack: ");
        int element;
        userInput = in.next();
        if (validNumericInput(userInput)) {
            element = Integer.parseInt(userInput);
            stack.push(element);
        }
    }


    public void primeNumberOption(String userInput, Scanner in) {
        System.out.println("Welcome to Prime number!");
        System.out.println("Please enter a number (Q to exit): ");
        boolean primeNumber;
        int number;
        do {
            userInput = in.next();
            if (!userInput.equals("q")) {
                if (validNumericInput(userInput)) {
                    number = Integer.parseInt(userInput);
                    primeNumber = isPrime(number);
                    String response = primeNumber ? "Yes, this: " + number + " is prime number" : "No ,this: " + number + " is not a prime number";
                    System.out.println(response);
                }
            }
            System.out.println("Enter another number(Q to exit): ");
        } while (!userInput.equalsIgnoreCase("q"));
        System.out.println("Thank you using prime number option");
    }

    public boolean isPrime(int n) {
        //check if n is a multiple of 2
        if (n % 2 == 0) return false;
        //if not, then just check the odds
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public boolean validNumericInput(String userInput) {
        try {
            int number = Integer.parseInt(userInput);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Input String cannot be parsed to Integer.");
        }
        return false;
    }
}