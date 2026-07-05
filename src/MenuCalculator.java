import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuCalculator {

    private final Scanner scanner = new Scanner(System.in);

    private final CalculatorService calculator = new CalculatorService();

    private final AdvanceCalculator advanceCalculator = new AdvanceCalculator();

    private final HistoryService historyService = new HistoryService();

    public void start() {

        int choice = 0;

        do {

            showMenu();

            try {

                choice = scanner.nextInt();

                switch (choice) {

                    case 1:
                        simpleCalculator();
                        break;

                    case 2:
                        advancedCalculator();
                        break;

                    case 3:
                        historyService.showHistory();
                        break;

                    case 4:
                        historyService.deleteHistory();
                        break;

                    case 5:
                        System.out.println("Good Bye :)");
                        break;

                    default:
                        System.out.println("Invalid menu!");

                }

            } catch (InputMismatchException e) {

                System.out.println("Please enter a valid number.");
                scanner.nextLine();

            }

        } while (choice != 5);

        scanner.close();

    }

    private void simpleCalculator() {

        try {

            System.out.print("First number: ");
            double a = scanner.nextDouble();

            System.out.print("Second number: ");
            double b = scanner.nextDouble();

            System.out.print("Operator (+ - * / %): ");
            String sign = scanner.next();

            double result = calculator.calculate(a, b, sign);

            System.out.println("Result = " + result);

            historyService.addHistory(a, b, sign, result);

        } catch (RuntimeException e) {

            System.out.println(e.getMessage());

        }

    }

    private void advancedCalculator() {

        ArrayList<Double> numbers = new ArrayList<>();

        System.out.println("Enter numbers (-1 to finish)");

        while (true) {

            try {

                double number = scanner.nextDouble();

                if (number == -1)
                    break;

                numbers.add(number);

            } catch (InputMismatchException e) {

                System.out.println("Invalid number.");
                scanner.nextLine();

            }

        }

        if (numbers.isEmpty()) {

            System.out.println("No numbers entered.");

            return;

        }

        System.out.println("1. Min");
        System.out.println("2. Max");
        System.out.println("3. Average");
        System.out.println("4. Sum");

        int function = scanner.nextInt();

        double result = advanceCalculator.calculate(numbers, function);

        System.out.println("Result = " + result);

        historyService.addHistory(numbers, result);

    }

    private void showMenu() {

        System.out.println();
        System.out.println("========== Calculator ==========");
        System.out.println("1. Simple Calculator");
        System.out.println("2. Advanced Calculator");
        System.out.println("3. Show History");
        System.out.println("4. Delete History");
        System.out.println("5. Exit");
        System.out.print("Choice: ");

    }

}