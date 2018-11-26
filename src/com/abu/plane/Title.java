package com.abu.plane;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

class Title extends JPanel implements KeyListener {

    private static BufferedImage BeginPic;
    static {
        try {
            BeginPic = ImageIO.read(Title.class.getResource("/img/Title.png"));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g){
        g.drawImage(BeginPic,0,0,null);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            PlaneGame.GAME_STATE = Constant.GAME_START;
            PlaneGame.STATE = 2;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
