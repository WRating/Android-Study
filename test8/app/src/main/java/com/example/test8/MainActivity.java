package com.example.test8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private DBOpenHelper dbOpenHelper;   //定义DBOpenHelper
    private Button bt_add;
    private ImageButton ib_search;
    private EditText et_search;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_add=findViewById(R.id.btn_add);
        ib_search=findViewById(R.id.search_btn);
        et_search=findViewById(R.id.search_et);
        listView=findViewById(R.id.result_listView);
        // 创建DBOpenHelper对象,指定名称、版本号并保存在databases目录下
        dbOpenHelper=new DBOpenHelper(MainActivity.this,"dictionary.db",null,1);
        //点击添加按钮，跳转到添加界面
        bt_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,AddActivity.class);
                startActivity(intent);
            }
        });

        //点击翻译按钮，搜索编辑框中对应的翻译，并显示在listView中
        ib_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String key=et_search.getText().toString();
                if(key.equals("")){
                    Toast.makeText(MainActivity.this,"请输入需要翻译的单词",Toast.LENGTH_SHORT).show();
                }else{
                    SQLiteDatabase sqLiteDatabase=dbOpenHelper.getReadableDatabase();
                    Cursor cursor=sqLiteDatabase.query("dict",null,"word=?",new String[]{key},null,null,null);
                    ArrayList<Map<String,String>> result=new ArrayList<Map<String,String>>();
                    while (cursor.moveToNext()){
                        Map<String,String> map=new HashMap<String, String>();
                        map.put("word",cursor.getString(1));
                        map.put("interpret",cursor.getString(2));
                        result.add(map);
                    }
                    if(result.size()==0){
                        Toast.makeText(MainActivity.this,"没有相关翻译",Toast.LENGTH_SHORT).show();
                    }else {
                        SimpleAdapter simpleAdapter=new SimpleAdapter(MainActivity.this,result,R.layout.result_main,new String[]{"word","interpret"},new int[]{R.id.result_word,R.id.result_interpret});
                        listView.setAdapter(simpleAdapter);
                    }

                }

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
