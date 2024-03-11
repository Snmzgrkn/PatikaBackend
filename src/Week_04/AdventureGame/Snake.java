package Week_04.AdventureGame;

import java.util.Random;

public class Snake extends Obstacle{
    private static Random random = new Random();

    public Snake() {
        super(4,"Yılan", random.nextInt(3,7), 12, 0);
    }
}
