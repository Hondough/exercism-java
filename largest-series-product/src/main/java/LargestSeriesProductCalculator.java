import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LargestSeriesProductCalculator {

    private int[] digits;

    public LargestSeriesProductCalculator(String stringOfDigits) {

        validateStringOfDigits(stringOfDigits);
        digits = stringOfDigits.chars().map(Character::getNumericValue).toArray();
    }

    public long calculateLargestProductForSeriesLength(int seriesLength) {

        validateSeriesLength(seriesLength);
        return IntStream.rangeClosed(0, digits.length - seriesLength)
                .mapToLong(start -> IntStream.range(start, start + seriesLength).mapToLong(index -> digits[index])
                        .reduce(1L, (left, right) -> left * right))
                .max().orElse(0);
    }

    private void validateStringOfDigits(String stringOfDigits) {
        if (stringOfDigits == null) {
            throw new IllegalArgumentException("String to search must be non-null.");
        }
        if (!stringOfDigits.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("String to search may only contains digits.");
        }
    }

    private void validateSeriesLength(int seriesLength) {
        if (seriesLength < 0) {
            throw new IllegalArgumentException("Series length must be non-negative.");
        }
        if (seriesLength > digits.length) {
            throw new IllegalArgumentException(
                    "Series length must be less than or equal to the length of the string to search.");
        }
    }

}
