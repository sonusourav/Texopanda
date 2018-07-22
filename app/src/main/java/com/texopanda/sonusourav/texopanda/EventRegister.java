package com.texopanda.sonusourav.texopanda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class EventRegister extends AppCompatActivity {


    Button img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_register);
        img=findViewById(R.id.btn123);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(EventRegister.this, "    Thank You For your Registration \n we will get Back to you soon",Toast.LENGTH_LONG).show();
            }
        });

    }
}
