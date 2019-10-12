package com.example.test5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    private Button bt_save;
    private Button bt_show;
    private TextView textView;
    private EditText et_editor;
    FileOutputStream fos;
    FileInputStream fis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_save = findViewById(R.id.save_btn);
        bt_show = findViewById(R.id.read_btn);
        et_editor = findViewById(R.id.text_et);
        textView = findViewById(R.id.show_tv);
        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fileName = "data.txt";//文件名称
                String content = et_editor.getText().toString();//保存数据
                try {
                    fos = openFileOutput(fileName, MODE_PRIVATE);
                    fos.write(content.getBytes());//将数据写入文件中
                    fos.close();
                    Toast.makeText(MainActivity.this,"保存成功",Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        bt_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    fis = openFileInput("data.txt");//获得文件输入流对象
                    byte[] buffer = new byte[fis.available()];//创建缓冲区，并获取文件长度
                    fis.read(buffer);//将文件内容读取到buffer缓冲区
                    textView.setText(new String(buffer));//转换成字符串并在textView中显示
                    fis.close();//关闭输入流
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

    }
}
