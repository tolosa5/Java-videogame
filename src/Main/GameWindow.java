//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Main;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import javax.swing.JFrame;

public class GameWindow extends JFrame {
    JFrame jFrame = new JFrame();

    public GameWindow(final GamePanel gamePanel)
    {
        this.jFrame.setSize(800, 600);
        this.jFrame.setDefaultCloseOperation(3);
        this.jFrame.add(gamePanel);
        this.jFrame.setVisible(true);
        this.jFrame.addWindowFocusListener(new WindowFocusListener() {
            public void windowGainedFocus(WindowEvent e)
            {
            }

            public void windowLostFocus(WindowEvent e) {
                gamePanel.getGame().windowFocusLost();
            }
        });
    }
}
