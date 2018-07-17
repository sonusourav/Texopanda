package com.texopanda.sonusourav.texopanda;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;


public class MainActivity extends AppCompatActivity {

    private GestureDetectorCompat gestureObject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gestureObject = new GestureDetectorCompat(this, new LearnGesture());

    }
    public boolean onTouchEvent(MotionEvent event){
        this.gestureObject.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    class LearnGesture extends GestureDetector.SimpleOnGestureListener{




        public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX ,float velocityY){
            if(event2.getY()<event1.getY()){

                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                finish();
                startActivity(intent);


            }


           return true;
         }

    }
}



