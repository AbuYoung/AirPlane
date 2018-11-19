import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

class Background extends JPanel{


    private static BufferedImage SkyPic;//&#x80cc;&#x666f;&#x56fe;&#x7247;
    private static BufferedImage Hero;//&#x4e3b;&#x673a;
    private int x;//&#x98de;&#x673a;&#x7684; x &#x5750;&#x6807;
    private int y;//&#x98de;&#x673a;&#x7684; y &#x5750;&#x6807;

    private boolean State_UP;
    private boolean State_DOWN;
    private boolean State_RIGHT;
    private boolean State_LEFT;

    static{
        try {
            SkyPic = ImageIO.read(Background.class.getResource("/img/src.jpg"));
            Hero = ImageIO.read(Background.class.getResource("/img/Hero.png"));
            //Enemy = ImageIO.read(Background.class.getResource("img/Enemy.png"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g) {
        move();
        //System.out.println(x+','+y);
        g.drawImage(SkyPic,0,0,null);
        if (x == 0 && y == 0){
            g.drawImage(Hero,x=200,y=500,null );
        }else if(x != 200 || y != 400)
            g.drawImage(Hero,x/2,y/3,null);
        //g.drawImage(Hero,x/2,y/3,null);
        //g.drawImage(Enemy,200,0,null);
    }

    private void move(){
        if (State_UP && y != 0)
            y--;
        if (State_DOWN && y <= 1347)
            y++;
        if (State_LEFT && x != 0)
            x--;
        if (State_RIGHT && x <= 644)
            x++;
    }

}