import java.util.function.Function;

public class LuhnValidator {

    private boolean shouldDouble;

    public LuhnValidator() {
    }

    public boolean isValid(String input) {
        StringBuffer number = clean(input);
        return hasOnlyDigits(number) && hasEnoughDigits(number) && isLuhnCalculationValid(number);
    }

    private StringBuffer clean(String input) {
        return new StringBuffer(input.replace(" ", ""));
    }

    private boolean hasOnlyDigits(StringBuffer input) {
        return input.toString().matches("\\d+");
    }

    private boolean hasEnoughDigits(StringBuffer input) {
        return input.length() > 1;
    }

    /**
     * Sum of the digits (after doubling every second digit and reducing it by 9 if greater than 9
     * going right to left) should be cleanly divisible by 10.
     * 
     * @param   input - the reversed number after cleaning out whitespaces. Only digits are permitted.
     * 
     * @return  true if the input is a valid number based on the Luhn algorithm.
     */
    private boolean isLuhnCalculationValid(StringBuffer input) {
        return luhnSum(input) % 10 == 0;
    }

    /**
     * 
     * The first step of the Luhn algorithm is to double every second digit
     * starting from the last digit. The input is reversed to go through it
     * forwards. The alternative is to use a spiterator to go through the number.
     * from right to left. These values are then summed.
     * <p>
     * The field "shouldDouble" is a flag used when calculating the transform value.
     * It is set to false for the first number as that should just return itself.
     * 
     * @param   StringBuffer - original value to be transformed
     * 
     * @return  the sum of the transformed digits.
     */
    private long luhnSum(StringBuffer input) {
        shouldDouble = false;
        return input.reverse().toString().codePoints().map(c -> Integer.valueOf(String.valueOf((char) c)))
                .map(i -> luhnValue(i)).sum();
    }

    /**
     * This method will return the same value given it if shouldDouble is false,
     * or it will double the value and then subtract 9 if it is greater than 9.
     * <p>
     * Side effect is to negate the field shouldDouble so it does the other side
     * of the transaction for the next number.
     * 
     * @param   int - original value to be transformed
     * 
     * @return      transformed value
     */
    private int luhnValue(int i) {
        Integer retVal = shouldDouble ? luhnFormula.apply(i) : i;
        shouldDouble = !shouldDouble;
        return retVal;
    }

    private Function<Integer, Integer> luhnFormula = i -> i * 2 - (i / 5) * 9;
}