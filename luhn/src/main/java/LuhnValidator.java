

public class LuhnValidator {
    public LuhnValidator () {

    }

    public boolean isValid(String input) {
        String number = input.replace(" ", "");
        return number.length() > 1;
    }
}