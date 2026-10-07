package components;

import utils.LoadSave;

import java.awt.image.BufferedImage;

import static utils.Constants.PlayerConstants.GetSpriteAmount;
import static utils.Constants.PlayerConstants.LEFT_WALK;

public class AnimatorComponent
{
    private BufferedImage[][] animations;
    private int animTick, animIndex, aniSpeed = 15;
    private int playerDirection = -1;
    private int playerAction = LEFT_WALK;
    private boolean isAttacking;

    public AnimatorComponent()
    {

    }

    public void loadAnimations()
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

    public void renderAnimation(float x, float y, int width, int height, java.awt.Graphics g)
    {
        g.drawImage(animations[playerAction][animIndex], (int)x, (int)y, width, height, null);
    }

    public void setAnimation()
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

    public void resetAnim()
    {
        animTick = 0;
        animIndex = 0;
    }

    public void updateAnimation()
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
}
