package jm.spaceadventureproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        // 상단 타이틀바 없애기
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        // 게임뷰 만들기
        GameView gameView = new GameView(this);
        setContentView(gameView);
    }
}
