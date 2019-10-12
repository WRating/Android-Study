package com.example.test6;

import android.os.Environment;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

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
        bt_save=findViewById(R.id.save_btn);
        bt_show=findViewById(R.id.read_btn);
        et_editor=findViewById(R.id.text_et);
        textView=findViewById(R.id.show_tv);
        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    File path=Environment.getExternalStorageDirectory();
                    Log.d("File Path",path.toString());
                    File file=new File(path,"data.txt");
                    //fos=new FileOutputStream(file);
                    fos=openFileOutput("data.txt",MODE_PRIVATE);
                    String s_data=et_editor.getText().toString();
                    fos.write(s_data.getBytes());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        bt_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    File path=Environment.getExternalStorageDirectory();
                    File file=new File(path,"data.txt");
//                    fis=new FileInputStream(file);
                    fis=openFileInput("data.txt");
                    byte[] bt=new byte[fis.available()];
                    fis.read(bt);
                    textView.setText(new String(bt));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
    }
}
