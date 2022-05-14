package com.varsitycollege.mcdiabetes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

     FirebaseAuth Auth;
    private String TAG = "Login statistics";


    ImageView img_mc_logo;
    EditText et_Email, et_Password;
    Button btn_login, btn_join;
    String email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Firebase Auth
        Auth = FirebaseAuth.getInstance();
        img_mc_logo = findViewById(R.id.mcdiabeteslogo);
        et_Email = findViewById(R.id.et_Email);
        et_Password = findViewById(R.id.et_Password);
        btn_login = findViewById(R.id.btn_login);
        btn_join = findViewById(R.id.btn_join);

        btn_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                email = et_Email.getText().toString();
                password = et_Password.getText().toString();


                if(!email.isEmpty() && !password.isEmpty()){



                Auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "User successfully registered", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Ooops", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                          Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });


//                Intent i = new Intent(MainActivity.this, Order.class);
//                startActivity(i);
            }
        };


        });


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = et_Email.getText().toString();
                password = et_Password.getText().toString();

                if (!email.isEmpty() && !password.isEmpty())
                {

                    Auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(MainActivity.this, "Welcome " + Auth.getCurrentUser().getEmail(), Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(MainActivity.this, Order.class);
                                startActivity(i);


                            } else {
                                Toast.makeText(MainActivity.this, "Computer says no " + Auth.getCurrentUser().getEmail(), Toast.LENGTH_SHORT).show();

                            }
                        }


                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });

             }
                else
                {
                    Toast.makeText(MainActivity.this, "pleaes enter datat ", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }





    @Override
    protected void onStart() {
       super.onStart();

       }
    }
