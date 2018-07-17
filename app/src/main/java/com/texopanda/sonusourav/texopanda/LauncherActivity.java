package com.texopanda.sonusourav.texopanda;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.appus.splash.Splash;


public class LauncherActivity extends AppCompatActivity implements Animation.AnimationListener {
    Animation animFadeIn;

    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);


        Splash.Builder splash = new Splash.Builder(this, getSupportActionBar());
        splash.setSplashImage(getDrawable(R.drawable.icon_app));
        splash.setBackgroundColor(Color.BLACK);
        splash.perform();



        // Remember that you should never show the action bar if the
        // status bar is hidden, so hide that too if necessary.
        animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fade_in);
        // set animation listener
        animFadeIn.setAnimationListener(this);
        // animation for image
        linearLayout = (LinearLayout) findViewById(R.id.launcher_linear_layout);
        // start the animation
        linearLayout.startAnimation(animFadeIn);







    }



    @Override
    public void onAnimationStart(Animation animation) {




                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        final Intent mainIntent = new Intent(LauncherActivity.this, MainActivity.class);
                                        LauncherActivity.this.startActivity(mainIntent);
                                        LauncherActivity.this.finish();
                                    }
                                }, 6500);
                                    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
