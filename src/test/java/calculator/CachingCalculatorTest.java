package calculator;

import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CachingCalculatorTest {

    private CachingCalculator calculator;

    @Before
    public void setUp() {
        calculator = new CachingCalculator();
    }

    @Test
    public void calculate_withZero_returnsEmptyList() {
        assertEquals(new ArrayList<>(), calculator.getResults(0));
    }

    @Test
    public void calculate_withNumbers_returnsCorrectResultList() {
        ArrayList<BigInteger> expected = new ArrayList<>();

        expected.add(BigInteger.valueOf(0));
        expected.add(BigInteger.valueOf(1));
        expected.add(BigInteger.valueOf(1));
        expected.add(BigInteger.valueOf(2));
        expected.add(BigInteger.valueOf(3));
        expected.add(BigInteger.valueOf(5));
        expected.add(BigInteger.valueOf(8));
        expected.add(BigInteger.valueOf(13));

        assertEquals(expected, calculator.getResults(8));
    }

    @Test
    public void calculate_withLargeNumber_returnsCorrectResult() {
        int largeNumber = 1000;

        List<BigInteger> results = calculator.getResults(largeNumber);
        assertEquals(largeNumber, results.size());

        BigInteger expected = new BigInteger("2686381002448535938614672720214292396761660931898" +
                "6952340123175997617981700247881689338369654483356564191827856161443356312976673642" +
                "210350324634850410377680367334151172899169723197082763985615764450078474174626");
        BigInteger lastNumber = results.get(largeNumber - 1);
        assertEquals(expected, lastNumber);
    }
}