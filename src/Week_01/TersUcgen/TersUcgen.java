package Week_01.TersUcgen;

import java.util.Scanner;

public class TersUcgen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Basamak Sayısı Giriniz :");
        int basamak = scanner.nextInt();

        for (int i = basamak; i>=1 ; i--) {

            //Boşluklar
            for (int j = 0; j < basamak - i; j++) {
                System.out.print(" ");
            }

            // Yıldızlar
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }

            // Satırı Tamamlama
            System.out.println();

        }
    }
}
