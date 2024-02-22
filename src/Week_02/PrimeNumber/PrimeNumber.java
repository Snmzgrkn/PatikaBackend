package Week_02.PrimeNumber;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please Enter Number :");
        int number = scanner.nextInt();

        if (isPrime(number)) {
            System.out.println(number + " is a prime number.");
        } else {
            System.out.println(number + " is not a prime number.");
        }

    }

    static boolean isPrime(int number){
        if (number<=1) {
            return false; //Number less than or equal to 1 cannot prime
        }

        //Check numbers from 2 up to the square root of the given number
        for (int i = 2; i < Math.sqrt(number); i++) {
            if (number%i==0){
                return false;//If any divisor is found, the number is not prime
            }
        }
        return true;//If no divisors are found, the number is prime
    }
}
