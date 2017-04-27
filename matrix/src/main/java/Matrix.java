public class Matrix {

    private int[][] matrix;

    public Matrix(String matrixIn) {
        matrix = new int[1][1];
    }

    public int[] getRow(int row) {
        return matrix[0];
    }

    public int getRowsCount() {
        return matrix[0].length;
    }

    public int[] getColumn(int col) {
        return matrix[0];
    }

    public int getColumnsCount() {
        return matrix[0].length;
    }

}