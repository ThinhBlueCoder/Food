package com.example.asm;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddProductActivity extends AppCompatActivity {
    private EditText edtName, edtPrice, edtCreatedAt, edtDes;
    private Button btnAdd;
    String strName, strPrice, strDes, strCreatedAt;
    CreateNewProduc newProduct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_product);
        edtName=findViewById(R.id.edtProductName);
        edtPrice=findViewById(R.id.edtProductPrice);
        edtDes=findViewById(R.id.edtProductDes);
        edtCreatedAt=findViewById(R.id.edtCreatedAt);
        btnAdd=findViewById(R.id.btnAdd);
        newProduct=new CreateNewProduc(this);

        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        String strDate = sdf.format(c.getTime());
        edtCreatedAt.setText(strDate);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strName=edtName.getText().toString();
                strPrice=edtPrice.getText().toString();
                strDes=edtDes.getText().toString();
                strCreatedAt=edtCreatedAt.getText().toString();
                newProduct.execute(strName,strPrice,strDes,strCreatedAt);
            }
        });
    }
}
