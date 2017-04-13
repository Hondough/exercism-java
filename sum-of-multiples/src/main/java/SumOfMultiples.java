import java.util.stream.IntStream;

public class SumOfMultiples {

    private SumOfMultiples() {

    }

    public static int sum(int limit, int[] multiples) {
        return IntStream.of(multiples)
                .flatMap(i -> getMultipleStream(limit, i))
                .distinct()
                .sum();
    }

    private static IntStream getMultipleStream (int limit, int multiple) {
        return IntStream.rangeClosed(1, (limit - 1) / multiple).map(i -> i * multiple);

    }
}

