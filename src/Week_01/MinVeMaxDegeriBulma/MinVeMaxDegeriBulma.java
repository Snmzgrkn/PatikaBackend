package Week_01.MinVeMaxDegeriBulma;

import java.util.Scanner;

public class MinVeMaxDegeriBulma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------------------------------");
        System.out.println("Kaç tane sayı gireceksiniz : ");
        int x = scanner.nextInt();
        int buyuk = 0;
        int kucuk =0;
        for (int i = 1; i <= x; i++) {
            System.out.println(i + ". Sayıyı Giriniz: ");
            int sayi = scanner.nextInt();
            if (sayi>buyuk){
                buyuk = sayi;
            }
            else if (sayi<kucuk){
                kucuk = sayi;
            }

        }
        System.out.println("En büyük sayı: " + buyuk);
        System.out.println("En küçük sayı: " + kucuk);

    }
}
