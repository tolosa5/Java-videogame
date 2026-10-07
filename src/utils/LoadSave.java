package utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class LoadSave
{
    public static final String PLAYER_ATLAS = "/images/playerSprite.png";
    public static final String LEVEL_ATLAS = "/images/levelSprites.png";
    public static BufferedImage GetSpriteAtlas(String path)
    {
        BufferedImage image = null;
        InputStream is = LoadSave.class.getResourceAsStream(path);

        try {
            image = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return image;
    }
}
