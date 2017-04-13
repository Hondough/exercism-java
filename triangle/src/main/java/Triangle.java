import java.util.DoubleSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Triangle{

    private double shortest, middle, longest;

    public Triangle (double s1, double s2, double s3)  throws TriangleException{
        double[] sides = DoubleStream.of(s1, s2, s3).sorted().toArray();
        shortest = sides[0];
        middle = sides[1];
        longest = sides[2];

        if (shortest + middle == longest) {
            System.out.println("degenerate!");
        }

        if (longest <= 0.0 || shortest < 0.0 || (shortest + middle <= longest)) {
            throw new TriangleException();
        }
    }

    public TriangleKind getKind() {
        if (shortest == longest) {
            return TriangleKind.EQUILATERAL;
        }

        if (shortest == middle || middle == longest) {
            return TriangleKind.ISOSCELES;
        }

        return TriangleKind.SCALENE;
    }
}