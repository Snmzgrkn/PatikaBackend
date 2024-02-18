package Week_01.VücutKitleEndeksiHesaplama;

import java.util.Scanner;

public class VücutKitleEndeksiHesaplama {
    public static void main(String[] args) {
        //The code written for the user to enter their weight and height is as follows.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your body weight in kilograms(like 80):");
        double weight = scanner.nextDouble();
        System.out.println("Please enter your height in meters(like 1,75) : ");
        double height = scanner.nextDouble();
        //BMI Calculation :
        double bmi = weight / (height * height);
        System.out.println("Your Body Mass Index is : " +bmi);


    }
}
