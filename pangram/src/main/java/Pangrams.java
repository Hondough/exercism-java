import java.util.List;
import java.util.stream.IntStream;



public class Pangrams {

    public static boolean isPangram(String suspect) {
        return 26 == suspect
            .chars()
            .map(c -> Character.toLowerCase(c))
            .filter(c -> c >= 'a' && c <= 'z')
            .distinct()
            .count();
    }
}