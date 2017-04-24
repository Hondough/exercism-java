
public class LuhnValidator {
    public LuhnValidator() {

    }

    public boolean isValid(String input) {
        StringBuffer number = cleanAndReverse(input);
        return hasOnlyDigits(number) && hasEnoughDigits(number);
    }

    private StringBuffer cleanAndReverse(String input) {
        return (new StringBuffer(input.replace(" ", ""))).reverse();
    }

    private boolean hasOnlyDigits(StringBuffer input) {
        return input.toString().matches("\\d+");
    }

    private boolean hasEnoughDigits(StringBuffer input) {
        return input.length() > 1;
    }
}