package entities;

import components.ColliderComponent;

public abstract class Entity
{
    protected float x, y;
    protected int width, height;
    public ColliderComponent collider;

    public Entity(float x, float y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        initComponents();
    }

    protected void initComponents()
    {
        this.collider = new ColliderComponent(x, y, width, height);
    }
}
