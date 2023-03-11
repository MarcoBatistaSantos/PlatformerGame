package org.main;

import org.inputs.KeyBoardInputs;
import org.inputs.MouseInputs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class GamePanel extends JPanel {
    private MouseInputs mouseInputs;
    private float xDelta = 100, yDelta = 100;
    private BufferedImage bufferedImage;
    private BufferedImage subImage;
    private Random random;
    public GamePanel(){
        random = new Random();
        mouseInputs = new MouseInputs(this);

        importImage();

        setPanelSize();
        addKeyListener(new KeyBoardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    private void importImage(){
        InputStream is = getClass().getResourceAsStream("/player_sprites.png");

        try {
            bufferedImage = ImageIO.read(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void changeXDelta(int value){
        this.xDelta+=value;
    }

    public void changeYDelta(int value){
        this.yDelta+=value;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        subImage = bufferedImage.getSubimage(1*64, 8*40, 64, 40);
        g.drawImage(subImage,(int) xDelta, (int) yDelta, 128, 80, null);
    }

    private void setPanelSize(){
        Dimension dimensionSize = new Dimension(1280, 800);
        setMinimumSize(dimensionSize);
        setPreferredSize(dimensionSize);
        setMaximumSize(dimensionSize);
    }
}
