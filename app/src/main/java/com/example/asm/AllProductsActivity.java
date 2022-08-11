package com.example.asm;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AllProductsActivity extends AppCompatActivity {
    private ListView lvProducts;
    LoadAllProducts task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_products);
        lvProducts=(ListView) findViewById(R.id.listProducts);
        task=new LoadAllProducts(AllProductsActivity.this,lvProducts);
        task.execute();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==100){
            Intent intent=getIntent();
            finish();
            startActivity(intent);
        }
    }
}
