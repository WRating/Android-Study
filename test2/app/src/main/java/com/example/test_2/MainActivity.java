package com.example.test_2;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button myBtn1;
    private Button myBtn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myBtn1 =(Button)findViewById(R.id.btn_1);
        myBtn2 =(Button)findViewById(R.id.btn_2);

        myBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LayoutButtonActivity.class);
                //创建Intent对象，Intent用于各组件之间通讯构造方法的参数
                //第一个参数是当前activity.this
                //第二个参数是要跳转的界面对应的activity.class
                startActivity(intent);
                //启动
            }
            });
        myBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
                //创建Intent对象，Intent用于各组件之间通讯构造方法的参数
                //第一个参数是当前activity.this
                //第二个参数是要跳转的界面对应的activity.class
                startActivity(intent);
                //启动
//                finish();
                //最后记得关掉这个activity否则内存越占越多
            }
        });
    }
}

