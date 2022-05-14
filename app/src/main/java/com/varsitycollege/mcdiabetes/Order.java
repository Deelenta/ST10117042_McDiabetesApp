package com.varsitycollege.mcdiabetes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Order extends AppCompatActivity implements View.OnClickListener{

    ImageView img_baconburger, img_cheeseburger, img_chickenburger, img_chilliburger, img_onionburger, img_pepperburger, img_plainburger, img_veggieburger;
    //Instantiating DTO Data Transfer Object (Model)
    Order order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        img_baconburger = findViewById(R.id.baconburger);
        img_cheeseburger = findViewById(R.id.cheeseburger);
        img_chickenburger = findViewById(R.id.chickenburger);
        img_chilliburger = findViewById(R.id.chilliburger);
        img_onionburger = findViewById(R.id.onionburger);
        img_pepperburger = findViewById(R.id.pepperburger);
        img_plainburger = findViewById(R.id.plainburger);
        img_veggieburger = findViewById(R.id.veggieburger);

        img_baconburger.setOnClickListener(this);
        img_cheeseburger.setOnClickListener(this);
        img_chickenburger.setOnClickListener(this);
        img_chilliburger.setOnClickListener(this);
        img_onionburger.setOnClickListener(this);
        img_pepperburger.setOnClickListener(this);
        img_plainburger.setOnClickListener(this);
        img_veggieburger.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){

        Product product = new Product();
        
        switch(view.getId())
        {
            case R.id.baconburger:
            product.setBurgerName("Bacon Burger");
            product.setBurgerPrice("R59.55");
            Intent passBaconBurger = new Intent(Order.this,OrderDetails.class);
            passBaconBurger.putExtra("GetBaconBurgerName", product.getBurgerName());
            passBaconBurger.putExtra("GetBaconBurgerPrice", product.getBurgerPrice());
            passBaconBurger.putExtra("burgerImage",R.drawable.baconburger);

            startActivity(passBaconBurger);



                
        }
    }
}