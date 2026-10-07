package Main;

import entities.Player;
import levels.LevelManager;

import java.awt.Graphics;
import static utils.Constants.GameConstants.*;

public class Game implements Runnable {
    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private Player player;
    private LevelManager levelManager;
    private Thread gameThread;

    private final int FPS_SET = 120;
    private final int UPS_SET = 120;

    public Game()
    {
        initClasses();
        gamePanel.requestFocus();

        //------------------------------------------
        startGameLoop();
    }

    private void initClasses()
    {
        gamePanel = new GamePanel(this);

        player = new Player(100, 100, 32, 32, 100, 5);
        levelManager = new LevelManager(this);

        //------------------------------------------
        gameWindow = new GameWindow(this.gamePanel);
    }

    private void startGameLoop()
    {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void update()
    {
        gamePanel.updateGame();
        player.update();
        levelManager.update();
    }

    public void render(Graphics g)
    {
        gamePanel.repaint();
        player.render(g);
        levelManager.draw(g);
    }

    public void windowFocusLost()
    {
        player.resetDirBooleans();
    }

    public void run()
    {
        double timePerFrame = 1000000000.0 / FPS_SET;
        double timePerUpdate = 1000000000.0 / UPS_SET;
        long lastFrame = System.nanoTime();

        int frames = 0;
        int updates = 0;
        long lastCheck = System.currentTimeMillis();

        double deltaU = 0;
        double deltaF = 0;

        while (true)
        {
            long currentTime = System.nanoTime();

            deltaU += (currentTime - lastFrame) / timePerUpdate;
            deltaF += (currentTime - lastFrame) / timePerFrame;
            lastFrame = currentTime;

            if (deltaU >= 1)
            {
                update();
                updates++;
                deltaU--;
            }

            if (deltaF >= 1)
            {
                frames++;
                deltaF--;
            }

            if (System.currentTimeMillis() - lastCheck >= 1000)
            {
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames + " | UPS: " + updates);
                frames = 0;
                updates = 0;
            }
        }
    }

    public Player getPlayer() { return player; }
}