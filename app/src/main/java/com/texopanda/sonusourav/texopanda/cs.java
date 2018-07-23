package com.texopanda.sonusourav.texopanda;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class cs extends AppCompatActivity {

 Button img;
 Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cs);
        img=findViewById(R.id.abcde);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(cs.this,Registation.class);
                intent.putExtra("check",1);
                startActivity(intent);
            }
        });

    }
}
