public class MatrixOperations {

    public static void main(String[] args) {
        try {
            executeMatrixOperations();
        } catch (Exception e) {
            System.err.println("Помилка виконання програми: " + e.getMessage());
        }
    }

    public static void executeMatrixOperations() throws Exception {
        short[][] matrixA = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        short[][] matrixB = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};

        System.out.println("Матриця A:");
        printMatrix(matrixA);

        System.out.println("\nМатриця B:");
        printMatrix(matrixB);

        short[][] resultSum = matrixSum(matrixA, matrixB);
        System.out.println("\nРезультат прямої суми матриць A і B:");
        printMatrix(resultSum);

        System.out.println("\nНайменші елементи кожного стовпця матриці:");
        printMinElements(resultSum);
    }

    private static short[][] matrixSum(short[][] matrixA, short[][] matrixB) throws Exception {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int rowsB = matrixB.length;
        int colsB = matrixB[0].length;

        short[][] result = new short[rowsA + rowsB][colsA + colsB];

        for (int i = 0; i < rowsA; i++) {
            System.arraycopy(matrixA[i], 0, result[i], 0, colsA);
        }

        for (int i = 0; i < rowsB; i++) {
            System.arraycopy(matrixB[i], 0, result[i + rowsA], colsA, colsB);
        }

        return result;
    }

    private static void printMatrix(short[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void printMinElements(short[][] matrix) {
        int cols = matrix[0].length;

        for (int j = 0; j < cols; j++) {
            short minElement = matrix[0][j];
            for (int i = 1; i < matrix.length; i++) {
                if (matrix[i][j] < minElement) {
                    minElement = matrix[i][j];
                }
            }
            System.out.println("Стовпець " + j + ": " + minElement);
        }
    }
}