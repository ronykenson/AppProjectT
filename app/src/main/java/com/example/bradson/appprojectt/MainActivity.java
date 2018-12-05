package com.example.bradson.appprojectt;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextInputEditText username1,userpassword;
    Button registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username1 = (TextInputEditText) findViewById(R.id.userName1);
        userpassword = (TextInputEditText) findViewById(R.id.password);
        registerBtn = (Button)findViewById(R.id.register);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
    }
    private void register(){
        String username = username1.getText().toString().trim();
        String password = userpassword.getText().toString().trim();

        if (checkUsername(username)&& checkPassword(password)){
            Toast.makeText(this, "ou anrejistre byen !",Toast.LENGTH_SHORT).show();
        }
    }

    private boolean checkUsername(String username){
        if (TextUtils.isEmpty(username)){
            username1.setError("silvouplè antre username ou");
            return false;
        }
        return true;
    }
    private boolean checkPassword(String password){
        if (TextUtils.isEmpty(password)){
            userpassword.setError("silvouple antre password ou ");
            return false;
        }
        else if (password.length()< 6){
            userpassword.setError("password pa dwe mwens ke 6 let ");
            return false;
        }
        else if (password.length()> 10){
            userpassword.setError("password ou pa dwe plus ke 10 let ");
            return false;
        }
        return true;
    }
}
