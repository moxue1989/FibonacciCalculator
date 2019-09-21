package validation;

import org.junit.Before;
import org.junit.Test;
import validation.UserInputValidator;
import validation.ValidationResult;

import static org.junit.Assert.assertEquals;

public class UserInputValidatorTest {

    private static final int MAX_FIB_NUMBER = 100;
    private UserInputValidator validator;

    @Before
    public void setUp() {
        validator = new UserInputValidator(MAX_FIB_NUMBER);
    }

    @Test
    public void validateInput_withNullInput_returnsInvalidResult() {
        ValidationResult expected = ValidationResult.invalidResult(null + " is not a valid integer!");
        ValidationResult validationResult = validator.validateInput(null);

        assertEquals(expected, validationResult);
    }

    @Test
    public void validateInput_withStringInput_returnsInvalidResult() {
        String input = "not a number";

        ValidationResult expected = ValidationResult.invalidResult(input + " is not a valid integer!");
        ValidationResult validationResult = validator.validateInput(input);

        assertEquals(expected, validationResult);
    }

    @Test
    public void validateInput_withNegativeInput_returnsInvalidResult() {
        String input = "-10";

        ValidationResult expected = ValidationResult.invalidResult("Invalid Number: " + input);
        ValidationResult validationResult = validator.validateInput(input);

        assertEquals(expected, validationResult);
    }

    @Test
    public void validateInput_withOutOfRangeInput_returnsInvalidResult() {
        String input = MAX_FIB_NUMBER + 1 + "";

        ValidationResult expected = ValidationResult.invalidResult("Invalid Number: " + input);
        ValidationResult validationResult = validator.validateInput(input);

        assertEquals(expected, validationResult);
    }

    @Test
    public void validateInput_withDecimalInput_returnsInvalidResult() {
        String input = 50.2 + "";

        ValidationResult expected = ValidationResult.invalidResult(input + " is not a valid integer!");
        ValidationResult validationResult = validator.validateInput(input);

        assertEquals(expected, validationResult);
    }


    @Test
    public void validateInput_withMaxInput_returnsValidResult() {
        String input = MAX_FIB_NUMBER + "";

        ValidationResult expected = ValidationResult.validResult();
        ValidationResult validationResult = validator.validateInput(input);

        assertEquals(expected, validationResult);
    }

    @Test
    public void validateInput_withZeroInput_returnsValidResult() {
        String input = 0 + "";

        ValidationResult expected = ValidationResult.validResult();
        ValidationResult validationResult = validator.validateInput(input);

        assertEquals(expected, validationResult);
    }

    @Test
    public void validateInput_withValidInput_returnsValidResult() {
        String input = 50 + "";

        ValidationResult expected = ValidationResult.validResult();
        ValidationResult validationResult = validator.validateInput(input);

        assertEquals(expected, validationResult);
    }
}