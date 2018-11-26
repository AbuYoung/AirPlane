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
    private ArrayList<Enemy> Enemy_S = new ArrayList<>();
    private ArrayList<Bullet> GenBullet = new ArrayList<>();

    Game(){
        for(int i = 0; i < 5; i++)
            Enemy_S.add(new Enemy((int)(Math.random()*300),
                    (int)(Math.random()*(-1)*100)));
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

        for (int i = 0; i < 5; i++) {
            if (Enemy_S.get(i).local_y > 600) {
                Enemy_S.get(i).local_y = (int) (Math.random() * (-1) * 350);
            } else {
                this.Enemy_S.get(i).paint(g);
            }
        }

        for (int i = 0; i < GenBullet.size(); i++) {
            GenBullet.get(i).paint(g);
            for (int j = 0; j < 5; j++){
                if (HitEffort(this.GenBullet.get(i).local_x,
                        this.GenBullet.get(i).local_y,
                        this.Enemy_S.get(j).local_x,
                        this.Enemy_S.get(j).local_y)){
                    Enemy_S.get(j).local_y = (int) (Math.random() * (-1) * 350);
                }
            }
        }
        Dead();
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
                this.GenBullet.add(new Bullet(Hero_X,Hero_Y));
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

    private boolean HitEffort(int Bullet_x, int Bullet_y, int Enemy_x, int Enemy_y){
        boolean X = (Bullet_x >= Enemy_x && Bullet_x <= Enemy_x + 80);
        boolean Y = (Bullet_y >= Enemy_y && Bullet_y <= Enemy_y + 130);
        return X&&Y;
    }

    private void Dead() {
        for (int i = 0; i < 5; i++) {
            boolean X, Y;
            X = (Hero_X >= this.Enemy_S.get(i).local_x && Hero_X <= this.Enemy_S.get(i).local_x + 80);
            Y = (Hero_Y >= this.Enemy_S.get(i).local_y && Hero_Y <= this.Enemy_S.get(i).local_y + 130);
            if (X && Y) {
                PlaneGame.STATE = 3;
                PlaneGame.GAME_STATE = Constant.GAME_DEAD;
            }
        }
    }

}
