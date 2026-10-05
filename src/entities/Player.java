package entities;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static utils.Constants.PlayerConstants.*;
import static utils.Constants.Directions.*;

public class Player extends Entity
{
    private int health;
    private int speed;

    private boolean isMoving;
    private BufferedImage[][] animations;
    private int aniTick, aniIndex, aniSpeed = 15;
    private int playerDirection = -1;
    private int playerAction = LEFT_WALK;
    private boolean left, up, right, down;

    public Player(float x, float y, int health, int speed)
    {
        super(x, y);
        this.health = health;
        this.speed = speed;

        loadAnimations();
    }

    public void update()
    {
        move();
        updateAnimation();
        setAnimation();
    }

    public void render(Graphics g)
    {
        g.drawImage(animations[playerAction][aniIndex], (int)x, (int)y, 128, 128, null);
    }

    private void loadAnimations()
    {
        InputStream is = getClass().getResourceAsStream("/images/playerSprite.png");

        try {
            BufferedImage image = ImageIO.read(is);
            animations = new BufferedImage[4][4];
            for (int i = 0; i < animations.length; i++)
            {
                for (int j = 0; j < animations[i].length; j++)
                {
                    animations[i][j] = image.getSubimage(j * 64, i * 64, 64, 64);
                }
            }
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

    private void setAnimation()
    {
        playerAction = LEFT_WALK;
    }

    public void move()
    {
        isMoving = false;

        if (left && !right)
        {
            x -= speed;
            isMoving = true;
        }
        else if (right && !left)
        {
            x += speed;
            isMoving = true;
        }

        if (up && !down)
        {
            y -= speed;
            isMoving = true;
        }
        else if (down && !up)
        {
            y += speed;
            isMoving = true;
        }
    }

    private void updateAnimation()
    {
        aniTick++;
        if (aniTick >= aniSpeed)
        {
            aniTick = 0;
            aniIndex++;
            if (aniIndex >= GetSpriteAmount(playerAction))
                aniIndex = 0;
        }
    }

    public int getHealth() { return health; }
    public void setHealth(int health) { this.health = health; }

    public int getSpeed() { return speed; }
    public void setSpeed(int speed) { this.speed = speed; }

    public void setLeft(boolean left) { this.left = left; }
    public void setUp(boolean up) { this.up = up; }
    public void setRight(boolean right) { this.right = right; }
    public void setDown(boolean down) { this.down = down; }
}
