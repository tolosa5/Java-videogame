package components;

import java.awt.*;

public class ColliderComponent
{
    protected float x, y;
    protected int width, height;
    protected Rectangle hitbox;

    public ColliderComponent(float x, float y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.hitbox = new Rectangle((int)x, (int)y, width, height);
    }

    public void drawHitbox(Graphics g)
    {
        g.setColor(Color.RED);
        g.drawRect(hitbox.x, hitbox.y, hitbox.width, hitbox.height);
    }

    public void updateHitbox(float x, float y)
    {
        hitbox.x = (int)x;
        hitbox.y = (int)y;
    }

    public Rectangle getHitbox()
    {
        return hitbox;
    }
}
