package com.example.test8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {
    private DBOpenHelper dbOpenHelper;  //定义DBOpenHelper,用于与数据库连接
    private ImageButton bt_save,bt_cancel;
    private EditText et_word,et_interpret;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        bt_save=findViewById(R.id.save_btn);
        bt_cancel=findViewById(R.id.cancel_btn1);
        et_word=findViewById(R.id.add_word);
        et_interpret=findViewById(R.id.add_interpret);
        // 创建DBOpenHelper对象,指定名称、版本号并保存在databases目录下
        dbOpenHelper=new DBOpenHelper(AddActivity.this,"dictionary.db",null,1);
        //点击存储按钮，触发事件获取输入框的word 和interpret,存储到数据库
        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String word=et_word.getText().toString();
                String interpret=et_interpret.getText().toString();
                if(word.equals("")||interpret.equals("")){
                    Toast.makeText(AddActivity.this,"输入的单词或翻译为空",Toast.LENGTH_SHORT).show();
                }else{
                    SQLiteDatabase sqLiteDatabase=dbOpenHelper.getWritableDatabase();
                    ContentValues contentValues=new ContentValues();
                    contentValues.put("word",word);
                    contentValues.put("interpret",interpret);
                    sqLiteDatabase.insert("dict",null,contentValues);
                    Toast.makeText(AddActivity.this,"插入单词成功",Toast.LENGTH_SHORT).show();

                }

            }
        });

        //点击取消按钮，返回主界面
        bt_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AddActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(dbOpenHelper!=null){
            dbOpenHelper.close();
        }
    }
}
