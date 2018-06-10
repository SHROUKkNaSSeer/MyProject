package com.example.shrouk.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
LinearLayout l1,l2;
Button buttonsub;
Animation uptodown,downtotop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        l1 =  (LinearLayout)findViewById(R.id.l1);
        l2 =  (LinearLayout)findViewById(R.id.l2);
        buttonsub=(Button)findViewById(R.id.buttonsub);
        uptodown = AnimationUtils.loadAnimation(this,R.anim.uptodown);
        downtotop=AnimationUtils.loadAnimation(this,R.anim.downtotop);
        l1.setAnimation(uptodown);
        l2.setAnimation(downtotop);



}

    public void welcom(View view) {
        Intent i = new Intent(this,secondseen.class);
        startActivity(i);

    }
}
