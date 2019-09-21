package calculator;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class CachingCalculator implements Calculator {
    private List<BigInteger> resultCache = initializeResultCache();

    public List<BigInteger> getResults(int fibNumbers) {
        // Return existing result cache if previously calculated, otherwise expand result cache to requested number
        if (fibNumbers > resultCache.size()) {
            expandResultsCache(fibNumbers);
        }
        return resultCache.subList(0, fibNumbers);
    }

    private void expandResultsCache(int fibNumbers) {
        int currentSize = resultCache.size();
        while (fibNumbers > currentSize) {
            BigInteger nextValue = resultCache.get(currentSize - 1).add(resultCache.get(currentSize - 2));
            resultCache.add(nextValue);
            currentSize++;
        }
    }

    private List<BigInteger> initializeResultCache() {
        // initialize cache with initial value
        ArrayList<BigInteger> results = new ArrayList<>();
        results.add(BigInteger.valueOf(0));
        results.add(BigInteger.valueOf(1));
        return results;
    }
}
