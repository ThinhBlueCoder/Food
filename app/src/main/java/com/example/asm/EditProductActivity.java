package com.example.asm;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class EditProductActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText edtName, edtPrice, edtDes, edtCreatedAt;
    private Button btnSave, btnDelete;

    String pid, strName, strPrice, strDes, strCreatedAt;
    GetProducDetails productDetails;
    SaveProductDetails saveProductDetails;
    DeleteProduct deleteProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_product);

        edtName=findViewById(R.id.edtProductName);
        edtPrice=findViewById(R.id.edtProductPrice);
        edtDes=findViewById(R.id.edtProductDes);
        edtCreatedAt=findViewById(R.id.edtCreatedAt);
        btnSave=findViewById(R.id.btnSave);
        btnDelete=findViewById(R.id.btnDelete);

        pid=getIntent().getStringExtra(Constants.TAG_PID);

        productDetails=new GetProducDetails(this,edtName,edtPrice,edtDes,edtCreatedAt);
        productDetails.execute(pid);

        btnSave.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSave:
                strName=edtName.getText().toString();
                strPrice=edtPrice.getText().toString();
                strDes=edtDes.getText().toString();
                strCreatedAt=edtCreatedAt.getText().toString();

                saveProductDetails=new SaveProductDetails(this);
                saveProductDetails.execute(pid,strName,strPrice,strDes,strCreatedAt);
                break;
            case R.id.btnDelete:
                deleteProduct=new DeleteProduct(this);
                AlertDialog.Builder builder=new AlertDialog.Builder(this);
                builder.setTitle("Deleting product...");
                builder.setMessage("Are you sure you want delete this product?");
                builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        deleteProduct.execute(pid);
                        dialogInterface.dismiss();
                        Toast.makeText(EditProductActivity.this,"Deleted",Toast.LENGTH_LONG).show();

                    }
                });
                builder.setPositiveButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.show();
                break;
        }
    }
}
