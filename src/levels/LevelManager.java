package levels;

import Main.Game;
import utils.Constants;
import utils.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

public class LevelManager
{
    Game game;
    private BufferedImage[] levelSprites;

    public LevelManager(Game game)
    {
        this.game = game;

        importOutsideSprites();
    }

    private void importOutsideSprites()
    {
        levelSprites = new BufferedImage[Constants.GameConstants.TILES_NUMBER];
        for (int i = 0; i < Constants.GameConstants.TILES_ROWS; i++)
        {
            for (int j = 0; j < Constants.GameConstants.TILES_COLUMNS; j++)
            {
                int index = j * Constants.GameConstants.TILES_COLUMNS + i;
                levelSprites[index] = LoadSave.GetSpriteAtlas(LoadSave.LEVEL_ATLAS).getSubimage
                        (j * Constants.GameConstants.TILES_SIZE, i * Constants.GameConstants.
                                TILES_SIZE, Constants.GameConstants.TILES_SIZE, Constants.GameConstants.TILES_SIZE);
            }
        }
    }

    public void draw(Graphics g)
    {
        g.drawImage(levelSprites[0], 0, 0, 1280, 720, null);
    }

    public void update()
    {
        // Update level logic here
    }
}
