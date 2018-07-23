package com.texopanda.sonusourav.texopanda;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;

public class Registation extends AppCompatActivity {

    Button reg;
    CheckBox cs;
    CheckBox fifa;
    CheckBox pubg;
    ImageView imageCS;
    ImageView imageFifa;
    ImageView imagePubg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registation);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            //window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.BLACK);
        }

        reg = findViewById(R.id.btn_register);
        cs = findViewById(R.id.check_cs);
        fifa = findViewById(R.id.check_fifa);
        pubg = findViewById(R.id.check_pubg);
        imageCS = findViewById(R.id.image1);
        imageFifa = findViewById(R.id.image2);
        imagePubg = findViewById(R.id.image3);

        Intent intent = getIntent();

        check(intent.getIntExtra("check",0),true);



        cs.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                check(1,isChecked);
            }
        });

        fifa.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                check(2,isChecked);
            }
        });

        pubg.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                check(3,isChecked);
            }
        });



        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Registation.this, "    Thank You For your Registration \n we will get Back to you soon",Toast.LENGTH_LONG).show();
            }
        });


    }


    public void check(int i,boolean b){
        if(i==0){
            if(b){
                imageCS.setBackgroundResource(R.drawable.c);
                imageFifa.setBackgroundResource(R.drawable.fi);
                imagePubg.setBackgroundResource(R.drawable.pubg);
                cs.setChecked(true);
                pubg.setChecked(true);
                fifa.setChecked(true);
            }
            else{
                imageCS.setBackgroundResource(R.color.non);
                imageFifa.setBackgroundResource(R.color.non);
                imagePubg.setBackgroundResource(R.color.non);
            }
        }

        else if(i==1){
            if(b){
                imageCS.setBackgroundResource(R.drawable.c);
                cs.setChecked(true);
            }
            else{
                imageCS.setBackgroundResource(R.color.non);
            }
        }

        else if(i==2){
            if(b){
                imageFifa.setBackgroundResource(R.drawable.fi);
                fifa.setChecked(true);

            }
            else{
                imageFifa.setBackgroundResource(R.color.non);
            }
        }

        else if(i==3){
            if(b){
                imagePubg.setBackgroundResource(R.drawable.pubg);
                pubg.setChecked(true);
            }
            else{
                imagePubg.setBackgroundResource(R.color.non);
            }
        }
    }


}
