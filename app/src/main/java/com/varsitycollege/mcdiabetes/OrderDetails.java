package com.varsitycollege.mcdiabetes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class OrderDetails extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Orders");
    private FirebaseAuth Auth;

    String UID;

    String burgerPrice;
    String burgerName;

    ImageView img_chosenImage;
    TextView txt_burgerPrice, txt_burgerName;
    Button btn_order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        // Initialize Firebase Auth
        Auth = FirebaseAuth.getInstance();

        img_chosenImage = findViewById(R.id.img_chosenBurger);
        txt_burgerName = findViewById(R.id.txt_burgerName);
        txt_burgerPrice = findViewById(R.id.txt_burgerPrice);
        btn_order = findViewById(R.id.btn_order);
        burgerPrice = getIntent().getStringExtra("GetBaconBurgerPrice");
        burgerName = getIntent().getStringExtra("GetBaconBurgerName");
        int imageName = getIntent().getIntExtra("burgerImage", 0);

        Toast.makeText(this, burgerPrice + " " + burgerName, Toast.LENGTH_SHORT).show();

        txt_burgerName.setText(burgerName);
        txt_burgerPrice.setText(burgerPrice);
        img_chosenImage.setImageResource(imageName);

        btn_order.setOnClickListener(new View.OnClickListener() {
            Product product = new Product(burgerName, burgerPrice);
            @Override
            public void onClick(View view) {
                myRef.child(Auth.getUid()).push().setValue(product).
                        addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                               Toast.makeText(OrderDetails.this,"Order successfully placed", Toast.LENGTH_SHORT).show();
                            }
                        }).
                        addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(OrderDetails.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }
}