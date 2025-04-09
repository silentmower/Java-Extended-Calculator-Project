import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Witaj w zaawansowanym kalkulatorze matematycznym!");

        while (true) {
            System.out.println("Wybierz funkcję: ");
            System.out.println("1 - Operacje na macierzach");
            System.out.println("2 - Obliczanie całek");
            System.out.println("3 - Rysowanie wykresów");
            System.out.println("4 - Wyjście");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> MatrixOperations.menu(scanner);
                case 2 -> Calculus.calculateIntegral(scanner);
                case 3 -> GraphPlotter.plotGraph(scanner);
                case 4 -> {
                    System.out.println("Do zobaczenia!");
                    return;
                }
                default -> System.out.println("Nieprawidłowy wybór!");
            }
        }
    }
}

