import java.util.Scanner;

public class GraphPlotter {
    public static void plotGraph(Scanner scanner) {
        System.out.println("Podaj wzór funkcji w formacie: ax^n (np. 2x^2 dla paraboli lub 3x^1 dla funkcji liniowej):");
        String function = scanner.next();

        // Rozpoznawanie typu funkcji
        double a = Double.parseDouble(function.split("x")[0]);
        int n = Integer.parseInt(function.split("\\^")[1]);
        String type;

        if (n == 0) {
            type = "Stała";
        } else if (n == 1) {
            type = "Liniowa";
        } else if (n == 2) {
            type = "Parabola (kwadratowa)";
        } else {
            type = "Inny typ wielomianu (wykres może być ograniczony)";
        }

        System.out.println("Rozpoznano typ funkcji: " + type);
        drawGraph(a, n);
    }

    private static void drawGraph(double a, int n) {
        int height = 20; // Wysokość wykresu
        int width = 40;  // Szerokość wykresu

        char[][] graph = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                graph[i][j] = ' '; // Wypełnienie tła
            }
        }

        // Oś X i Y
        int centerX = width / 2;
        int centerY = height / 2;
        for (int i = 0; i < height; i++) {
            graph[i][centerX] = '|'; // Oś Y
        }
        for (int j = 0; j < width; j++) {
            graph[centerY][j] = '-'; // Oś X
        }
        graph[centerY][centerX] = '+'; // Punkt przecięcia osi

        // Rysowanie funkcji
        for (int x = -centerX; x < centerX; x++) {
            int y = (int) (a * Math.pow(x, n));
            int plotX = centerX + x;
            int plotY = centerY - y;

            if (plotX >= 0 && plotX < width && plotY >= 0 && plotY < height) {
                graph[plotY][plotX] = '*'; // Punkt funkcji
            }
        }

        // Wyświetlanie wykresu
        for (char[] row : graph) {
            for (char pixel : row) {
                System.out.print(pixel);
            }
            System.out.println();
        }
    }
}
