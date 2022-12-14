package com.example.asm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter, adapter2;
    private RecyclerView recyclerViewCategoryList, recyclerViewPopularList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCategory();
        recyclerViewPopular();
        bottomNavigation();
    }

    private void bottomNavigation() {
        FloatingActionButton floatingActionButton = findViewById(R.id.cartBtn);
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        LinearLayout profileBtn = findViewById(R.id.profileBtn);
        LinearLayout AddBtn = findViewById(R.id.supportBtn);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CartListActivity.class));
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        });

        AddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity((new Intent(MainActivity.this,Main2Activity.class)));
            }
        });
    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true);
        recyclerViewCategoryList = findViewById(R.id.recyclerView);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> category = new ArrayList<>();
        category.add(new CategoryDomain("OPPO", "iphone13"));
        category.add(new CategoryDomain("iPhone", "iphone13"));
        category.add(new CategoryDomain("Samsung", "iphone13"));
        category.add(new CategoryDomain("iPad", "iphone13"));


        adapter = new CategoryAdaptor(category);
        recyclerViewCategoryList.setAdapter(adapter);
    }

    private void recyclerViewPopular() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList = findViewById(R.id.recyclerView2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> foodList = new ArrayList<>();
        foodList.add(new FoodDomain("iPhone13 Pro Max", "iphone13", "si??u ph???m mang tr??n m??nh b??? vi x??? l?? Apple A15 Bionic h??ng ?????u, m??n h??nh Super Retina XDR 120 Hz, c???m camera kh???u ????? f/1.5 c???c l???n, t???t c??? s??? mang l???i cho b???n nh???ng tr???i nghi???m tuy???t v???i ch??a t???ng c??", 29000000.000));
        foodList.add(new FoodDomain("Samsung Galaxy A13", "samsunga13", "si??u ph???m mang tr??n m??nh b??? vi x??? l?? Apple A15 Bionic h??ng ?????u, m??n h??nh Super Retina XDR 120 Hz, c???m camera kh???u ????? f/1.5 c???c l???n, t???t c??? s??? mang l???i cho b???n nh???ng tr???i nghi???m tuy???t v???i ch??a t???ng c??", 8000000.000));
        foodList.add(new FoodDomain("iPhone 11", "iphone11", "si??u ph???m mang tr??n m??nh b??? vi x??? l?? Apple A15 Bionic h??ng ?????u, m??n h??nh Super Retina XDR 120 Hz, c???m camera kh???u ????? f/1.5 c???c l???n, t???t c??? s??? mang l???i cho b???n nh???ng tr???i nghi???m tuy???t v???i ch??a t???ng c??", 800.00000));
        foodList.add(new FoodDomain("Samsung Galaxy A13", "samsunga13", "si??u ph???m mang tr??n m??nh b??? vi x??? l?? Apple A15 Bionic h??ng ?????u, m??n h??nh Super Retina XDR 120 Hz, c???m camera kh???u ????? f/1.5 c???c l???n, t???t c??? s??? mang l???i cho b???n nh???ng tr???i nghi???m tuy???t v???i ch??a t???ng c??", 7000000.000));
        foodList.add(new FoodDomain("iPhone 11", "iphone11", "si??u ph???m mang tr??n m??nh b??? vi x??? l?? Apple A15 Bionic h??ng ?????u, m??n h??nh Super Retina XDR 120 Hz, c???m camera kh???u ????? f/1.5 c???c l???n, t???t c??? s??? mang l???i cho b???n nh???ng tr???i nghi???m tuy???t v???i ch??a t???ng c??", 100.000));

        adapter2 = new PoplurarAdaptor(foodList);
        recyclerViewPopularList.setAdapter(adapter2);
    }
}