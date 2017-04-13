

public class PhoneNumber {

    private final static String wrongLengthExceptionMessage = "Number must be 10 or 11 digits";
    private final static String numberIs11DigitsButDoesNotStartWith1ExceptionMessage =
            "Can only have 11 digits if number starts with '1'";
    private final static String illegalCharacterExceptionMessage =
            "Illegal character in phone number. Only digits, spaces, parentheses, hyphens or dots accepted.";

    private String number;

    public PhoneNumber(String input) throws IllegalArgumentException {

        if (!input.matches("[\\d\\.\\s-()]+")) {
            throw new IllegalArgumentException(illegalCharacterExceptionMessage);
        }


        String testNumber = cleanNumber(input);
        
        if (testNumber.length() > 11 || testNumber.length() < 10) {
            throw new IllegalArgumentException(wrongLengthExceptionMessage);
        }

        if (testNumber.length() == 11 && !testNumber.startsWith("1")) {
            throw new IllegalArgumentException(numberIs11DigitsButDoesNotStartWith1ExceptionMessage);
        }

        number = testNumber.substring(testNumber.length() - 10);
    }

    public String getNumber() {
        return number;
    }

    private String cleanNumber(String input) {
        return input.replaceAll("\\D", "");
    }
}