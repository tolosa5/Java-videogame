//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Main;

import Inputs.KeyboardInputs;
import Inputs.MouseInputs;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
    private Game game;

    public GamePanel(Game game)
    {
        this.game = game;
        addKeyListener(new KeyboardInputs());
        addMouseListener(new MouseInputs());
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.fillRect(100, 100, 200, 50);
    }

    public Game getGame() {
        return game;
    }
}
