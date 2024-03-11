package Week_04.AdventureGame;

import java.util.Scanner;

public class Game {
    private Player player;
    private Scanner scanner = new Scanner(System.in);

    public void start(){

        System.out.println("Macera Oyununa Hoşgeldiniz !" );
        System.out.println("Lütfen bir isim giriniz : ");
        //String playerName = scanner.nextLine();
        Player player = new Player("Gürkan");
        System.out.println("Sayın " + player.getName() + " bu karanlık ve sisli adaya hoşgeldiniz !!!");
        System.out.println("Lütfen Bir Karakter Seçiniz!");
        player.selectChar();

        Location location = null;
        while (true){
            player.printInfo();
            System.out.println();
            System.out.println(" ################## Bölgeler ################## ");
            System.out.println();
            System.out.println("1  -  Güvenli Ev    --> Burası sizin için güvenli bir ev, düşman yoktur !");
            System.out.println("2  -  Eşya Dükkanı  --> Silah veya Zırh satın alabilirsiniz !");
            System.out.println("3  -  Mağara --> Ödül : Yemek,  dikkatli ol Zombi çıkabilir !");
            System.out.println("4  -  Ormana --> Ödül : Odun ,  dikkatli ol Vampir çıkabilir !");
            System.out.println("5  -  Nehir  --> Ödül : Su ,  dikkatli ol Ayı çıkabilir !");

            System.out.println("0  -  Çıkış Yap --> Oyunu sonlandır.");

            System.out.println("Lütfen gitmek istediğiniz bölgeyi seçiniz!");
            int selectLoc = scanner.nextInt();
            switch (selectLoc){
                case 0:
                    location=null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                default:
                    System.out.println("Lütfen Geçerli bir bölge giriniz !");
            }
            if (location == null){
                System.out.println("Bu karanlık ve sisli adadan çabuk vazgeçtin ! !");
                break;
            }
            if (!location.onLocation()){
                System.out.println("GAME OVER!");
                break;
            }

        }

    }
}
