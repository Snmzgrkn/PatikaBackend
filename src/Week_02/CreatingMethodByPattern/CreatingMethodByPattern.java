package Week_02.CreatingMethodByPattern;

import java.util.Scanner;

public class CreatingMethodByPattern {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        System.out.println("Please Enter N Number :");
        int n = scanner.nextInt();

        //Recursive Method Calling
        methodByPattern(n);

    }

    static void methodByPattern(int n){
        //Last Value Print
        System.out.print(n + " ");

        //If number negative or 0 , method ends
        if (n<=0){
            return;
        }

        //Minus 5 from number and calling recursive method
        methodByPattern(n-5);

        //After negative or 0 , add 5 and print last value
        System.out.print(n+" ");
    }
}
