package jm.spaceadventureproject;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

/**
 * Created by jm on 2017-06-01.
 */

class Entity {

    private Point position = new Point(0,0);    // 위치
    private Point speed    = new Point(0,0);    // 속도
    private Point size     = new Point(0,0);    // 영역(크기)
    private Bitmap image   = null;              // 이미지(생김새)

    private Rect rectSrc = new Rect();
    private Rect rectDst = new Rect();
    private Paint paint  = new Paint();

    public Entity(int alpha){
        paint.setAlpha(alpha);
    }

    public void draw(Canvas canvas){
        // 그림 원본에서 전체 가져오기
        rectSrc.set(0, 0, image.getWidth(), image.getHeight());

        //그림을 그릴 영역
        rectDst.set(position.x, position.y, position.x+size.x, position.y+size.y);

        // rectSrc = 그림 전체
        // rectDst = 그림을 그릴 영역
        // paint   = 무슨색깔, 무슨투명도 로 그릴것인가
        if(canvas != null){
            canvas.drawBitmap(image, rectSrc, rectDst, paint);
        }
    }

    public void drawTxt(Canvas canvas,
                        String txtToDisplay,
                        int txtColor,
                        int txtSize,
                        Paint.Align txtAlign
    ){
        Paint _paint = new Paint();
        _paint.setColor(txtColor);
        _paint.setTextSize(txtSize);
        _paint.setTextAlign(txtAlign);

        if(canvas != null){
            canvas.drawText(txtToDisplay, position.x, position.y, _paint);
        }
    }

    // 이동시킨다
    public void move(Rect rectFrame){
        position.x += speed.x;
        position.y += speed.y;
    }

    public void setImage(Resources resources, int image){
        Bitmap bitmap = BitmapFactory.decodeResource(resources, image);
        setImage(bitmap);
    }

    public Rect getRect(){
        rectDst.set(position.x, position.y, position.x+size.x, position.y+size.y);
        return rectDst;
    }

    public Rect getNextArea(){
        Rect rect = new Rect();
        rect.left   = position.x + speed.x;
        rect.top    = position.y + speed.y;
        rect.right  = rect.left + size.x;
        rect.bottom = rect.top + size.y;

        return rect;
    }

    public void setPosition(int x, int y) {
        this.position.set(x, y);
    }

    public void setSpeed(int x, int y){
        this.speed.set(x, y);
    }

    public void setSize(int width, int height) {
        this.size.set(width, height);
    }




    /* 하위는 getter setter */
    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public Point getSpeed() {
        return speed;
    }

    public void setSpeed(Point speed) {
        this.speed = speed;
    }

    public Point getSize() {
        return size;
    }

    public void setSize(Point size) {
        this.size = size;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public Rect getRectSrc() {
        return rectSrc;
    }

    public void setRectSrc(Rect rectSrc) {
        this.rectSrc = rectSrc;
    }

    public Rect getRectDst() {
        return rectDst;
    }

    public void setRectDst(Rect rectDst) {
        this.rectDst = rectDst;
    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }
}
