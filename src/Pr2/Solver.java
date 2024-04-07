import java.util.Scanner;

public class Solver {
    public static void main(String[] args) {
        // Створення об'єкта CalculationResult
        CalculationResult result = new CalculationResult(1.5, 2.5);

        // Вибір типу рендерера
        System.out.println("Choose result renderer (1 for Text, 2 for HTML):");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        CalculationResultRenderer renderer;
        if (choice == 1) {
            renderer = new TextResultRenderer();
        } else if (choice == 2) {
            renderer = new HTMLResultRenderer();
        } else {
            System.out.println("Invalid choice. Defaulting to Text renderer.");
            renderer = new TextResultRenderer();
        }

        // Виведення результату
        System.out.println(renderer.render(result));

        // Закриваємо Scanner
        scanner.close();
    }
}