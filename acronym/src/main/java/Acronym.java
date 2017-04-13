import java.util.stream.Collectors;
import java.util.stream.Stream;



public class Acronym {
    public static String generate(String phrase) {
        // return (phrase.replaceAll("(\\b\\w)|((?>=[a-z])|([A-Z]))", "$2")).toUpperCase();
        String test = phrase.replaceAll("(\\b\\w)|()", "$1");
        return test;
        // return (phrase.replaceAll("(\\b\\w)", "$1")).toUpperCase();
    }
}