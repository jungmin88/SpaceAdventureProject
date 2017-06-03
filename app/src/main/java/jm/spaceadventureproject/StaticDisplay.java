package jm.spaceadventureproject;

import android.graphics.Point;

/**
 * Created by dd on 2017-06-03.
 */

public class StaticDisplay extends Entity {
    
    private Point displayPosition;
    private int displayContents;
    
    public StaticDisplay() {
        super(255);
    }

    public int getDisplayContents() {
        return displayContents;
    }

    public void setDisplayContents(int displayContents) {
        this.displayContents = displayContents;
    }

    public Point getDisplayPosition() {
        return displayPosition;
    }

    public void setDisplayPosition(Point displayPosition) {
        this.displayPosition = displayPosition;
    }
}
