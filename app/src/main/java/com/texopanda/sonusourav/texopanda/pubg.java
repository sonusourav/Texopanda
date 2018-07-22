package com.texopanda.sonusourav.texopanda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class pubg extends AppCompatActivity {

    Button img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pubg);

        img=findViewById(R.id.a);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(pubg.this,EventRegister.class);
                startActivity(in);
            }
        });
    }
}
