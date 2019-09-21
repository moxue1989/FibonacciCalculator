package validation;

public class UserInputValidator {
    private final int maxFibNumber;

    public UserInputValidator(int maxFibNumber) {
        this.maxFibNumber = maxFibNumber;
    }

    public ValidationResult validateInput(String userInput) {
        try {
            int fibNumber = Integer.parseInt(userInput);
            if (fibNumber < 0 || fibNumber > maxFibNumber) {
                return ValidationResult.invalidResult("Invalid Number: " + fibNumber);
            }
        } catch (NumberFormatException e) {
            return ValidationResult.invalidResult(userInput + " is not a valid integer!");
        }
        return ValidationResult.validResult();
    }
}
