import java.util.stream.Collectors;

public class Bob {
    public Bob() {
    }

    public String hey(String input) {
        if (input.trim().isEmpty()) {
            return "Fine. Be that way!";
        } else if (isShouting(input)) {
            return "Whoa, chill out!";
        } else if (isQuestion(input)) {
            return "Sure.";
        } else {
            return "Whatever.";
        }
    }

    private boolean isShouting(String input) {
        String alphaOnly = alphaOnly(input);
        return !alphaOnly.isEmpty() && alphaOnly.equals(alphaOnly.toUpperCase());
    }

    private boolean isQuestion(String input) {
        return input.endsWith("?");
    }

    private String alphaOnly (String input) {
        return (input.codePoints()
                .filter(Character::isAlphabetic)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append))
            .toString();
    }
}