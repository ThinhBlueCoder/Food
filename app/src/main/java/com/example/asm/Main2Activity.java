package com.example.asm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.asm.AddProductActivity;
import com.example.asm.AllProductsActivity;
import com.example.asm.R;

public class Main2Activity extends AppCompatActivity {
    Button bt1,bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        bt1=findViewById(R.id.btnViewProducts);
        bt2=findViewById(R.id.btnAddProduct);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Main2Activity.this, AllProductsActivity.class);
                startActivity(intent);
            }
        } );
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Main2Activity.this, AddProductActivity.class);
                startActivity(intent);
            }
        } );
    }
}