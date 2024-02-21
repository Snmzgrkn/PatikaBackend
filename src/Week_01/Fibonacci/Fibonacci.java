package Week_01.Fibonacci;
import java.util.Scanner;
public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1=0;
        int n2=1;
        int n3,i,sayi;

        System.out.println( "N Sayısı Giriniz :");
        sayi=scanner.nextInt();
        System.out.print(n1 + " " +n2 ); // 0 ve 1

        for (i = 2; i < sayi; i++) {
            n3 =n1 + n2;
            System.out.print(" "+n3);

            n1 = n2;// 2 sayıyı yerlerini değiştire değiştire gidiyor.
            n2 = n3;

        }
        System.out.println();

    }
}
