import java.util.HashMap;
import java.util.Map;

public class RnaTranscription {

    public static String ofDna(String dna) {

        Map<Character, Character> dnaToRna = getDnaToRna();
        return (dna.codePoints()
            .map(d -> dnaToRna.get((char) d))
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append))
                .toString();
    }

    private static Map<Character, Character> getDnaToRna() {
        Map<Character, Character> dnaToRna = new HashMap<>(6);
        dnaToRna.put('G', 'C');
        dnaToRna.put('C', 'G');
        dnaToRna.put('A', 'U');
        dnaToRna.put('T', 'A');
        return dnaToRna;
    }
}