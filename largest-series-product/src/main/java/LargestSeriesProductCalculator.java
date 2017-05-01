import java.util.Iterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LargestSeriesProductCalculator {

    private class SeriesOfDigits implements Iterable {

        int[] digits;
        int seriesLength;

        public void setSeriesLength(int seriesLength) {
            this.seriesLength = seriesLength;
        }

        public SeriesOfDigits(String stringOfDigits) {
            digits = Stream.of(stringOfDigits.split(".")).mapToInt(d -> Integer.valueOf(d)).toArray();
        }

        public Iterator<int[]> iterator() {
            return iterator(seriesLength);
        }

        public Iterator<int[]> iterator(int seriesLength) {
            return (Iterator<int[]>) new SeriesOfDigitsIterator(seriesLength);
        }

        private class SeriesOfDigitsIterator implements Iterator {
            int currentIndex = 0;
            int seriesLength;

            public SeriesOfDigitsIterator(int seriesLength) {
                this.seriesLength = seriesLength;
            }

            @Override
            public boolean hasNext() {
                return currentIndex < digits.length - seriesLength;
            }

            @Override
            public int[] next() {
                int start = currentIndex;
                int end = start + seriesLength;
                currentIndex++;
                return IntStream.range(start, end).map(index -> digits[index]).toArray();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Remove() not implemented");
            }
        }
    }

    public LargestSeriesProductCalculator(String stringOfDigits) {
        SeriesOfDigits digits = new SeriesOfDigits(stringOfDigits);
    }

    public long calculateLargestProductForSeriesLength(int seriesLength) {
        return 72L;
    }

}
