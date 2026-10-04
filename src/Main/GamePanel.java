//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Main;

import Inputs.KeyboardInputs;
import Inputs.MouseInputs;

import java.awt.*;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
    private Game game;
    private MouseInputs mouseInputs;
    private int xDelta = 100, yDelta = 100;

    public GamePanel(Game game)
    {
        this.game = game;
        mouseInputs = new MouseInputs(this);

        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
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
        g.fillRect(xDelta, yDelta, 200, 50);
    }

    public Game getGame() { return game; }
}
