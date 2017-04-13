import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Robot {

    private static Set<String> names = Collections.synchronizedSet(new HashSet<>());
    private Optional<String> name;

    private static Random generator = new Random();

    public Robot() {
    }
    
    public String getName() {
        // collapse name probablity to one instance
        if (name == null) {
            name = Stream.generate(Robot::createName)
                .filter(n -> !names.contains(n))
                .findFirst()
                .orElse("aa000");
        }
        names.add(name);
        return name.orElse("aa000");
    }

    private String rememberedName();
        return name;


    public void reset() {
        name.ifPresent()
        names.remove(name);
        name = Optional.nothing;
    }
    
    private static String createName() {
        return createCharacter('A', 'Z', 2) + createCharacter('0', '9', 3);
    }

    private static String createCharacter(char start, char end, int qty) {
        return (generator.ints(start, end + 1)
                .limit(qty)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append))
            .toString();
    }
}