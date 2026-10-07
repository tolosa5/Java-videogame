//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Main;

import Inputs.KeyboardInputs;
import Inputs.MouseInputs;

import java.awt.*;
import javax.swing.*;

import static utils.Constants.PlayerConstants.*;
import static utils.Constants.GameConstants.*;

public class GamePanel extends JPanel {
    private Game game;
    private MouseInputs mouseInputs;

    public GamePanel(Game game)
    {
        this.game = game;
        mouseInputs = new MouseInputs(this);

        setPanelSize();
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    private void setPanelSize()
    {
        Dimension size = new Dimension(GAME_WIDTH, GAME_HEIGHT);
        setPreferredSize(size);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        game.render(g);
    }

    public void updateGame()
    {
        // Update game logic here
    }

    public Game getGame() { return game; }
}
