package jm.spaceadventureproject;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.view.SurfaceHolder;

/**
 * Created by jm on 2017-06-01.
 */

class GameThread extends Thread {

    private final Resources resources;

    private boolean haveToStop = false; // 스레드 종료를 위한 변수
    private SurfaceHolder surfaceHolder = null;

    private Bitmap bitmap;

    private Spaceship spaceship;        // 우주선
//    private Entity obstacle1  = null;   // 장애물1
//    private Entity obstacle2  = null;   // 장애물2
//    private Entity ufo        = null;   // UFO
    private Entity background = null;   // 배경화면

    private Rect rectFrame = new Rect();// 바뀔때

    private GameTable gameTable = null;

    public GameThread(SurfaceHolder surfaceHolder, Resources resources){
        this.surfaceHolder = surfaceHolder;
        this.resources = resources;

        gameTable = new GameTable(resources, rectFrame);
//        gameTable.

        bitmap = BitmapFactory.decodeResource(resources, R.drawable.spaceship1);
        bitmap = removeColor(bitmap, Color.WHITE);  // 배경 투명하게

        spaceship = new Spaceship(3, resources);
        spaceship.setImage(bitmap);

        background = new Entity(255);
        background.setImage(resources, R.drawable.background1);
    }

    // 이미지 배경 투명하게 만들기
    private Bitmap removeColor(Bitmap bitmap, int color){
        // 이미지의 넓이와 폭을 받아 저장한다.
        int size = bitmap.getWidth()*bitmap.getHeight();
        int[] array = new int[size];
        bitmap.getPixels(array, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());

        // 이미지 배경인 하얀색 제거
        for(int i=0; i<array.length; i++){
            // 만약 해당 배열의 비트 컬러가 하얀색이라면
            if(array[i] == color){
                // 색을 투명으로 바꾼다.
                array[i] = Color.TRANSPARENT;
            }
        }

        // 다시 비트맵으로 변환하여 반환
        return Bitmap.createBitmap(array, 0, bitmap.getWidth(), bitmap.getWidth(),
                bitmap.getHeight(), Bitmap.Config.ARGB_8888);
    }

    // 크기가 바뀌었을때
    public void onSizeChanged(int width, int height){
        // 사이즈 초기화 set(좌, 위, 우, 아래)
        rectFrame.set(0, 0, width, height);

        background.setPosition(0, 0);
        background.setSize(width, height);

        int widthSpaceship = width/10;
        int heightSpaceship = widthSpaceship*2;
        spaceship.setSize(widthSpaceship, heightSpaceship);
        spaceship.setPosition(width/2, (int)(height*0.8));
    }

    // 스레드 시작
    public void on(){
        this.start();
    }

    // 스레드 종료
    public void off(){
        this.haveToStop = true;
    }

    // 실제 동작
    @Override
    public void run() {
        super.run();

        // 종료 변수가 거짓이 아니면
        while(!haveToStop){
            // 화면 잠그기
            Canvas canvas = surfaceHolder.lockCanvas();

            // 화면 그리기
            draw(canvas);

            //화면 풀기(화면이 있다면)
            if(canvas != null){
                surfaceHolder.unlockCanvasAndPost(canvas);
            }

            //게임 진행 시키기
            update();
        }
    }

    // 화면 그리기
    private void draw(Canvas canvas){
        background.draw(canvas);
        spaceship.draw(canvas);

        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semaphore.release();
    }

    // 게임 진행 시키기
    private void update(){
        spaceship.move(rectFrame);
    }

    // 우주선을 움직여라
    public void moveSpaceship(int x){
        spaceship.move(x);
    }
}
