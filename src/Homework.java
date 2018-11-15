import javax.swing.*;
import java.awt.*;

public class Homework {

    private static JFrame mainFrame = new JFrame("Homework");
    private static Drawing Draw = new Drawing();

    private static void ShowGui(){
        mainFrame.setSize(400,600);
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.add(Draw);
        Draw.setBackground(Color.WHITE);
        Draw.repaint();
    }

    public static void main(String[] args) {
        while(true){
            ShowGui();
        }
    }

}
