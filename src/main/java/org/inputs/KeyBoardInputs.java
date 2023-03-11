package org.inputs;

import org.main.Game;
import org.main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoardInputs implements KeyListener {

    private static int MOVE_PIXEL_VALUE = 5;
    private GamePanel gamePanel;
    public KeyBoardInputs(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_W:
                gamePanel.changeYDelta(-MOVE_PIXEL_VALUE);
                System.out.println("W");
                break;
            case KeyEvent.VK_A:
                gamePanel.changeXDelta(-MOVE_PIXEL_VALUE);
                System.out.println("A");
                break;
            case KeyEvent.VK_S:
                gamePanel.changeYDelta(MOVE_PIXEL_VALUE);
                System.out.println("S");
                break;
            case KeyEvent.VK_D:
                gamePanel.changeXDelta(MOVE_PIXEL_VALUE);
                System.out.println("D");
                break;
        }
    }
}
