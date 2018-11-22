package com.abu.plane;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Enemy extends JPanel {

    private static BufferedImage EnemyPic;

    static {
        try {
            EnemyPic = ImageIO.read(Enemy.class.getResource("com/abu/plane/img/Enemy.png"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private Random genRanOfEnemy = new Random();

    //敌人生成
    //BUG 在这里
    public void paint(Graphics g){

        int numOfEnemy = genRanOfEnemy.nextInt(5);
        
        while(numOfEnemy != 0){
            numOfEnemy -= 1;
            int x_OfEnemy = genRanOfEnemy.nextInt(400);
            int y_OfEnemy = genRanOfEnemy.nextInt(300);
            g.drawImage(EnemyPic,x_OfEnemy,y_OfEnemy,null);
            System.out.println("1");
        }
    }
}
