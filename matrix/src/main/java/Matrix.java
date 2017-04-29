import java.util.stream.Stream;

public class Matrix {

    private String[] rows;

    public Matrix(String matrix) {
        rows = Stream.of(matrix.split("\n"))
            .toArray(size -> new String[size]);
    }

    public int[] getRow(int row) {
        return Stream.of(rows[row].split(" "))
            .mapToInt(d -> Integer.valueOf(d))
            .toArray();
    }

    public int getRowsCount() {
        return rows.length;
    }

    public int[] getColumn(int col) {
        return new int[1];
    }

    public int getColumnsCount() {
        return getRow(0).length;
    }
}