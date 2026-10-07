package levels;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class TileManager
{
    public Tile createdTile;
    public BufferedImage tileSheet;
    private ArrayList<Tile> tiles = new ArrayList<>();

    public TileManager(int id)
    {
        loadAtlas();
        createTiles();
    }

    private void loadAtlas()
    {
        // Load the tile atlas image
    }

    private void createTiles()
    {
        tiles.add(new Tile(getSprite(0, 0), Tile.TileType.GRASS, false));
        tiles.add(new Tile(getSprite(0, 1), Tile.TileType.WATER, true));
        tiles.add(new Tile(getSprite(0, 2), Tile.TileType.DIRT, false));
        tiles.add(new Tile(getSprite(0, 3), Tile.TileType.STONE, true));
        tiles.add(new Tile(getSprite(0, 4), Tile.TileType.SAND, false));
    }

    public BufferedImage getSpriteById(int id)
    {
        if (id >= 0 && id < tiles.size())
            return tiles.get(id).getSprite();

        return null; // Return null if the ID is out of bounds
    }

    private BufferedImage getSprite(int x, int y)
    {
        return tileSheet.getSubimage(x * 32, y * 32, 32, 32);
    }
}
