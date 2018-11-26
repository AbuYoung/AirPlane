package com.abu.plane;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Bullet extends JPanel {

	private int local_x;
	int local_y;

	Bullet(int a, int b){
		local_x = a;
		local_y = b;
	}

	//获取子弹素材
	private static BufferedImage BulletPic;
	static {
		try {
			BulletPic = ImageIO.read(Bullet.class.getResource("/img/Bullet.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void paint(Graphics g) {
		System.out.println("1");
		g.drawImage(BulletPic,local_x,local_y,null);
		local_y--;
	}
}
