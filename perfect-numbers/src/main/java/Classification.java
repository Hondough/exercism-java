import java.util.stream.IntStream;

enum Classification {

    DEFICIENT, PERFECT, ABUNDANT;

    public static Classification createClassification(int n) {

        int aliquotSum = IntStream.range(1, n)
            .parallel()
            .filter(i -> n % i == 0)
            .sum();

        return aliquotSum == n ? PERFECT : aliquotSum < n ? DEFICIENT : ABUNDANT;
    }

}
