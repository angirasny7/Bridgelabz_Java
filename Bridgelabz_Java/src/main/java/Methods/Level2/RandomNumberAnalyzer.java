package Methods.Level2;

/*
 * Generates five random four-digit numbers and calculates
 * their average, minimum, and maximum values.
 */

public class RandomNumberAnalyzer {

    // Generates an array of random four-digit numbers.
    public int[] generate4DigitRandomArray(int size) {
        int[] numbers = new int[size];

        for (int i = 0; i < size; i++) {
            numbers[i] = (int) (Math.random() * 9000) + 1000;
        }

        return numbers;
    }

    // Calculates the average, minimum, and maximum of an array.
    public double[] findAverageMinMax(int[] numbers) {
        double sum = 0;
        int min = numbers[0];
        int max = numbers[0];

        for (int number : numbers) {
            sum += number;
            min = Math.min(min, number);
            max = Math.max(max, number);
        }

        double average = sum / numbers.length;

        return new double[]{average, min, max};
    }

    public static void main(String[] args) {
        RandomNumberAnalyzer analyzer = new RandomNumberAnalyzer();

        // Generate five random four-digit numbers.
        int[] numbers = analyzer.generate4DigitRandomArray(5);

        // Display the generated numbers.
        System.out.println("Generated 4-digit random numbers:");

        for (int number : numbers) {
            System.out.println(number);
        }

        // Calculate the average, minimum, and maximum.
        double[] results = analyzer.findAverageMinMax(numbers);

        // Display the results.
        System.out.printf("%nAverage: %.2f%n", results[0]);
        System.out.printf("Minimum: %.0f%n", results[1]);
        System.out.printf("Maximum: %.0f%n", results[2]);
    }
}