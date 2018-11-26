package com.abu.plane;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

class Enemy extends JPanel {

    int local_x;
    int local_y;

    Enemy(int a, int b) {
        local_x = a;
        local_y = b;//敌人的坐标
    }

    //获取敌人的图片
    private static BufferedImage EnemyPic;
    static {
        try {
            EnemyPic = ImageIO.read(Enemy.class.getResource("/img/Enemy.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(EnemyPic, local_x, local_y, null);
        local_y+=2;
    }


}
