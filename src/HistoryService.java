import java.util.ArrayList;

public class HistoryService {

    private final ArrayList<String> history = new ArrayList<>();

    public void addHistory(double a, double b, String operator, double result) {

        history.add(a + " " + operator + " " + b + " = " + result);

    }

    public void addHistory(ArrayList<Double> numbers, double result) {

        history.add(numbers + " = " + result);

    }

    public void showHistory() {

        if (history.isEmpty()) {

            System.out.println("History is empty.");

            return;

        }

        System.out.println("========== History ==========");

        int index = 1;

        for (String item : history) {

            System.out.println(index + ". " + item);

            index++;

        }

    }

    public void deleteHistory() {

        history.clear();

        System.out.println("History deleted successfully.");

    }

}