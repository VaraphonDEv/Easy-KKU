package com.example.ooy.easykku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //การประกาศตัวแปร
    private Button signInButton, signUpButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind Widget
        ///Rเก็บรายละเอียดตัวแปร
        signInButton = (Button) findViewById(R.id.button2);
        signUpButton = (Button) findViewById(R.id.button);


        //Sign Up Controller
        //setOnClickListenner คือ click แค่หนึ่งครั้ง
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,SignUpActivity.class));
            }
        });

    }//Main Method


}//Main Class