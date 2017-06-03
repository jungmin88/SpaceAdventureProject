package jm.spaceadventureproject;

import android.content.Context;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by jm on 2017-06-01.
 */

public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    // 스레드를 만들기 위해 객체 생성
    private GameThread gameThread = null;

    public GameView(Context context){
        super(context);

        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        // 스레드 생성
        gameThread = new GameThread(holder, getResources());
        // 스레드 시작
        gameThread.on();
    }

    // 화면이 만들어 지는 순간
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        // 크기 변경
        gameThread.onSizeChanged(width, height);
    }

    // 화면이 없어질때
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        // 스레드 정지
        gameThread.off();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int)event.getX();
        int y = (int)event.getY();

        // 우주선을 움직여라
        gameThread.moveSpaceship(x);

        return true;
    }
}
