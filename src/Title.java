import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

class Title extends JPanel {

    private static BufferedImage BeginPic;
    static {
        try {
            BeginPic = ImageIO.read(Title.class.getResource("/img/Title.png"));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean Begin = true;
    public void paint(Graphics g){
        if(Begin){
            g.drawImage(BeginPic,0,0,null);
            try {
                Thread.sleep(3000);
                Begin = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
