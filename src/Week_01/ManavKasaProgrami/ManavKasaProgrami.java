package Week_01.ManavKasaProgrami;

import java.util.Scanner;

public class ManavKasaProgrami {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Manav Kasa Programına Hoşgeldiniz!");
        //Ürünlerin fiyatlarını double şeklinde belirledim.
        double armutFiyat = 2.14;
        double elmaFiyat = 3.67;
        double domatesFiyat = 1.11;
        double muzFiyat = 0.95;
        double patlıcanFiyat = 5.00;
        double toplamTutar = 0;
        System.out.println("------------------------------------------");
        System.out.println("Ürün Fiyat Listesi: ");
        //Fiyat Listesini konsolda yazdırdım.
        System.out.println("Armut " + armutFiyat);
        System.out.println("Elma " + elmaFiyat);
        System.out.println("Domates " + domatesFiyat);
        System.out.println("Muz " + muzFiyat);
        System.out.println("Patlıcan " + patlıcanFiyat);
        System.out.println("-----------------------------------------");
        System.out.println("-----------------------------------------");

        System.out.println("Armut Kaç Kilo ? ");
        //Toplam tutarı = ürünün fiyat x istenilen kilo üzerinden toplam tutara ekledim.
        int armutIstek = scanner.nextInt();
        toplamTutar += armutIstek*armutFiyat;

        System.out.println("Elma Kaç Kilo ? ");
        int elmaIstek = scanner.nextInt();
        toplamTutar += elmaIstek*elmaFiyat;

        System.out.println("Domates Kaç Kilo ? ");
        int domatesIstek = scanner.nextInt();
        toplamTutar += domatesIstek*domatesFiyat;

        System.out.println("Muz Kaç Kilo ? ");
        int muzIstek = scanner.nextInt();
        toplamTutar += muzIstek*muzFiyat;

        System.out.println("Patlıcan Kaç Kilo ? ");
        int patlıcanIstek = scanner.nextInt();
        toplamTutar += patlıcanIstek*patlıcanFiyat;

        System.out.println("Toplam Tutar : " + toplamTutar);






    }
}
