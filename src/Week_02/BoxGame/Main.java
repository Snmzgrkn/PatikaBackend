package Week_02.BoxGame;

public class Main {
    public static void main(String[] args) {
        Fighter f1 = new Fighter("Sagopa",15,120,100,50);
        Fighter f2 = new Fighter("Ceza",20,85,85,40);


        Match match = new Match(f1,f2,80,110);

        match.run();
    }
}
