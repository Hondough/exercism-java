import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * I used forEach to implement the algorithm as described. This bad
 * form because I'm mutating a field variable while iterating through it.
 *
 * I decided to use a boolean false to represent a marked number, and
 * true represents an unmarked number. 
 * 
 * The Sieve of Eratosthenes is a simple, ancient algorithm for finding all
 * prime numbers up to any given limit. It does so by iteratively marking as
 * composite (i.e. not prime) the multiples of each prime,
 * starting with the multiples of 2.
 */
public class Sieve {

    private Map<Integer, Boolean> markableNumbers;
    private int n;

    public List<Integer> getPrimes() {
        return markableNumbers.entrySet().stream().filter(e -> e.getValue()).map(e -> e.getKey())
                .collect(Collectors.toList());
    }

    public Sieve(int n) {
        this.n = n;
        /* Create your range, starting at two and continuing
         * up to and including the given limit. (i.e. [2, limit])
        */
        initMarkableNumbers();
        /* - take the next available unmarked number in your list (it is prime)
         * - mark all the multiples of that number (they are not prime)
        */
        IntStream.rangeClosed(2, n)
            .filter(markableNumbers::get)
            .forEach(this::markMarkableNumbers);
    }

    private void initMarkableNumbers() {
        // true means "unmarked"
        markableNumbers = IntStream.rangeClosed(2, n)
            .collect(HashMap::new, (m, i) -> m.put(i, true), HashMap::putAll);
    }

    private void markMarkableNumbers(int i) {
        // false means "marked"
        IntStream.iterate(i * 2, j -> j + i)
            .limit((n - i) / i)
            .forEach(j -> markableNumbers.put(j, false));
    }
}