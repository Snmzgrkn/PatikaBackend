package Week_01.ArtikYilHesaplama;

import java.util.Scanner;

public class ArtikYilHesaplama {
    public static void main(String[] args) {
        //Artık Yıl Hesaplama Programı
        //Genel bir kural olarak, artık yıllar 4 rakamının katı olan
        //100'ün katı olan yıllardan sadece 400'e kalansız olarak bölünebilenler artık yıldır.

        Scanner scanner = new Scanner(System.in);
        System.out.println("Artık Yıl Hesaplama Programına Hoşgeldiniz!");
        System.out.println("-------------------------------------------");
        System.out.println("Yıl Giriniz : ");
        int year = scanner.nextInt();

        if (year%4==0){
            System.out.println(year + " bir artık yıldır!");
        }
        else if(year%100==0 && year%400==0){
            System.out.println(year + " bir artık yıldır!");
        }
        else {
            System.out.println(year + " bir artık yıl değildir!");
        }

    }
}
