package Week_04.StaticKeyword;

public class Player {
    static int onlinePlayers;

    Player() {
        onlinePlayers++;
    }

    public static void main(String[] args) {

        Player p1 = new Player();
        Player p2 = new Player();
        Player p3 = new Player();

        System.out.println("Online oyuncular : " + Player.onlinePlayers);
    }
}
