package com.example.logindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private EditText name;
private  EditText password;
private TextView info;
private Button login;
private  int counter=5;
SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(EditText)findViewById(R.id.editText1);
        password=(EditText)findViewById(R.id.editText2);

        sharedPreferences= getSharedPreferences("loginpref","")

        info=(TextView)findViewById(R.id.textView);
        login=(Button)findViewById(R.id.button);
        info.setText("Number of Incorrect Attempts : 5");
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(name.getText().toString(),password.getText().toString());
            }
        });
    }
      private void validate(String username, String password)
      {
          if((username.equals("chaithanya"))&&(password.equals("12345678"))){
              Intent intent=new Intent(MainActivity.this,SecondActivity.class);
              startActivity(intent);
          }else{
counter--;
info.setText("Number of Incorrect Attempts :" + String.valueOf(counter));
if(counter==0){
    login.setEnabled(false);
}
          }

      }

}
