import calculator.CachingCalculator;
import calculator.Calculator;
import calculator.FibonacciCalculator;
import validation.UserInputValidator;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static int MAX_NUMBER = 10000;

    public static void main(String[] args) {

        Calculator calculator = new CachingCalculator();
        UserInputValidator userInputValidator = new UserInputValidator(MAX_NUMBER);
        FibonacciCalculator fibonacciCalculator = new FibonacciCalculator(userInputValidator, calculator);

        System.out.println("Welcome to the Fibonacci Sequence Calculator! ");
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Please enter a integer between 0 and " + MAX_NUMBER + ". Type exit to quit.");
            String input = in.nextLine();
            if(input.equals("exit")){
                System.out.println("Goodbye!");
                break;
            }
            Instant startTime = Instant.now();
            List<String> output = fibonacciCalculator.process(input);
            Instant endTime = Instant.now();

            output.forEach(System.out::println);
            Duration duration = Duration.between(startTime, endTime);
            System.out.println("Completed in : " + duration.abs().toMillis() + " ms");

            System.out.println();
        }
    }
}
