import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RaindropConverter {
    private Map<Integer, String> raindropSounds = new HashMap<>();
    {
        raindropSounds.put(3, "Pling");
        raindropSounds.put(5, "Plang");
        raindropSounds.put(7, "Plong");
    }

    public String convert(int number) {

        String sound = raindropSounds.entrySet().stream()
                .map(e -> createSound(number, e.getKey(), e.getValue()))
                .collect(Collectors.joining());
                
        return sound.isEmpty() ? Integer.toString(number) : sound;
    }

    private String createSound(int number, int divisor, String sound) {
        return number % divisor == 0 ? sound : "";
    }
}