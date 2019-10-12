package com.example.test7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String user_name="chen",password="123456";
    private EditText et_user, et_pass;
    private ImageButton bt_load;
    private String name,pass;
    private SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton bt_load = findViewById(R.id.login);
        et_user = findViewById(R.id.username);
        et_pass = findViewById(R.id.password);
        bt_load=findViewById(R.id.login);
        sp=getSharedPreferences("chen",MODE_PRIVATE);
        if(sp.getString("user_name","").equals(user_name)&&sp.getString("password","").equals(password)){
            Intent intent=new Intent(MainActivity.this,MessageActivity.class);
            startActivity(intent);
        }else {
            bt_load.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (et_user.getText().toString().equals(user_name) && et_pass.getText().toString().equals(password)) {
                        Intent intent = new Intent(MainActivity.this, MessageActivity.class);
                        startActivity(intent);
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putString("user_name", user_name);
                        editor.putString("password", password);
                        editor.commit();
                    } else {
                        Toast.makeText(MainActivity.this, "用户名或密码错误", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }
}
