package utils;

public class Helper
{
    public static boolean CanMove(int x, int y, int width, int height, int[][] levelData)
    {
        if (!IsSolid(x, y, levelData))
            if (!IsSolid(x + width, y + height, levelData))
                if (!IsSolid(x + width, y, levelData))
                    if (!IsSolid(x, y + height, levelData))
                        return true;
        return false;
    }

    public static boolean IsSolid(int x, int y, int[][] levelData)
    {
        int maxWidth = levelData[0].length * 32;
        int maxHeight = levelData.length * 32;

        if (x < 0 || x >= maxWidth)
            return true;
        if (y < 0 || y >= maxHeight)
            return true;

        float xIndex = x / Constants.GameConstants.TILES_SIZE;
        float yIndex = y / Constants.GameConstants.TILES_SIZE;

        return levelData[(int)yIndex][(int)xIndex] != 0;
    }
}
