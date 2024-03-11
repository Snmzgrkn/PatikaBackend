package Week_04.InterfaceBankSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Enter value :");
        double price = scanner.nextDouble();
        System.out.println("Enter Card Number :");
        String cardNumber = scanner.next();
        System.out.println("Enter Expire Date : ");
        String date=scanner.next();
        System.out.println("Enter CVC Code: ");
        String cvc = scanner.next();


        System.out.println("1. A Bank");
        System.out.println("2. B Bank");
        System.out.println("3. C Bank");
        System.out.println("Select Bank :");
        int select = scanner.nextInt();

        switch (select){
            case 1:
                ABank aPos = new ABank("A Bank","123124124","123123");
                aPos.connect("123125");
                aPos.payment(price,cardNumber,date,cvc);
                break;
            default:
                System.out.println("Geçerli Banka Giriniz !!");
        }

    }
}
