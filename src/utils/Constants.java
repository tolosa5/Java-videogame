package utils;

public class Constants
{
    public static class Directions
    {
        public static final int LEFT = 0;
        public static final int UP = 1;
        public static final int RIGHT = 2;
        public static final int DOWN = 3;
    }

    public static class PlayerConstants
    {
        public static final int PLAYER_WIDTH_DEFAULT = 64;
        public static final int PLAYER_HEIGHT_DEFAULT = 64;
        public static final float SCALE = 1.5F;
        public static final int PLAYER_WIDTH = (int)(PLAYER_WIDTH_DEFAULT * SCALE);
        public static final int PLAYER_HEIGHT = (int)(PLAYER_HEIGHT_DEFAULT * SCALE);

        public static final int UP_WALK = 0;
        public static final int LEFT_WALK = 1;
        public static final int RIGHT_WALK = 2;
        public static final int DOWN_WALK = 3;

        public static int GetSpriteAmount(int player_action)
        {
            switch(player_action)
            {
                case UP_WALK:
                    return 4;
                case LEFT_WALK:
                    return 4;
                case RIGHT_WALK:
                    return 4;
                case DOWN_WALK:
                    return 4;
                default:
                    return 1;
            }
        }
    }

    public static class GameConstants
    {
        public static final int TILES_DEFAULT_SIZE = 32;
        public static final float SCALE = 1.0F;
        public static final int TILES_IN_WIDTH = 40;
        public static final int TILES_IN_HEIGHT = 25;
        public static final int TILES_SIZE = (int)(TILES_DEFAULT_SIZE * SCALE);
        public static final int GAME_WIDTH = TILES_SIZE * TILES_IN_WIDTH;
        public static final int GAME_HEIGHT = TILES_SIZE * TILES_IN_HEIGHT;

        public static final int TILES_NUMBER = 48;
        public static final int TILES_ROWS = 4;
        public static final int TILES_COLUMNS = 12;
    }
}
