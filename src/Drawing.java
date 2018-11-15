import javax.swing.*;
import java.awt.*;
import java.util.Random;

class Drawing extends JPanel{

    //private static JPanel newPanel = new JPanel();
    //private static JLabel TextLable = new JLabel("Hello World");

    private static Random ran = new Random();

    @Override
    public void paint(Graphics g) {
        int x = ran.nextInt(400);
        int y = ran.nextInt(600);
        super.paint(g);
        g.drawRect(x,y,20,20);
        g.drawRect(x/2,y/2,20,20);

    }

}
