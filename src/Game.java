import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game implements KeyListener {

    private boolean State_UP;
    private boolean State_DOWN;
    private boolean State_LEFT;
    private boolean State_RIGHT;

    private void move() {
        if (State_UP && y != 0)
            y--;
        if(State_DOWN && y <= 1347)
            y++;
        if(State_LEFT && x != 0)
            x--;
        if(State_RIGHT && x <= 644)
            x++;
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
