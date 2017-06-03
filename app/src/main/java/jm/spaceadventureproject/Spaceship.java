package jm.spaceadventureproject;

import android.content.res.Resources;
import android.graphics.Rect;

/**
 * Created by jm on 2017-06-02.
 */

public class Spaceship extends Entity {

    private final Resources resources;
    private int life = 3;
    public Spaceship(int life, Resources resources) {
        super(255);

        this.life = life;
        this.resources = resources;
    }

    public void move(int x){
        setPosition(x-getSize().x/2, getPosition().y);
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
}
