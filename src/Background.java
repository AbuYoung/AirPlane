//import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
//import java.nio.Buffer;

class Background extends JPanel implements KeyListener {

    private static BufferedImage SkyPic;//背景图片
    private static BufferedImage Hero;//主机
    //private static BufferedImage Enemy;//敌机
    private int x;//飞机的 x 坐标
    private int y;//飞机的 y 坐标

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

    @Override
    public void keyTyped(KeyEvent e) {

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
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_UP:
                State_UP=true;
                break;
            case KeyEvent.VK_DOWN:
                State_DOWN=true;
                break;
            case KeyEvent.VK_LEFT:
                State_LEFT=true;
                break;
            case KeyEvent.VK_RIGHT:
                State_RIGHT=true;
                break;
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                State_UP = false;
                break;
            case KeyEvent.VK_DOWN:
                State_DOWN = false;
                break;
            case KeyEvent.VK_LEFT:
                State_LEFT = false;
                break;
            case KeyEvent.VK_RIGHT:
                State_RIGHT = false;
                break;
            default:
                break;
        }
    }
}