package com.texopanda.sonusourav.texopanda;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    RelativeLayout base;
    CardView RegisterCard;
    CardView EventsCard;
    CardView AboutCard;
    CardView SupportCard;
    boolean translatiomFlag;
    boolean swipeFlag=true;
    TextView coverText;
    ImageView coverImage;

    LinearLayout cover;
    float dX, dY;
    float i= (float) 0.1;

    DisplayMetrics displayMetrics = new DisplayMetrics();
    int height = displayMetrics.heightPixels;
    Intent intent;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        base = findViewById(R.id.base);
        RegisterCard = findViewById(R.id.cardRegister);
        EventsCard = findViewById(R.id.cardEvents);
        AboutCard = findViewById(R.id.cardAbout);
        SupportCard = findViewById(R.id.cardSupport);
        cover =  findViewById(R.id.cover);
        coverText = findViewById(R.id.cover_text);
        coverImage = findViewById(R.id.coverImage);








        RegisterCard.animate().alpha(0).translationYBy(1000);
        EventsCard.animate().alpha(0).translationY(1000);
        AboutCard.animate().alpha(0).translationY(1000);
        SupportCard.animate().alpha(0).translationY(1000);
        translatiomFlag = true;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            //window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.BLACK);
        }


        RegisterCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //register intent here
                intent = new Intent(MainActivity.this,Registation.class);
                intent.putExtra("check",0);
                startActivity(intent);
            }
        });

        EventsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Event intent here
                intent = new Intent(MainActivity.this, event.class);
                startActivity(intent);
            }
        });

        AboutCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Event intent here
                intent = new Intent(MainActivity.this, About_us.class);
                startActivity(intent);
            }
        });

        SupportCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Support intent here
                intent = new Intent(MainActivity.this,Support.class);
                startActivity(intent);
            }
        });


        cover.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {

                    case MotionEvent.ACTION_DOWN:

                        dX = cover.getX() - event.getRawX();
                        dY = cover.getY() - event.getRawY();
                        cover.animate().scaleY((float) (0.5)).scaleX((float) 0.5).setDuration(300);

                        coverText.setVisibility(View.GONE);
                        break;

                    case MotionEvent.ACTION_MOVE:

                        if(dY<event.getRawY()){

                            cover.animate()
                                    //.x(event.getRawX() + dX)
                                    .y(event.getRawY() + dY)
                                    .setDuration(0)
                                    .start();}


                        break;

                    case MotionEvent.ACTION_UP:

                        if(swipeFlag){
                            cover.setBackgroundResource(R.drawable.gamea);
                            cover.animate().translationY(-225).rotationX(360).setDuration(300);
                            coverImage.setVisibility(View.GONE);


                            translatiomFlag = false;
                            RegisterCard.animate().translationYBy(-1000).alpha(1).setDuration(500);
                            EventsCard.animate().translationYBy(-1000).alpha(1).setDuration(450);
                            AboutCard.animate().translationYBy(-1000).alpha(1).setDuration(400);
                            SupportCard.animate().translationYBy(-1000).alpha(1).setDuration(350);

                            swipeFlag=false;
                        }
                        else{
                            cover.animate().translationY(0).scaleX(1).scaleY(1).setDuration(500);
                            cover.setBackgroundResource(R.drawable.fore);
                            coverText.setTextScaleX(1);
                            coverText.setVisibility(View.VISIBLE);
                            coverImage.setVisibility(View.VISIBLE);
                            translatiomFlag = true;
                            RegisterCard.animate().translationYBy(1000).alpha(1).setDuration(350);
                            EventsCard.animate().translationYBy(1000).alpha(1).setDuration(400);
                            AboutCard.animate().translationYBy(1000).alpha(1).setDuration(450);
                            SupportCard.animate().translationYBy(1000).alpha(1).setDuration(500);
                            swipeFlag=true;
                        }
                    default:
                        return false;
                }
                return true;

            }
        });

    }


}

