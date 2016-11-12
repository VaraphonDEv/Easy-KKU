package com.example.ooy.easykku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class SignUpActivity extends AppCompatActivity {

    //Explicit
    private EditText nameEditText, phoneEditText, userEditText, passwordEditText;
    private ImageView imageView;
    private Button button;

    private String nameString, phoneString, usernameString, passwordString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        nameEditText = (EditText) findViewById(R.id.editText3);
        phoneEditText = (EditText) findViewById(R.id.editText4);
        userEditText = (EditText) findViewById(R.id.editText5);
        passwordEditText = (EditText) findViewById(R.id.editText6);
        imageView = (ImageView) findViewById(R.id.imageView);
        button = (Button) findViewById(R.id.button3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Get value From Edit Text
                nameString = nameEditText.getText().toString().trim();
                phoneString = phoneEditText.getText().toString().trim();
                usernameString = userEditText.getText().toString().trim();
                passwordString = phoneEditText.getText().toString().trim();

                //Check space
                if (nameString.equals("") || phoneString.equals("") || usernameString.equals("")
                        || passwordString.equals("")) {
                    //Have space
                    Log.d("12novVq","have space");
                    MyAlert myAlert = new MyAlert(SignUpActivity.this,R.drawable.doremon48,"มีช่องว่าง","กรุณากรอกให้ครบค่ะ");
                    myAlert.myDialog();
                }

            }//On click
        });
    //Image Controller
                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                            intent.setType("image/*"); //defalu จะไปเปิดที่ gellary
                            startActivityForResult(Intent.createChooser(intent,"โปรเลือกแอพดูรูปภาพ"),0);
                            //0 is request data

                        }//Onclick
                    });
    }//Main Method

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ((requestCode == 0)&& (requestCode == RESULT_OK)) {
            Log.d("12novV1","Result OK");
        }
    }
}//Main Class
