package com.abu.plane;

import javax.swing.*;

public class PlaneGame extends JPanel {

    private static JFrame mainFrame = new JFrame("Plane War Game");
    private static PlaneGame GAME = new PlaneGame();

    static int STATE;
    static int GAME_STATE;

    public static void main(String[] args){

        PrepareGUI();
        STATE = 1;
        GAME_STATE = Constant.GAME_TITLE;

        while(STATE < 3){
            switch (GAME_STATE){
                case Constant.GAME_TITLE:
                    GAME.Title();
                    GAME_STATE = Constant.GAME_START;
                    break;
                case Constant.GAME_START:
                    GAME.Game();
                    break;
                default:
                    break;
            }
        }
    }

    private static void PrepareGUI(){
        mainFrame.setVisible(true);
        mainFrame.setSize(Constant.WINDOW_WIDTH, Constant.WINDOW_HEIGHT);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);
    }

    private void Title() {
        Title titleFrame = new Title();
        titleFrame.setBounds(0,0, Constant.WINDOW_WIDTH, Constant.WINDOW_HEIGHT);
        mainFrame.addKeyListener(titleFrame);
        mainFrame.add(titleFrame);
        while (STATE == 1) {
            SwingUtilities.updateComponentTreeUI(mainFrame);
            titleFrame.repaint();
        }
        mainFrame.remove(titleFrame);
        mainFrame.removeKeyListener(titleFrame);
    }


    private void Game(){
        Game newGame = new Game();
        mainFrame.add(newGame);
        mainFrame.addKeyListener(newGame);
        newGame.setBounds(0,0, Constant.WINDOW_WIDTH, Constant.WINDOW_HEIGHT);

        while (STATE == 2) {
            SwingUtilities.updateComponentTreeUI(mainFrame);
            newGame.repaint();
            newGame.paintEnemy();//BUG 在这里
        }

        mainFrame.remove(newGame);
        mainFrame.removeKeyListener(newGame);
    }

}