package jm.spaceadventureproject;

import android.graphics.Paint;

/**
 * Created by dd on 2017-06-03.
 */

public class StaticDisplay extends Entity {

    private String stringToDisplay;
    private int intToDisplay;
    private int stringColor;
    private int txtSize;
    private Paint.Align txtAlign;

    public StaticDisplay() {
        super(255);
    }

    public String getStringToDisplay() {
        return stringToDisplay;
    }

    public void setStringToDisplay(String stringToDisplay) {
        this.stringToDisplay = stringToDisplay;
    }

    public int getIntToDisplay() {
        return intToDisplay;
    }

    public void setIntToDisplay(int intToDisplay) {
        this.intToDisplay = intToDisplay;
    }

    public int getStringColor() {
        return stringColor;
    }

    public void setStringColor(int stringColor) {
        this.stringColor = stringColor;
    }

    public int getTxtSize() {
        return txtSize;
    }

    public void setTxtSize(int txtSize) {
        this.txtSize = txtSize;
    }

    public Paint.Align getTxtAlign() {
        return txtAlign;
    }

    public void setTxtAlign(Paint.Align txtAlign) {
        this.txtAlign = txtAlign;
    }
}
