import java.util.stream.IntStream;

public class Hamming {
    private Hamming() {
    }

    public static int compute(String dna1, String dna2) throws IllegalArgumentException {
        if (dna1.length() != dna2.length()) {
            throw new IllegalArgumentException();
        }
        
        return ((Long) IntStream.range(0, dna1.length())
                .filter(index -> dna1.charAt(index) != dna2.charAt(index))
                .count())
            .intValue();
    }
}
