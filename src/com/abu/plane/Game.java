package com.abu.plane;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static java.lang.Thread.sleep;

class Game extends JPanel implements KeyListener {

    private Hero newHero = new Hero();
    private Hit Hit = new Hit();
    private ArrayList<Enemy> Enemy_S = new ArrayList<>();
    private ArrayList<Bullet> GenBullet = new ArrayList<>();

    Game(){
        for(int i = 0; i < 10; i++)
            Enemy_S.add(new Enemy((int)(Math.random()*Constant.WINDOW_WIDTH),
                    (int)(Math.random()*(-1)*400)));
    }

    private int Hero_X = 100;private int Hero_Y = 200;//飞机的坐标
    private int BGx = 0, BGy = 0;//背景图片的坐标

    /*
    绘制画面
     */
    @Override
    public void paint(Graphics g) {

        g.drawImage(BackgroundPic_0, BGx, BGy, null);
        g.drawImage(BackgroundPic_1, BGx, BGy - 600, null);
        g.drawImage(Hero.HeroPic, Hero_X, Hero_Y, null);

        try {
            movePic();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 10; i++) {
            if (Enemy_S.get(i).local_y > 600) {
                Enemy_S.get(i).local_y = (int) (Math.random() * (-1) * Constant.WINDOW_HEIGHT);
            } else {
                if (Hit.HitEffort()) {
                    this.Enemy_S.get(i).remove(i);
                } else {
                    this.Enemy_S.get(i).paint(g);
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            moveBullet(i, g);
            GenBullet.add(new Bullet(Hero_X,Hero_Y));
            if (GenBullet.get(i).local_y < 0) {
                GenBullet.get(i).local_x = Hero_X;
                GenBullet.get(i).local_y = Hero_Y;
            }
        }
    }


    //背景图片导入
    private static BufferedImage BackgroundPic_0,BackgroundPic_1;
    static {
        try {
            BackgroundPic_0 = ImageIO.read(Game.class.getResource("/img/src.jpg"));
            BackgroundPic_1 = ImageIO.read(Game.class.getResource("/img/src.jpg"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    *
    * 移动坐标变化
    * */
    private boolean State_UP;
    private boolean State_DOWN;
    private boolean State_LEFT;
    private boolean State_RIGHT;
    private boolean space;

    private void movePic() throws InterruptedException {
        //主角飞机的控制
        if (State_UP && Hero_Y > 0)
            Hero_Y = Hero_Y - newHero.Speed;
        if(State_DOWN && Hero_Y < 470)
            Hero_Y = Hero_Y + newHero.Speed;
        if(State_LEFT && Hero_X > 0)
            Hero_X = Hero_X - newHero.Speed;
        if(State_RIGHT && Hero_X < 320)
            Hero_X = Hero_X + newHero.Speed;
        //背景滚动
        if(BGy == 600) {
            BGy = 0;BGx = 0;
        } else {
            BGy += 3;
        }
        //延时控制
        sleep(10);
    }

    private void moveBullet(int i, Graphics g){
        if (space)
            this.GenBullet.get(i).paint(g);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()){
            case KeyEvent.VK_UP:
                State_UP=true;
                break;
            case KeyEvent.VK_DOWN:
                State_DOWN = true;
                break;
            case KeyEvent.VK_LEFT:
                State_LEFT=true;
                break;
            case KeyEvent.VK_RIGHT:
                State_RIGHT=true;
                break;
            case KeyEvent.VK_SPACE:
                space = true;
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
            case KeyEvent.VK_SPACE:
                space = false;
                break;
            default:
                break;
        }
    }
}
