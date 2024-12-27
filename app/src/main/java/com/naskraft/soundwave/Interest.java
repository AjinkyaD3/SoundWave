package com.naskraft.soundwave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class Interest extends AppCompatActivity {
    CheckBox obj1,obj2,obj3,obj4,obj5,obj6;
    Button btn_continue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest);
        btn_continue=(Button)findViewById(R.id.btn_continue);
        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Homepage.class);
                startActivity(intent);
            }
        });
    }
}