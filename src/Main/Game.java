package Main;

import entities.Player;

import java.awt.Graphics;

public class Game implements Runnable {
    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private Player player;
    private Thread gameThread;
    private final int FPS_SET = 120;
    private final int UPS_SET = 120;
    public static final int TILES_DEFAULT_SIZE = 32;
    public static final float SCALE = 1.5F;
    public static final int TILES_IN_WIDTH = 40;
    public static final int TILES_IN_HEIGHT = 25;
    public static final int TILES_SIZE = 32;
    public static final int GAME_WIDTH = TILES_SIZE * TILES_IN_WIDTH;
    public static final int GAME_HEIGHT = TILES_SIZE * TILES_IN_HEIGHT;

    public Game()
    {
        initClasses();
        gamePanel.requestFocus();

        //------------------------------------------
        startGameLoop();
    }

    private void initClasses()
    {
        player = new Player(100, 100, 100, 10);
        gamePanel = new GamePanel(this);
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
    }

    public void render(Graphics g)
    {
        gamePanel.repaint();
        player.render(g);
    }

    public void windowFocusLost()
    {

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

            if(System.currentTimeMillis() - lastCheck >= 1000)
            {
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames + " | UPS: " + updates);
                frames = 0;
                updates = 0;
            }
        }
    }

    public Player getPlayer()
    {
        return player;
    }
}