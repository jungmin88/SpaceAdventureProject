package jm.spaceadventureproject;

import android.content.res.Resources;
import android.graphics.Rect;

import static android.R.attr.x;

/**
 * Created by jm on 2017-06-02.
 */

class Meteor extends Entity {

    private final Resources resources;
    private int life = 1;
    public Meteor(int life, Resources resources) {
        super(255);

        this.life = life;
        this.resources = resources;
    }

    public void move(int y){
        setPosition(x-getSize().y/2, getPosition().y);
    }

    // 충돌처리
    public boolean isCollision(Rect rect){
        // 내 영역과 비교해서 충돌인지 판단한다.
        if(Rect.intersects(getRect(), rect)){
            return true;
        }
        return false;
    }

    // 충돌시 감소
    public boolean hit(){
        if(life == 0){
            return true;
        }
        life--;
        return false;
    }

    public boolean isBroken(){
        return life == 0;
    }

    public boolean isCollideTopBottom(Meteor meteor, Rect nextArea){
        // 만약 메테오가 충돌되어 생명력이 0이라면
        if(meteor.isBroken()){
            return false;
        }

        Rect rect = meteor.getRect();

        Rect subRect = new Rect(
                rect.left+1,
                rect.top,
                rect.right-1,
                rect.bottom
        );
        return Rect.intersects(subRect, nextArea);
    }
}
