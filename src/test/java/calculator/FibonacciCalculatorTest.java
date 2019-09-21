package calculator;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import validation.UserInputValidator;
import validation.ValidationResult;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class FibonacciCalculatorTest {
    @Mock
    private UserInputValidator userInputValidator;
    @Mock
    private Calculator calculator;
    private FibonacciCalculator fibonacciCalculator;
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void setUp() {
        fibonacciCalculator = new FibonacciCalculator(userInputValidator, this.calculator);
    }

    @Test
    public void process_withInvalidResult_returnsErrorMessage() {
        String errorMessage = "Error";
        String invalidInput = "Invalid Input";

        when(userInputValidator.validateInput(invalidInput)).thenReturn(ValidationResult.invalidResult(errorMessage));
        List<String> expected = new ArrayList<>();

        expected.add(errorMessage);

        List<String> actual = fibonacciCalculator.process(invalidInput);
        assertEquals(expected, actual);
    }

    @Test
    public void process_withCalculatorOutput_returnsCorrectMessages() {
        int validInput = 2;
        String validInputString = validInput + "";

        when(userInputValidator.validateInput(validInputString)).thenReturn(ValidationResult.validResult());

        ArrayList<BigInteger> calculatorResults = new ArrayList<>();
        calculatorResults.add(BigInteger.ZERO);
        calculatorResults.add(BigInteger.ONE);

        when(calculator.getResults(validInput)).thenReturn(calculatorResults);

        List<String> expected = new ArrayList<>();

        expected.add(BigInteger.ZERO + "");
        expected.add(BigInteger.ONE + "");

        List<String> actual = fibonacciCalculator.process(validInputString);
        assertEquals(expected, actual);
    }

    @Test
    public void process_withNoResult_returnsEmptyListOfMessages() {
        int input = 0;
        String validInputString = input + "";

        when(userInputValidator.validateInput(validInputString)).thenReturn(ValidationResult.validResult());

        ArrayList<BigInteger> calculatorResults = new ArrayList<>();

        when(calculator.getResults(input)).thenReturn(calculatorResults);

        List<String> expected = new ArrayList<>();

        List<String> actual = fibonacciCalculator.process(validInputString);
        assertEquals(expected, actual);
    }
}