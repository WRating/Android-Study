package com.example.test3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AddressActivity extends AppCompatActivity {
    private TextView my_name;
    private TextView my_phone;
    private TextView my_site;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        //获取到Intent对象
        Intent intent = getIntent();
        //获取输入的所在地区
        String site1 = intent.getStringExtra("site1");
        //获取输入的所在街道
        String site2 = intent.getStringExtra("site2");
        //获取输入的详细地址
        String site3 = intent.getStringExtra("site3");
        //获取输入的用户信息
        String name = intent.getStringExtra("name");
        //获取输入的手机号码
        String phone = intent.getStringExtra("phone");
        my_name = (TextView) findViewById(R.id.name);
        my_phone = (TextView) findViewById(R.id.phone);
        my_site = (TextView) findViewById(R.id.site);
        my_name.setText(name);
        my_phone.setText(phone);
        my_site.setText(site1 + site2 + site3);
    }
}
