package Week_01.MukemmelSayiBulma;

import java.util.Scanner;

public class MukemmelSayiBulma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------------------");
        System.out.println("Bir Sayı Giriniz: ");
        int sayi = scanner.nextInt();
        int toplam = 0;
        for (int i = 1; i <sayi; i++) {
            if(sayi%i==0){
                toplam +=i;
            }
        }
        if (toplam==sayi){
            System.out.println(sayi + " sayısı Mükemmel Sayıdır");
        }
        else {
            System.out.println(sayi + " sayısı Mükemmel Sayı Değildir");
        }
        System.out.println("------------------------");
    }
}
