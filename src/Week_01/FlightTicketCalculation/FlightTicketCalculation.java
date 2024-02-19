package Week_01.FlightTicketCalculation;

import java.util.Scanner;

public class FlightTicketCalculation {
    //Uçak Bileti Fiyatı Hesaplama Programına Hoşgeldiniz!
    //Kullanıcıdan aldığımız yaş ile yaş indirimi oranını method ile hesaplattırdım.
    public static double ageDiscountRateCalculate(int age){
        double ageRate =0;
        if (age<12){
           ageRate = 0.50;
        } else if (age>12 && age<24) {
            ageRate = 0.10;
        } else if (age>65) {
            ageRate=0.30;
        }
        return  ageRate;
    }

    //Biley Fiyatı Hesaplama Metodu
    static void calcuteTicketPrice(int km,int age,int type){
        int totalPrice;
        int normalPrice = (int) (km * 0.10);
        double ageDiscountRate =  ageDiscountRateCalculate(age);  //yaşIndirimOranı = yaşIndirimOranıHesapla(yaş)
        int ageDiscount = (int) (normalPrice * ageDiscountRate);  //yaşIndirimi     = normalFiyat * yaşIndirimOranı
        int discountedPrice = normalPrice - ageDiscount;          //indirimliFiyat  = normalFiyat - yaşIndirimi
        int type2Discount = (int) (discountedPrice * 0.20);       //Eğer ki gidiş-dönüş ise

        if (type==1){
            totalPrice = discountedPrice;
            System.out.println("Toplam Tutar : " +totalPrice);
        }
        else {
            totalPrice = (discountedPrice-type2Discount)*2;
            System.out.println("Toplam Tutar : " + totalPrice);
        }



    }
    public static void main(String[] args) {
        System.out.println("Uçak Bileti Fiyatı Hesaplama Programına Hoşgeldiniz!");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Mesafeyi km türünden giriniz : ");
        int km = scanner.nextInt();

        System.out.println("Yaşınızı giriniz : ");
        int age = scanner.nextInt();

        System.out.println("Yolculuk tipini giriniz (Gidiş --> 1 || Gidiş-Dönüş --> 2) : ");
        int type = scanner.nextInt();

        if (km<0 && age<0 && (type!=1 || type !=2)){
            System.out.println("Hatalı Veri Girdiniz!");
        }
        else {
            calcuteTicketPrice(km,age,type);
        }
    }
}
