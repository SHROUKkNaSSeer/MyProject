package com.example.shrouk.myapplication;

import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class XY extends AppCompatActivity {
    private CanvasView mCanvasView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xy);
        mCanvasView= (CanvasView) findViewById(R.id.canvas);}
    public void clear(View view) {
        switch (view.getId()){
            case R.id.clrButton:
                mCanvasView.clearCanvas();
                break;
            case R.id.cmpButton:
                Toast.makeText(this,mCanvasView.area()+ "", Toast.LENGTH_SHORT).show();
//
                //                    int total = 0,i=0;
//                    for ( i = 0; i < mCanvasView.mPoints.size(); i++) {
//                        float addX = mCanvasView.mPoints.get(i).x;
//                        float addY = mCanvasView.mPoints.get(i == mCanvasView.mPoints.size() - 1 ? 0 : i + 1).y;
//                        float subX = mCanvasView.mPoints.get(i == mCanvasView.mPoints.size() - 1 ? 0 : i + 1).x;
//                        float subY = mCanvasView.mPoints.get(i).y;
//                        total += (addX * addY * 0.5);
//                        total -= (subX * subY * 0.5);
//                    }
//
//                    if (mCanvasView.mPoints.get(0).x!=mCanvasView.mPoints.get(mCanvasView.mPoints.size()-1).x|| mCanvasView.mPoints.get(0).y!=mCanvasView.mPoints.get(mCanvasView.mPoints.size()-1).y ){
//                        float addX = mCanvasView.mPoints.get(0).x;
//                        float addY = mCanvasView.mPoints.get(i- 1).y;
//                        float subX = mCanvasView.mPoints.get(i- 1).x;
//                        float subY = mCanvasView.mPoints.get(0).y;
//                        total += (addX * addY * 0.5);
//                        total -= (subX * subY * 0.5);
//                    }
//
//                Toast.makeText(this, Math.abs(total)+"", Toast.LENGTH_SHORT).show();
//              //  mCanvasView.clearCanvas();
//                mCanvasView.mPoints.clear();

                break;
        }

    }
}



