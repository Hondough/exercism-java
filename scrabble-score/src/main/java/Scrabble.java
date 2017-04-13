import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Scrabble {

    private static final Map<Character, Integer> LETTER_SCORES = new HashMap<Character, Integer>() {
        {
            put('a', 1);
            put('b', 3);
            put('c', 3);
            put('d', 2);
            put('e', 1);
            put('f', 4);
            put('g', 2);
            put('h', 4);
            put('i', 1);
            put('j', 8);
            put('k', 5);
            put('l', 1);
            put('m', 3);
            put('n', 1);
            put('o', 1);
            put('p', 3);
            put('q', 10);
            put('r', 1);
            put('s', 1);
            put('t', 1);
            put('u', 1);
            put('v', 4);
            put('w', 4);
            put('x', 8);
            put('y', 4);
            put('z', 10);
        }
    };

    private int score;

    public int getScore() {
        return score;
    }

    public Scrabble(String word) {
        score = word == null ? 0 : score(word);
    }

    private int score(String word) {
        return (int) word.chars()
                .map(Scrabble::pointValue)
                .sum();
    }

    private static int pointValue(int letter) {
        return LETTER_SCORES.getOrDefault(Character.toLowerCase((char) letter), 0);
    }
}