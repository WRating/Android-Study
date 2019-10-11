package com.example.test_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListViewActivity extends AppCompatActivity {
    private ListView myListView;
    //    需要适配的数据
    private String[] names = {"刘一", "陈二", "张三", "李四", "王五", "赵六", "孙七"};
    //    图片集合
    private int[] icons = {R.drawable.img01, R.drawable.img02, R.drawable.img03, R.drawable.img04, R.drawable.img05, R.drawable.img06, R.drawable.img07};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        myListView = (ListView) findViewById(R.id.lv);
//        创建一个Adapter的实例
        MyBaseAdapter myAdapter = new MyBaseAdapter();
//        设置Adapter
        myListView.setAdapter(myAdapter);
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                        Toast.makeText(ListViewActivity.this, names[i]+"is clicked", Toast.LENGTH_SHORT).show();
                    }
                });
            }

    class MyBaseAdapter extends BaseAdapter {
        //得到item的总数
        @Override
        public int getCount() {
            return names.length;//条目的总数
        }
        //得到item代表的对象
        @Override
        public Object getItem(int i) {
            return names[i];
        }
        //得到item的id
        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View converView, ViewGroup parent) {
            //将list_item.xml文件找出来并转换成View对象
            View view = View.inflate(ListViewActivity.this, R.layout.list_item, null);
            TextView mTextView = (TextView) view.findViewById(R.id.item_tv);
            mTextView.setText(names[i]);
            ImageView imageView = (ImageView) view.findViewById(R.id.item_image);
            imageView.setBackgroundResource(icons[i]);
            return view;
        }

    }
}
