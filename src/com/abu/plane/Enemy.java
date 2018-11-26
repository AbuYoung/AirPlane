package com.abu.plane;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

class Enemy extends JPanel {

    private int local_x, local_y;

    Enemy(int a,int b) {
        local_x = a;
        local_y = b;

    }

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
        local_y++;
    }

}
