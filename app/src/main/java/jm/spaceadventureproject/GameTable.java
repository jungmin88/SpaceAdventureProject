package jm.spaceadventureproject;

import android.content.res.Resources;
import android.graphics.Rect;

/**
 * Created by jm on 2017-06-02.
 */

class GameTable {

    public static final int SIZE_Y = 10;
    public static final int SIZE_X = 5;
    private final Resources resources;
    private final Rect rectFrame;

    public GameTable(Resources resources, Rect rectFrame){
        this.resources = resources;
        this.rectFrame = rectFrame;
    }

    private void addSpaceship(int indexY, int indexX, int life){
        Spaceship spaceship = new Spaceship(life, resources);

        int widthFrame = rectFrame.width();
        int heightFrame = rectFrame.height();
        int widthSpaceship = widthFrame/10;
        int heightSpaceship = heightFrame/5;
        spaceship.setSize(widthSpaceship, heightSpaceship);

        int positionX = indexX*widthSpaceship;
        int positionY = indexY*heightSpaceship;
        spaceship.setPosition(positionX, positionY);
    }

}
