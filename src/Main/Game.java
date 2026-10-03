package Main;

import java.awt.Graphics;

public class Game implements Runnable {
    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private Thread gameThread;
    private final int FPS_SET = 120;
    private final int UPS_SET = 120;
    public static final int TILES_DEFAULT_SIZE = 32;
    public static final float SCALE = 1.5F;
    public static final int TILES_IN_WIDTH = 26;
    public static final int TILES_IN_HEIGHT = 14;
    public static final int TILES_SIZE = 48;
    public static final int GAME_WIDTH = 1248;
    public static final int GAME_HEIGHT = 672;

    public Game()
    {
        initClasses();
        gamePanel = new GamePanel(this);
        gameWindow = new GameWindow(this.gamePanel);
        gamePanel.requestFocus();
        startGameLoop();
    }

    private void initClasses()
    {
    }

    private void startGameLoop()
    {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void update()
    {
    }

    public void render(Graphics g)
    {
    }

    public void windowFocusLost()
    {
    }

    public void run()
    {
    }
}