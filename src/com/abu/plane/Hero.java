package com.abu.plane;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

class Hero {

    int Speed = 5;

    static BufferedImage HeroPic;

    static {
        try {
            HeroPic = ImageIO.read(Hero.class.getResource("/img/Hero.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
