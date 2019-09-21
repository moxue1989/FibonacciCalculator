package calculator;

import validation.UserInputValidator;
import validation.ValidationResult;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FibonacciCalculator {

    private final UserInputValidator userInputValidator;
    private final Calculator calculator;

    public FibonacciCalculator(UserInputValidator userInputValidator, Calculator calculator) {
        this.userInputValidator = userInputValidator;
        this.calculator = calculator;
    }

    public List<String> process(String input) {
        ArrayList<String> output = new ArrayList<>();
        ValidationResult validationResult = userInputValidator.validateInput(input);
        if (!validationResult.isValid()) {
            output.add(validationResult.getMessage());
        } else {
            int fibNumber = Integer.parseInt(input);

            List<String> results = calculator.getResults(fibNumber)
                    .stream()
                    .map(BigInteger::toString)
                    .collect(Collectors.toList());

            output.addAll(results);
        }

        return output;
    }
}
