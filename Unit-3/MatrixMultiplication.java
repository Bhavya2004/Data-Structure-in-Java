import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create matrix1
        int[][] matrix1 = new int[3][2];
        System.out.println("Enter the elements of the first matrix (3x2):");
        readMatrixElements(scanner, matrix1);

        // Create matrix2
        int[][] matrix2 = new int[2][3];
        System.out.println("Enter the elements of the second matrix (2x3):");
        readMatrixElements(scanner, matrix2);

        // Perform matrix multiplication
        int[][] productMatrix = multiplyMatrices(matrix1, matrix2);

        // Print the product matrix
        System.out.println("Product of the matrices:");
        printMatrix(productMatrix);
    }

    public static void readMatrixElements(Scanner scanner, int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Enter element at position (" + (i + 1) + ", " + (j + 1) + "): ");
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;
        int columns1 = matrix1[0].length;
        int rows2 = matrix2.length;
        int columns2 = matrix2[0].length;

        int[][] productMatrix = new int[rows1][columns2];

        // Perform matrix multiplication
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < columns2; j++) {
                for (int k = 0; k < columns1; k++) {
                    productMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return productMatrix;
    }

    public static void printMatrix(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
