import javax.swing.*;
import java.awt.*;

public class plane extends JPanel{

    private static JFrame mainFrame = new JFrame("Plane War");
    private static Background Sky = new Background();

    private static void PrepareGUI() {
        mainFrame.setSize(400,600);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        mainFrame.add(Sky);
        mainFrame.addKeyListener(Sky);//监听 Sky 对象的输入事件
        //mainFrame.remove(Sky);
    }

    @Override
    public void paint(Graphics g) {
        Sky.paint(g);
    }

    public static void main(String[] args) {
        PrepareGUI();
        while (true) {
            Sky.repaint();//绘制背景
        }
    }
}