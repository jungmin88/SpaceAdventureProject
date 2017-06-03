package jm.spaceadventureproject;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

import static jm.spaceadventureproject.R.drawable.life;

/**
 * Created by jm on 2017-06-02.
 */

class GameTable {

    public int meteorAmount = 0;
    private final Resources resources;
    private final Rect rectFrame;

    // 좌표 y, x(x,y 아님)
    private Meteor[] meteorArray;

    public GameTable(Resources resources, Rect rectFrame){
        this.resources = resources;
        this.rectFrame = rectFrame;
    }

    public void setLevel1(){
        meteorAmount = 5;
        meteorArray = new Meteor[meteorAmount];
        clear(meteorAmount);

        for(int i=0; i<meteorAmount; i++){
            addMeteor(i, Random.get(0,5) ,life);
        }
    }

    public void clear(int Amount){
        for(int i=0; i<Amount; i++){
            meteorArray[i] = null;
        }
    }

    private void addMeteor(int i,int indexX, int life){
        Meteor meteor = new Meteor(life, resources);

        // 크기(부피)
        int widthFrame = rectFrame.width();
        int heightFrame = rectFrame.height();
        int widthMeteor = widthFrame/10;
        int heightMeteor = heightFrame/5;
        meteor.setSize(widthMeteor, heightMeteor);

        // 위치
        int positionX = indexX*widthMeteor;
        int positionY = (int)(heightMeteor*0.1);
        meteor.setPosition(positionX, positionY);
        meteor.setImage(
                BitmapFactory.decodeResource(
                        resources,
                        R.drawable.meteor
                ));

        // 배열에 저장
        meteorArray[i] = meteor;
    }

    public void draw(Canvas canvas){
        for(int i=0; i<meteorAmount; i++){
            if(meteorArray[i] != null && !meteorArray[i].isBroken()){
                meteorArray[i].draw(canvas);
            }
        }
    }
}
