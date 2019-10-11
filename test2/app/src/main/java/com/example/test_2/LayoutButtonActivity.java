package com.example.test_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class LayoutButtonActivity extends AppCompatActivity implements View.OnClickListener {
    protected EditText my_editText;
    protected TextView my_textView;
    protected Button myBtn_one;
    protected Button myBtn_two;
    protected Button myBtn_three;
    protected Button myBtn_four;
    protected static LinearLayout layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_button);
        //通过findViewById()初始化控件，必须写在onCreate()里面
        myBtn_one = (Button) findViewById(R.id.btn_one);
        myBtn_two = (Button) findViewById(R.id.btn_two);
        myBtn_three = (Button) findViewById(R.id.btn_three);
        myBtn_four = (Button) findViewById(R.id.btn_four);
        my_editText = (EditText) findViewById(R.id.editText);
        my_textView = (TextView) findViewById(R.id.textView);
        myBtn_three.setOnClickListener(this);
        layout=(LinearLayout) findViewById(R.id.bgImage);

//        Button2使用匿名内部类的方式实现监听事件,点击Button2响应Toast消息对话框
        myBtn_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LayoutButtonActivity.this, "消息显示", Toast.LENGTH_SHORT).show();
            }
        });

        myBtn_four.setOnClickListener(new btnOnClickListener() {
            @Override
            public void onClick(View view) {
                // 调用父类的OnClick事件
                super.onClick(view);
                layout.setBackgroundResource(R.drawable.bg);

            }
        });
    }

    //    通过onClick()的方法实现按钮1的点击事件
    public void click_one(View view) {
        String str = "";
        str = my_editText.getText().toString();//将editText中的内容存储在数组str中
        my_textView.setText(str.toCharArray(), 0, str.length());//将str中的内容赋值到textview中
    }

    //    Button3使用接口方式实现监听事件，
    //    点击Button3响应Log工具提示信息；
    @Override
    public void onClick(View view) {
        Log.i("LayoutButtonActivity", "提示信息 ");
    }

}

//Button4使用外部类的方式实现监听事件, 点击Button4设置页面背景
class btnOnClickListener implements View.OnClickListener {
    @Override
    public void onClick(View view) {
//        layout.setBackgroundResource(R.drawable.bg);
    }
}