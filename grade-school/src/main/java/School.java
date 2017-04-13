import java.util.Collections;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class School {

    private SortedMap<Integer, SortedSet<String>> school = new TreeMap<>();

    public int numberOfStudents() {
        return school.values().size();
    }

    public void add(String name, int grade) {
        school.computeIfAbsent(grade, g -> new TreeSet<>()).add(name);
    }

    public SortedSet<String> grade(int grade) {
        return Collections.unmodifiableSortedSet(school.getOrDefault(grade, new TreeSet<>()));
    }

    public SortedMap<Integer, SortedSet<String>> studentsByGradeAlphabetical() {
        return Collections.unmodifiableSortedMap(school);
    }
}