import java.util.Scanner;

public class MatrixOperations {
    public static void menu(Scanner scanner) {
        try {
            System.out.println("Wybierz operację na macierzach:");
            System.out.println("1 - Dodawanie");
            System.out.println("2 - Odejmowanie");
            System.out.println("3 - Mnożenie");
            System.out.println("4 - Transponowanie");
            int choice = scanner.nextInt();

            if (choice == 4) {
                // Transponowanie wymaga tylko jednej macierzy
                System.out.println("Wybrano transponowanie.");
                int[] dimensions = readDimensions(scanner);
                int rows = dimensions[0];
                int cols = dimensions[1];
                double[][] matrix = readMatrix(scanner, rows, cols);

                System.out.println("Macierz po transponowaniu:");
                printMatrix(transpose(matrix));
            } else if (choice >= 1 && choice <= 3) {
                // Dla pozostałych operacji wymagane są dwie macierze
                System.out.println("Wybrano operację wymagającą dwóch macierzy.");
                int[] dimensions = readDimensions(scanner);
                int rows = dimensions[0];
                int cols = dimensions[1];
                System.out.println("Podaj pierwszą macierz:");
                double[][] matrix1 = readMatrix(scanner, rows, cols);
                System.out.println("Podaj drugą macierz:");
                double[][] matrix2 = readMatrix(scanner, rows, cols);

                switch (choice) {
                    case 1 -> {
                        System.out.println("Wynik dodawania:");
                        printMatrix(add(matrix1, matrix2));
                    }
                    case 2 -> {
                        System.out.println("Wynik odejmowania:");
                        printMatrix(subtract(matrix1, matrix2));
                    }
                    case 3 -> {
                        System.out.println("Wynik mnożenia:");
                        printMatrix(multiply(matrix1, matrix2));
                    }
                    default -> System.out.println("Nieprawidłowy wybór!");
                }
            } else {
                System.out.println("Nieprawidłowy wybór!");
            }
        } catch (Exception e) {
            System.out.println("Błąd: " + e.getMessage());
        }
    }

    // Metoda do wprowadzania wymiarów macierzy
    private static int[] readDimensions(Scanner scanner) {
        System.out.println("Podaj wymiary macierzy (wiersze kolumny):");
        int rows = scanner.nextInt(); // Odczyt liczby całkowitej dla wierszy
        int cols = scanner.nextInt(); // Odczyt liczby całkowitej dla kolumn
        return new int[]{rows, cols}; // Zwraca tablicę z wymiarami
    }

    // Metoda do odczytu macierzy od użytkownika
    private static double[][] readMatrix(Scanner scanner, int rows, int cols) {
        double[][] matrix = new double[rows][cols];
        System.out.println("Podaj elementy macierzy (wierszami):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }
        return matrix;
    }

    // Operacja dodawania macierzy
    private static double[][] add(double[][] matrix1, double[][] matrix2) {
        double[][] result = new double[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    // Operacja odejmowania macierzy
    private static double[][] subtract(double[][] matrix1, double[][] matrix2) {
        double[][] result = new double[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }

    // Operacja mnożenia macierzy
    private static double[][] multiply(double[][] matrix1, double[][] matrix2) {
        if (matrix1[0].length != matrix2.length) {
            throw new IllegalArgumentException("Liczba kolumn pierwszej macierzy musi równać się liczbie wierszy drugiej macierzy!");
        }
        double[][] result = new double[matrix1.length][matrix2[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                for (int k = 0; k < matrix1[0].length; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }

    // Operacja transponowania macierzy
    private static double[][] transpose(double[][] matrix) {
        double[][] result = new double[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

    // Wyświetlanie macierzy w konsoli
    private static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double elem : row) {
                System.out.printf("%.2f ", elem); // Zaokrąglenie do 2 miejsc po przecinku
            }
            System.out.println();
        }
    }
}
