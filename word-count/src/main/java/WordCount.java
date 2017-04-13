import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class WordCount {

    public Map<String, Long> phrase(String sentence) {

        return Arrays.asList(sentence.split("\\W+"))
            .stream()
            .map(word -> word.toLowerCase())
            //doesn't work because counting returns a long, and we need an Integer
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
    }
}
