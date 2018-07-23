package com.texopanda.sonusourav.texopanda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class fifa extends AppCompatActivity {

Intent intent;
    Button img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fifa);

        img=findViewById(R.id.abcdf);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(fifa.this,Registation.class);
                intent.putExtra("check",2);
                startActivity(intent);
            }
        });
    }
}
