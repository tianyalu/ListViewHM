package com.sty.listview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private ListView lvSimple;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

        initViews();
    }

    private void initViews(){
        //1.找到ListView
        lvSimple = (ListView) findViewById(R.id.lv_simple);
        //2.创建一个adapter对象
        MyListAdapter listAdapter = new MyListAdapter();
        //3.将adapter设置给listView
        lvSimple.setAdapter(listAdapter);
    }

    class MyListAdapter extends BaseAdapter {

        private Map<Integer, Integer> map = new HashMap<>();

        //告诉ListView要显示多少个条目
        @Override
        public int getCount() {
            return 20;
        }

        //根据position获取listview上条目对应的Bean数据，该方法不影响数据的展示，可先不实现
        @Override
        public Object getItem(int i) {
            return null;
        }

        //用来获取条目position行的id,该方法不影响数据的展示，可以先不实现
        @Override
        public long getItemId(int i) {
            return 0;
        }

        /**
         * 告诉listView条目上显示的内容：返回一个view对象来作为条目上的内容展示,该方法返回什么样的view,
         * listView的条目上就显示什么样的View.该方法必须实现
         * 屏幕上每显示一个Item该方法就会被调用一次
         * @param position
         * @param convertView 曾经使用过的view对象，可以被重复使用，使用前要判断是否为空
         * @param parent
         * @return
         */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView view = null;
            Log.i(TAG, "position: " + position);
            if(convertView != null) { //判断convertView是否为空，不为空则重新使用
                view = (TextView) convertView;
            }else{
                view = new TextView(mContext); //创建一个textView对象
            }
            view.setText("position:" + position); //设置textView的内容
            view.setTextSize(30);
            map.put(view.hashCode(), 1);

            Log.i(TAG, "创建了 " + map.size() + " 个对象");
            return view;
        }
    }

}
