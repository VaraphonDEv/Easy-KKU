package com.example.ooy.easykku;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class MainActivity extends AppCompatActivity {

    //การประกาศตัวแปร
    private Button signInButton, signUpButton;
    private EditText userEditText,passwordEditText;
    private  String userString,passwordString;
    private  MyConstant myConstant;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myConstant = new MyConstant();
        //Bind Widget
        ///Rเก็บรายละเอียดตัวแปร
        signInButton = (Button) findViewById(R.id.button2);
        signUpButton = (Button) findViewById(R.id.button);
        userEditText = (EditText) findViewById(R.id.editText);
        passwordEditText = (EditText) findViewById(R.id.editText2);

        //Sign In controller
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Get value from Edit text
                userString = userEditText.getText().toString().trim();
                passwordString = passwordEditText.getText().toString().trim();

                if (userString.equals(("") )|| passwordString.equals("") ){
                        MyAlert myAlert = new MyAlert(MainActivity.this,R.drawable.bird48,
                                getResources().getString(R.string.titile_HaveSpace)
                                ,getResources().getString(R.string.message_HaveSpace));
                }else{
                        //Process User password
                    SynUser synUser = new SynUser(MainActivity.this);
                    synUser.execute(myConstant.getUrlGetJSON());

                }
            }
        });


        //Sign Up Controller
        //setOnClickListenner คือ click แค่หนึ่งครั้ง
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,SignUpActivity.class));
            }
        });


    }//Main Method


    private  class SynUser extends AsyncTask<String,Void,String>{
        private Context context;

        public SynUser(Context context) {
            this.context = context;
        }

        @Override
        protected String doInBackground(String... strings) {
           try{
               OkHttpClient okHttpClient = new OkHttpClient();
               Request.Builder builder = new Request.Builder();
               Request request = builder.url(strings[0]).build();
               Response response = okHttpClient.newCall(request).execute();
               return  response.body().string();
           }catch (Exception e){

               return null;
           }


        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Log.d("13/11/2559","JSON==>"+s);
        }//on post
    }//SynClass



}//Main Class