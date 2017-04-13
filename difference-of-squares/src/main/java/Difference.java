import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;

public final class Difference {

    private Difference() {
        // prevent instantiation
    }

    public static int betweenSquareOfSumAndSumOfSquaresTo(int n) {
        return computeSquareOfSumTo(n) - computeSumOfSquaresTo(n);
    }

    // public static int computeSquareOfSumTo(int n) {
    //     // return (int) Math.pow(n * (n + 1) / 2, 2);
    //     return (int) Math.pow(computeSumOfSomeIterator(n, i -> i + 1), 2);
    // }
	public static int computeSquareOfSumTo(int i) {
		IntStream a = IntStream.range(1, i+1);
		return (int) Math.pow(a.sum(), 2);
	}
    public static int computeSumOfSquaresTo(int n) {
        // return (int) (2 * Math.pow(n, 3) + 3 * Math.pow(n, 2) + n) / 6;
        return computeSumOfSomeIterator(n, i -> (int) Math.pow(Math.sqrt(i) + 1, 2));
    }

    private static int computeSumOfSomeIterator(int n, IntUnaryOperator f) {
        return (int) IntStream.iterate(1, f).limit(n).sum();
    }
}
