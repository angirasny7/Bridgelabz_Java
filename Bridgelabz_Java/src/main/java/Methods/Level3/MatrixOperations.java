package Methods.Level3;

public class MatrixOperations {

    // Generate a random matrix
    public static int[][] createRandomMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = (int) (Math.random() * 10);
            }
        }

        return matrix;
    }

    // Add two matrices
    public static int[][] addMatrices(int[][] a, int[][] b) {
        int rows = a.length;
        int cols = a[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }

        return result;
    }

    // Subtract two matrices
    public static int[][] subtractMatrices(int[][] a, int[][] b) {
        int rows = a.length;
        int cols = a[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = a[i][j] - b[i][j];
            }
        }

        return result;
    }

    // Multiply two matrices
    public static int[][] multiplyMatrices(int[][] a, int[][] b) {
        int rows = a.length;
        int cols = b[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < b.length; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return result;
    }

    // Find the transpose of a matrix
    public static int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transpose = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }

        return transpose;
    }

    // Find the determinant of a 2x2 matrix
    public static double determinant2x2(double[][] matrix) {
        return matrix[0][0] * matrix[1][1]
                - matrix[0][1] * matrix[1][0];
    }

    // Find the determinant of a 3x3 matrix
    public static double determinant3x3(double[][] m) {
        return m[0][0] * (m[1][1] * m[2][2] - m[1][2] * m[2][1])
                - m[0][1] * (m[1][0] * m[2][2] - m[1][2] * m[2][0])
                + m[0][2] * (m[1][0] * m[2][1] - m[1][1] * m[2][0]);
    }

    // Find the inverse of a 2x2 matrix
    public static double[][] inverse2x2(double[][] m) {
        double det = determinant2x2(m);

        if (det == 0) {
            return null;
        }

        double[][] inverse = new double[2][2];

        inverse[0][0] = m[1][1] / det;
        inverse[0][1] = -m[0][1] / det;
        inverse[1][0] = -m[1][0] / det;
        inverse[1][1] = m[0][0] / det;

        return inverse;
    }

    // Find the inverse of a 3x3 matrix
    public static double[][] inverse3x3(double[][] m) {
        double det = determinant3x3(m);

        if (Math.abs(det) < 1e-10) {
            return null;
        }

        double[][] inverse = new double[3][3];

        inverse[0][0] = (m[1][1] * m[2][2] - m[1][2] * m[2][1]) / det;
        inverse[0][1] = (m[0][2] * m[2][1] - m[0][1] * m[2][2]) / det;
        inverse[0][2] = (m[0][1] * m[1][2] - m[0][2] * m[1][1]) / det;

        inverse[1][0] = (m[1][2] * m[2][0] - m[1][0] * m[2][2]) / det;
        inverse[1][1] = (m[0][0] * m[2][2] - m[0][2] * m[2][0]) / det;
        inverse[1][2] = (m[0][2] * m[1][0] - m[0][0] * m[1][2]) / det;

        inverse[2][0] = (m[1][0] * m[2][1] - m[1][1] * m[2][0]) / det;
        inverse[2][1] = (m[0][1] * m[2][0] - m[0][0] * m[2][1]) / det;
        inverse[2][2] = (m[0][0] * m[1][1] - m[0][1] * m[1][0]) / det;

        return inverse;
    }

    // Display an integer matrix
    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.printf("%5d", value);
            }
            System.out.println();
        }
    }

    // Display a double matrix
    public static void displayMatrix(double[][] matrix) {
        if (matrix == null) {
            System.out.println("Inverse does not exist.");
            return;
        }

        for (double[] row : matrix) {
            for (double value : row) {
                System.out.printf("%10.3f", value);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] a = createRandomMatrix(2, 2);
        int[][] b = createRandomMatrix(2, 2);

        System.out.println("Matrix A:");
        displayMatrix(a);

        System.out.println("\nMatrix B:");
        displayMatrix(b);

        System.out.println("\nAddition:");
        displayMatrix(addMatrices(a, b));

        System.out.println("\nSubtraction:");
        displayMatrix(subtractMatrices(a, b));

        System.out.println("\nMultiplication:");
        displayMatrix(multiplyMatrices(a, b));

        System.out.println("\nTranspose of Matrix A:");
        displayMatrix(transposeMatrix(a));

        double[][] matrix2 = {
                {4, 7},
                {2, 6}
        };

        System.out.println("\nDeterminant of 2x2 Matrix:");
        System.out.println(determinant2x2(matrix2));

        System.out.println("\nInverse of 2x2 Matrix:");
        displayMatrix(inverse2x2(matrix2));

        double[][] matrix3 = {
                {1, 2, 3},
                {0, 1, 4},
                {5, 6, 0}
        };

        System.out.println("\nDeterminant of 3x3 Matrix:");
        System.out.println(determinant3x3(matrix3));

        System.out.println("\nInverse of 3x3 Matrix:");
        displayMatrix(inverse3x3(matrix3));
    }
}