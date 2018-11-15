import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.Random;

class Enemy{

    private static BufferedImage Enemy;
    //private int x;
    //private int y;

    static {
        try {
            Enemy = ImageIO.read(Enemy.class.getResource("img/Enemy.png"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private Random EnemyMove = new Random();
    int ran = EnemyMove.nextInt(20);


}
