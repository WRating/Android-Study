package com.example.test3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn);
        //对保存按钮进行数据传递
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //获取输入的所在地区
                String site1 = ((EditText) findViewById(R.id.et_site1)).getText().toString();
                //获取输入的所在街道
                String site2 = ((EditText) findViewById(R.id.et_site2)).getText().toString();
                //获取输入的详细地址
                String site3 = ((EditText) findViewById(R.id.et_site3)).getText().toString();
                //获取输入的用户信息
                String name = ((EditText) findViewById(R.id.et_name)).getText().toString();
                //获取输入的手机号码
                String phone = ((EditText) findViewById(R.id.et_phone)).getText().toString();
                //获取输入的邮箱
                String email= ((EditText) findViewById(R.id.et_email)).getText().toString();
                //判断输入内容是否为空
                if (!"".equals(site1) && !"".equals(site2) && !"".equals(site3) && !"".equals(name) && !"".equals(phone) && !"".equals(email)) {
                    //创建Intent对象，启动AddressActivity
                    Intent intent =new Intent(MainActivity.this,AddressActivity.class);
                    //将数据存入Intent对象
                    intent.putExtra("site1",site1);
                    intent.putExtra("site2",site2);
                    intent.putExtra("site3",site3);
                    intent.putExtra("name",name);
                    intent.putExtra("phone",phone);
                    intent.putExtra("email",email);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(MainActivity.this, "请将收货地址填写完整", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
