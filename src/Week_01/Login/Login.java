package Week_01.Login;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        String userName,password;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Your Username :");
        userName = scanner.nextLine();

        System.out.println("Your Password :");
        password = scanner.nextLine();

        if(userName.equals("patika") && password.equals("java123")){
            System.out.println("Succesfull");

        }
        else {
            System.out.println("Please check your informations!");
        }

    }
}
