import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

class Enemy{

    int Speed = 1;

    static BufferedImage EnemyPic;

    static {
        try {
            EnemyPic = ImageIO.read(Enemy.class.getResource("img/Enemy.png"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
