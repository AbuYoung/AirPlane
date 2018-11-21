import javax.swing.*;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

public class PlaneGame extends JPanel {

    private static JFrame mainFrame = new JFrame("Plane War Game");
    private static Title titleFrame = new Title();
    private static Game newGame = new Game();

    static int STATE;
    static int GAME_STATE;

    public static void main(String[] args) throws IOException {
        PrepareGUI();
        STATE = 1;
        GAME_STATE = Constant.GAME_TITLE;
        while(true){
            switch (GAME_STATE){
                case Constant.GAME_TITLE:
                    Title();
                    System.out.println("3");
                    mainFrame.remove(titleFrame);
                    GAME_STATE = Constant.GAME_START;
                    break;
                case Constant.GAME_START:
                    Game();
                    break;
                case 3:

            }
        }
    }

    private static void PrepareGUI(){
        mainFrame.setVisible(true);
        mainFrame.setSize(Constant.WINDOW_WIDTH,Constant.WINDOW_HEIGHT);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);
    }

    private static void Title() {
        mainFrame.addKeyListener(titleFrame);
        mainFrame.add(titleFrame);
        while (STATE == 1){
            titleFrame.repaint();
            System.out.println("2+ "+ STATE);
            if (STATE == 2)
                break;
        }
    }

    private static void Game(){
        mainFrame.add(newGame);
        mainFrame.addKeyListener(newGame);
        newGame.setVisible(true);
    }

}
