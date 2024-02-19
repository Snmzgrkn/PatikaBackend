package Week_01.Calculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please Enter First Number");
        int x = scanner.nextInt();

        System.out.println("Please Enter Second Number");
        int y = scanner.nextInt();

        System.out.println("1-Addition\n2-Subtraction\n3-Multiplication\n4-Division");
        System.out.println("Your select : ");
        int select = scanner.nextInt();

        switch (select){
            case 1:
                System.out.println("Addition : " +(x+y));
                break;
            case 2:
                System.out.println("Substraction : " +(x-y));

                break;
            case 3:
                System.out.println("Multiplication : " +(x*y));

                break;
            case 4:
                System.out.println("Division : " +(x/y));
                break;
            default:
                System.out.println("Wrong! Please try again.");
                break;
        }
        System.out.println(select);
    }
}
