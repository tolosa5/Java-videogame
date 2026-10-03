//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Main;

import java.awt.Graphics;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
    private Game game;

    public GamePanel(Game game)
    {
        this.game = game;
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawRect(100, 100, 200, 50);
    }

    public Game getGame() {
        return this.game;
    }
}
