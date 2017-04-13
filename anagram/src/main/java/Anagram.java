import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Anagram {
    private String text;
    private String sortedText;
    Anagram(String text) {
        this.text = text;
        this.sortedText = getSorted(text);
    }

    public List<String> match(List<String> candidates) {
        return candidates
            .stream()
            .filter(candidate -> !candidate.equalsIgnoreCase(text))
            .filter(candidate -> sortedText.equalsIgnoreCase(getSorted(candidate)))
            .collect(Collectors.toList());
    }

    private String getSorted(String text) {
        char[] chars = text.toLowerCase().toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
