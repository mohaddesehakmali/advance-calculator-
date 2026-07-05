import java.util.ArrayList;

public class AdvanceCalculator {

    public double calculate(ArrayList<Double> numbers, int function) {

        switch (function) {

            case 1:
                return min(numbers);

            case 2:
                return max(numbers);

            case 3:
                return average(numbers);

            case 4:
                return sum(numbers);

            default:
                throw new InvalidOperationException("Invalid function.");
        }

    }

    private double min(ArrayList<Double> numbers) {

        double min = numbers.get(0);

        for (double number : numbers) {

            if (number < min) {
                min = number;
            }

        }

        return min;

    }

    private double max(ArrayList<Double> numbers) {

        double max = numbers.get(0);

        for (double number : numbers) {

            if (number > max) {
                max = number;
            }

        }

        return max;

    }

    private double sum(ArrayList<Double> numbers) {

        double sum = 0;

        for (double number : numbers) {
            sum += number;
        }

        return sum;

    }

    private double average(ArrayList<Double> numbers) {

        return sum(numbers) / numbers.size();

    }

}