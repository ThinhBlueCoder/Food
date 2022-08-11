package com.example.asm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class ChaoActivity extends AppCompatActivity {
private ConstraintLayout starchao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chao);

        starchao = findViewById(R.id.btn_chao);
        starchao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChaoActivity.this, LoginActivity.class));
            }
        });
    }
}
