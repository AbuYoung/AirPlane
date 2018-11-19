import javax.swing.*;
import java.io.IOException;

public class PlaneGame extends JPanel {

    private static JFrame mainFrame = new JFrame("Plane War Game");
    private static JPanel gameFrame = new JPanel();

    public static void main(String[] args) throws IOException {
        mainFrame.setVisible(true);
        mainFrame.setSize(Constant.WINDOW_WIDTH,Constant.WINDOW_HEIGHT);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);
    }

    public static void gameFrame(){
        gameFrame.setVisible(true);
        mainFrame.add(gameFrame);
    }

}
