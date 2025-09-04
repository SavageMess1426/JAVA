import java.util.Scanner;

public class SimpleCalculator {
    
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        boolean keepCalculating = true;
        
        System.out.println("Welcome to your friendly calculator!");
        System.out.println("I can help you with basic math operations.");
        
        while (keepCalculating) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Addition (+)");
            System.out.println("2. Subtraction (-)");
            System.out.println("3. Multiplication (*)");
            System.out.println("4. Division (/)");
            System.out.println("5. Exit calculator");
            
            System.out.print("Please choose an option (1-5): ");
            int choice = userInput.nextInt();
            
            if (choice == 5) {
                System.out.println("Thanks for using the calculator! Have a great day!");
                keepCalculating = false;
                continue;
            }
            
            if (choice < 1 || choice > 5) {
                System.out.println("Hmm, that's not a valid option. Please try again!");
                continue;
            }
            
            System.out.print("Enter your first number: ");
            double firstNumber = userInput.nextDouble();
            
            System.out.print("Enter your second number: ");
            double secondNumber = userInput.nextDouble();
            
            double result = performCalculation(choice, firstNumber, secondNumber);
            
            if (Double.isNaN(result)) {
                System.out.println("Oops! Something went wrong with that calculation.");
            } else {
                displayResult(choice, firstNumber, secondNumber, result);
            }
            
            System.out.print("\nWould you like to do another calculation? (yes/no): ");
            String continueChoice = userInput.next();
            if (!continueChoice.toLowerCase().startsWith("y")) {
                System.out.println("Thanks for using the calculator! See you next time!");
                keepCalculating = false;
            }
        }
        
        userInput.close();
    }
    
    public static double performCalculation(int operation, double num1, double num2) {
        switch (operation) {
            case 1:
                return num1 + num2;
            case 2:
                return num1 - num2;
            case 3:
                return num1 * num2;
            case 4:
                if (num2 == 0) {
                    System.out.println("I can't divide by zero - that's mathematically impossible!");
                    return Double.NaN;
                }
                return num1 / num2;
            default:
                return Double.NaN;
        }
    }
    
    public static void displayResult(int operation, double num1, double num2, double result) {
        String operationSymbol = getOperationSymbol(operation);
        
        if (result == (int) result) {
            System.out.printf("%.0f %s %.0f = %.0f%n", num1, operationSymbol, num2, result);
        } else {
            System.out.printf("%.2f %s %.2f = %.2f%n", num1, operationSymbol, num2, result);
        }
        
        if (result > 100) {
            System.out.println("Wow, that's a big number!");
        } else if (result < 0) {
            System.out.println("We got a negative result there!");
        } else if (result == 0) {
            System.out.println("Perfect zero - nice and clean!");
        }
    }
    
    public static String getOperationSymbol(int operation) {
        switch (operation) {
            case 1: return "+";
            case 2: return "-";
            case 3: return "×";
            case 4: return "÷";
            default: return "?";
        }
    }
}
