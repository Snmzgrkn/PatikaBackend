package Week_02.HarmonicArray;

public class Main {
    public static void main(String[] args) {
        //Program that calculates the harmonic mean of numbers in a series
        int[] numbers = {1,2,3,4,5};
        double harmonic = 0.0;

        for (int i = 0; i < numbers.length; i++) {
            harmonic += 1.0 / numbers[i];
        }

        System.out.println(numbers.length / harmonic);
    }
}
