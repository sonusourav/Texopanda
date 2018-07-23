package com.texopanda.sonusourav.texopanda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class pubg extends AppCompatActivity {
Intent intent;
    Button img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pubg);

        img=findViewById(R.id.a);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(pubg.this,Registation.class);
                intent.putExtra("check",3);
                startActivity(intent);
            }
        });
    }
}
