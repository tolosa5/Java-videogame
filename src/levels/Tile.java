package levels;

import java.awt.image.BufferedImage;

public class Tile
{
    public enum TileType
    {
        GRASS, WATER, DIRT, STONE, SAND
    }

    private BufferedImage sprite;
    private TileType tileType;
    private boolean isSolid;

    public Tile(BufferedImage sprite, TileType type, boolean isSolid)
    {
        this.sprite = sprite;
        this.tileType = type;
        this.isSolid = isSolid;
    }

    public boolean isSolid()
    {
        return isSolid;
    }

    public BufferedImage getSprite()
    {
        return sprite;
    }

    public TileType getTileType()
    {
        return tileType;
    }
}
