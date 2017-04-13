import java.security.KeyStore.CallbackHandlerProtection;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class DNA {

    private String strand;

    private static final List<Character> NUCLEOTIDES = Arrays.asList('A', 'C', 'G', 'T');

    public DNA(String strand) {
        this.strand = strand;
    }

    public int count(char nucleotide) throws IllegalArgumentException {
        if (!isValidNucleotide(nucleotide)) {
            throw new IllegalArgumentException();
        }

        return (int) strand
            .chars()
            .filter(c -> c == nucleotide)
            .count();
    }

    private boolean isValidNucleotide(char nucleotide) {
        return NUCLEOTIDES.contains(nucleotide);
    }

    public Map<Character, Integer> nucleotideCounts() {
        Map<Character, Integer> nucleotideCounts = NUCLEOTIDES
            .parallelStream()
            .collect(Collectors.toConcurrentMap(Function.identity(), this::count));

        return nucleotideCounts;
    }
}
