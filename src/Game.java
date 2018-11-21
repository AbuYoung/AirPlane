import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class Game extends JPanel implements KeyListener {

    private Hero newHero = new Hero();
    //private Enemy newEnemy = new Enemy();

    private int x=100;
    private int y=200;

    public void paint(Graphics g) {
            movePic();
            g.drawImage(Hero.HeroPic,x,y,null);
            g.drawImage(Enemy.EnemyPic,0,0,null);
    }

    private boolean State_UP;
    private boolean State_DOWN;
    private boolean State_LEFT;
    private boolean State_RIGHT;

    private void movePic() {
        if (State_UP && y > 0)
            y = y - newHero.Speed;
        if(State_DOWN && y < 470)
            y = y + newHero.Speed;
        if(State_LEFT && x > 0)
            x = x - newHero.Speed;
        if(State_RIGHT && x < 320)
            x = x + newHero.Speed;
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
