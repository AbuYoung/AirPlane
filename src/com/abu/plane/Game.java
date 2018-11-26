package com.abu.plane;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ConcurrentNavigableMap;

import static java.lang.Thread.sleep;

class Game extends JPanel implements KeyListener {

    private ArrayList<Enemy> Enemy_S = new ArrayList<>();

    Game (){
        for (int i = 0;i < 20; i++)
            Enemy_S.add(new Enemy((int)(Math.random() * Constant.WINDOW_WIDTH), (int)(Math.random()*(-1)*Constant.WINDOW_WIDTH)));
    }

    private Hero newHero = new Hero();

    private int x = 100;
    private int y = 200;

    private int BGx = 0, BGy = 0;

    @Override
    public void paint(Graphics g) {
        try {
            movePic();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        g.drawImage(BackgroundPic_0, BGx, BGy, null);
        g.drawImage(BackgroundPic_1, BGx, BGy - 600, null);
        g.drawImage(Hero.HeroPic, x, y, null);
        for(int i =0 ;i < 20; i++) {
            this.Enemy_S.get(i).paint(g);
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

    private void movePic() throws InterruptedException {
        //主角飞机的控制
        if (State_UP && y > 0)
            y = y - newHero.Speed;
        if(State_DOWN && y < 470)
            y = y + newHero.Speed;
        if(State_LEFT && x > 0)
            x = x - newHero.Speed;
        if(State_RIGHT && x < 320)
            x = x + newHero.Speed;
        //背景滚动
        if(BGy == 600) {
            BGy = 0;BGx = 0;
        } else {
            BGy += 3;
        }
        //延时控制
        sleep(10);
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
