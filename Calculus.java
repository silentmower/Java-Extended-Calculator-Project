import java.util.Scanner;

public class Calculus {
    public static void calculateIntegral(Scanner scanner) {
        System.out.println("Podaj funkcję w formacie: ax^n");
        String function = scanner.next();
        System.out.println("Podaj granice całkowania (dolna, górna): ");
        double lower = scanner.nextDouble();
        double upper = scanner.nextDouble();

        // Przykładowa uproszczona implementacja dla funkcji wielomianowych
        double a = Double.parseDouble(function.split("x")[0]);
        int n = Integer.parseInt(function.split("^")[1]);
        double result = (a / (n + 1)) * (Math.pow(upper, n + 1) - Math.pow(lower, n + 1));

        System.out.println("Wynik: " + result);
    }
}

