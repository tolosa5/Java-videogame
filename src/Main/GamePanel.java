//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Main;

import Inputs.KeyboardInputs;
import Inputs.MouseInputs;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.*;

public class GamePanel extends JPanel {
    private Game game;
    private MouseInputs mouseInputs;
    private BufferedImage image;
    private BufferedImage subImage;
    private BufferedImage[] walkLeftAnimation;
    private int xDelta = 100, yDelta = 100;

    public GamePanel(Game game)
    {
        this.game = game;
        mouseInputs = new MouseInputs(this);

        importImg();
        loadAnimations();

        setPanelSize();
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    private void loadAnimations()
    {
        walkLeftAnimation = new BufferedImage[4];
        for (int i = 0; i < 4; i++)
        {
            walkLeftAnimation[i] = image.getSubimage(i * 64, 64, 64, 64);
        }

    }

    private void importImg()
    {
        InputStream is = getClass().getResourceAsStream("/images/playerSprite.png");

        try{
            image = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void setPanelSize()
    {
        Dimension size = new Dimension(1280, 800);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }

    public void changeXDelta(int xDelta)
    {
        this.xDelta += xDelta;
    }

    public void changeYDelta(int yDelta)
    {
        this.yDelta += yDelta;
    }

    public void setRectPos(int x, int y)
    {
        this.xDelta = x;
        this.yDelta = y;
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        subImage = image.getSubimage(0, 0, 64, 64);
        g.drawImage(subImage, (int)xDelta, (int)yDelta, 128, 128, null);
    }

    private void updateAnimation()
    {
        // Update the animation here
    }

    public Game getGame() { return game; }
}
