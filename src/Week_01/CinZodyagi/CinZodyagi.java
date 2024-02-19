package Week_01.CinZodyagi;

import java.util.Scanner;

public class CinZodyagi {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Çin Zodyağı Programına Hoşgeldiniz!");
        System.out.println("-----------------------------------");

        System.out.println("Lütfen Doğum Yılınızı Giriniz :");
        int year = scanner.nextInt();
        int zodyag = year % 12;
        String name = null;

        //Daha kararlı çalışması için switch-case yapısını kullandım.
        switch (zodyag){

            case 0 :
                name="Maymun";
                break;
            case 1 :
                name="Horoz";
                break;
            case 2:
                name="Köpek";
                break;
            case 3 :
                name="Domuz";
                break;
            case 4 :
                name="Fare";
                break;
            case 5:
                name="Öküz";
                break;
            case 6 :
                name="Kaplan";
                break;
            case 7 :
                name="Tavşan";
                break;
            case 8:
                name="Ejderha";
                break;
            case 9:
                name="Yılan";
                break;
            case 10:
                name="At";
                break;
            case 11:
                name="Koyun";
                break;

            default:
                break;
        }
        System.out.println("Çin Zodyağı Burcunuz : " + name);
    }
}
