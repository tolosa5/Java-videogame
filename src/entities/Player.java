package entities;

import components.AnimatorComponent;
import utils.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

import static utils.Constants.PlayerConstants.*;

public class Player extends Entity
{
    public AnimatorComponent animator;
    private int health;
    private int speed;

    private boolean isMoving;
    private int playerAction = LEFT_WALK;
    private boolean left, up, right, down;

    public Player(float x, float y, int width, int height, int health, int speed)
    {
        super(x, y, width, height);
        this.health = health;
        this.speed = speed;

        initComponents();
        animator.loadAnimations();
    }

    @Override
    protected void initComponents()
    {
        super.initComponents();
        this.animator = new AnimatorComponent();
    }

    public void update()
    {
        move();
        collider.updateHitbox(x, y);
        animator.updateAnimation();
        animator.setAnimation();
    }

    public void render(Graphics g)
    {
        animator.renderAnimation(x, y, width, height, g);
        //debug
        collider.drawHitbox(g);
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
