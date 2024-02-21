package Week_01.TipDonusum;

import java.util.Scanner;

public class TipDonusum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bir Tam Sayı Giriniz : ");
        int tamSayi = scanner.nextInt();
        System.out.println("Bir Ondalıklı Sayı Giriniz : ");
        double ondalikliSayi= scanner.nextDouble();

        System.out.println("Tam Sayının Ondalık Sayıya Dönüşümü :"+(double) tamSayi);
        System.out.println("Ondalıklı Sayının Tam Sayı Dönüşümü :"+ (int) ondalikliSayi);
    }
}
