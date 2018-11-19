import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class PlaneGame extends JPanel {

    private static JFrame mainFrame = new JFrame("Plane War Game");
    private static JPanel gameFrame = new JPanel();
    private static Title titleFrame = new Title();

    private static void PrepareGUI(){
        mainFrame.setVisible(true);
        mainFrame.setSize(Constant.WINDOW_WIDTH,Constant.WINDOW_HEIGHT);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);

        mainFrame.add(titleFrame);
        titleFrame.setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        PrepareGUI();
        while(true){
            titleFrame.repaint();
        }

    }

    public static void gameFrame(){
        gameFrame.setVisible(true);
        mainFrame.add(gameFrame);
    }

    @Override
    public void paint(Graphics g) {
        titleFrame.paint(g);
    }
}
