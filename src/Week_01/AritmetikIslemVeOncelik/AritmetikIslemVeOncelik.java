package Week_01.AritmetikIslemVeOncelik;
import java.util.*;

public class AritmetikIslemVeOncelik {
    public static void main(String[] args) {
        //I obtained a result by taking 3 numbers from the user and processing these numbers among themselves.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter 1.Number:");
        int number1 = scanner.nextInt();
        System.out.println("Please enter 2.Number:");
        int number2 = scanner.nextInt();
        System.out.println("Please enter 3.Number:");
        int number3 = scanner.nextInt();
        //Sum here 
        int sum = number1 + number2 * number3 - number2;
        System.out.println(sum);
    }
}
