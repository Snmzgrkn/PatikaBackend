package Week_01.AsalSayi100;

public class AsalSayi100 {
    public static void main(String[] args) {
        int count = 0;
        //En küçük Asal Sayı 2 olduğu için 2'den başlıyor döngü.
        for(int number=2;number<=100;number++)
        {
            int check = 0;
            for (int i = 2; i < number; i++)
            {
                if (number % i == 0)
                {
                    check = 1;
                    break;
                }
            }
            //Check durumu ile asal olup olmadığını kontrol ediyoruz, eğer asal ise ekrana Asal Sayıdır yazdırıyoruz.
            if(check==0)
            {
                System.out.print(number+" Asal Sayıdır.\n");
                count++;
            }
        }
    }
}
