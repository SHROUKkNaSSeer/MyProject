package com.example.shrouk.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AreaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_area);

        setContentView(new DrawingView(AreaActivity.this));
        //        mButton= (Button) findViewById(R.id.getCanvas);
//        mButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(AreaActivity.this, DrawingView.area()+"", Toast.LENGTH_SHORT).show();
//
//            }
//        });
    }
}
class DrawingView extends SurfaceView {
    private SurfaceHolder surfaceHolder;
    private final Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Context context;

    private static List<Point> pointsList = new ArrayList<Point>();

    public DrawingView(Context context) {
        super(context);
        this.context = context;
        surfaceHolder = getHolder();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
    }
    public static int area() {
        int total = 0;
        for (int i = 0; i < pointsList.size(); i++) {
            float addX = pointsList.get(i).x;
            float addY = pointsList.get(i == pointsList.size() - 1 ? 0 : i + 1).y;
            float subX = pointsList.get(i == pointsList.size() - 1 ? 0 : i + 1).x;
            float subY = pointsList.get(i).y;
            total += (addX * addY * 0.5);
            total -= (subX * subY * 0.5);
        }
        return Math.abs(total);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (surfaceHolder.getSurface().isValid()) {
                // Add current touch position to the list of points
                pointsList.add(new Point((int) event.getX(), (int) event.getY()));
                // Get canvas from surface
                Canvas canvas = surfaceHolder.lockCanvas();
                Toast.makeText(context, area() + "", Toast.LENGTH_SHORT).show();

                // Clear screen
                canvas.drawColor(Color.WHITE);

                // Iterate on the list
                for (int i = 0; i < pointsList.size(); i++) {
                    Point current = pointsList.get(i);
                    Point first = pointsList.get(0);

                    // Draw points
                    canvas.drawCircle(current.x, current.y, 5, paint);

                    // Draw line with next point (if it exists)
                    if (i + 1 < pointsList.size()) {
                        Point next = pointsList.get(i + 1);
                        canvas.drawLine(current.x, current.y, next.x, next.y, paint);
                        canvas.drawLine(next.x, next.y, first.x, first.y, paint);

                    }

                }

                // Release canvas
                surfaceHolder.unlockCanvasAndPost(canvas);
            }
        } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
            Toast.makeText(context, area() + "", Toast.LENGTH_SHORT).show();

        }
        return false;
    }
}

