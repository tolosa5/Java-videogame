package entities;

import utils.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

import static utils.Constants.PlayerConstants.*;

public class Player extends Entity
{
    private int health;
    private int speed;

    private boolean isMoving;
    private boolean isAttacking;
    private BufferedImage[][] animations;
    private int animTick, animIndex, aniSpeed = 15;
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
        g.drawImage(animations[playerAction][animIndex], (int)x, (int)y, 128, 128, null);
    }

    private void loadAnimations()
    {
        BufferedImage image = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_ATLAS);

        animations = new BufferedImage[4][4];
        for (int i = 0; i < animations.length; i++)
        {
            for (int j = 0; j < animations[i].length; j++)
            {
                animations[i][j] = image.getSubimage(j * 64, i * 64, 64, 64);
            }
        }
    }

    private void setAnimation()
    {
        int startAnim = playerDirection;

        playerAction = LEFT_WALK;
        if (isAttacking)
        {
            //playerAction = ATTACK;
        }

        if (startAnim == playerAction)
        {
            resetAnim();
        }
    }

    private void resetAnim()
    {
        animTick = 0;
        animIndex = 0;
    }

    private void updateAnimation()
    {
        animTick++;
        if (animTick >= aniSpeed)
        {
            animTick = 0;
            animIndex++;
            if (animIndex >= GetSpriteAmount(playerAction))
            {
                isAttacking = false;
                animIndex = 0;

            }
        }
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

    private void setAttack()
    {
        isAttacking = true;
    }

    public void resetDirBooleans()
    {
        left = false;
        up = false;
        right = false;
        down = false;
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
