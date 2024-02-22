package Week_02.ExponentialNumberCalculation;

import java.util.Scanner;

public class ExponentialNumberCalculation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Please Enter Base Number: ");
        int base = scanner.nextInt();

        System.out.println("Please Enter Exponent Number :");
        int exponent = scanner.nextInt();

       exponentialCalculate(base,exponent);
    }

    static void exponentialCalculate(int base,int exponent){

        if (exponent==0)
           System.out.println("Result : 1");
        else if (exponent==1)
           System.out.println("Result : " +base);
        else
            System.out.println("Result : " +(int) Math.pow(base,exponent));
            //I used Math.pow from Math Library
    }
}
