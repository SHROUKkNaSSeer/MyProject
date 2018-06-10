package com.example.shrouk.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class CanvasView extends View {

    public List<Point> mPoints=new ArrayList<>();
    public int width;
    public int hight;
    public Canvas mCanvas;
    private Path mPath;
    private float mX,mY;
    private Paint mPaint;
    public Bitmap mBitmap;
    private static final float TOLERANCE=5;
    Context context;

    public CanvasView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        mPath=new Path();
        mPaint=new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeWidth(4f);


    }
    public int area(){
        int total = 0,i=0;
        for ( i = 0; i < mPoints.size(); i++) {
            float addX =mPoints.get(i).x;
            float addY = mPoints.get(i ==mPoints.size() - 1 ? 0 : i + 1).y;
            float subX =mPoints.get(i == mPoints.size() - 1 ? 0 : i + 1).x;
            float subY = mPoints.get(i).y;
            total += (addX * addY * 0.5);
            total -= (subX * subY * 0.5);
        }
        if (mPoints.get(0).x!=mPoints.get(mPoints.size()-1).x|| mPoints.get(0).y!=mPoints.get(mPoints.size()-1).y ){
            float addX = mPoints.get(0).x;
            float addY = mPoints.get(i- 1).y;
            float subX = mPoints.get(i- 1).x;
            float subY = mPoints.get(0).y;
            total += (addX * addY * 0.5);
            total -= (subX * subY * 0.5);
            mPath.quadTo(subX,addY,addX,subY);

//            mCanvas.drawPath(mPath,mPaint);
            invalidate();
        }

        return Math.abs(total);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(mPath,mPaint);
    }
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mBitmap=Bitmap.createBitmap(w,h, Bitmap.Config.ARGB_8888);

        mCanvas=new Canvas(mBitmap);
    }
    private void StartTouch(float x,float y){
        mPath.moveTo(x,y);
        mX=x;
        mY=y;
    }
    private void onMoveTouch(float x,float y){
        float dX=Math.abs(x-mX);
        float dY=Math.abs(y-mY);
        if (dX>=TOLERANCE || dY>=TOLERANCE){
            mPath.quadTo(mX,mY,(x+mX)/2,(y+mY)/2);
            mY=y;
            mX=x;
        }

    }
    private void UpTouch(){
        mPath.lineTo(mX,mY);
    }

    public void clearCanvas(){
        mPath.reset();
        mPoints.clear();
        invalidate();
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x=event.getX();
        float y=event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                StartTouch(x,y);
                mPoints.add(new Point((int)x,(int)y));
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                mPoints.add(new Point((int)x,(int)y));
                onMoveTouch(x,y);
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                UpTouch();
                invalidate();
                break;

        }
        return true;
    }
}