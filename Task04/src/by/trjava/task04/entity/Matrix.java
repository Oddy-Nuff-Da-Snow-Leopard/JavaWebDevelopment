package by.trjava.task04.entity;

public class Matrix {

    private int[][] matrix;

    private final int size;

    public Matrix(int[][] matrix) {
        this.matrix = matrix;
        size = matrix.length;
    }

    public int[][] getMatrix() {
        int[][] newMatrix = new int[size][];
        for (int i = 0; i < size; i++) {
            newMatrix[i] = new int[matrix[i].length];
            System.arraycopy(matrix[i], 0, newMatrix[i], 0, matrix[i].length);
        }
        return newMatrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Matrix anotherMatrix = (Matrix) obj;

        if (size != anotherMatrix.size) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (matrix[i].length != anotherMatrix.matrix[i].length) {
                return false;
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != anotherMatrix.matrix[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 1;
        for (int i = 0; i < size; i++) {
            int elementHash = 1;
            for (int element : matrix[i]) {
                elementHash = 31 * elementHash + element;
            }
            hash = 31 * hash + elementHash;
        }
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                str.append(matrix[i][j]).append(" ");
            }
            str.append("\n");
        }
        return str.toString();
    }
}
