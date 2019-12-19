package com.tangtao.myrestudyandroid2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ScrollView;

import com.tangtao.myrestudyandroid2.same_conflict_widget.MatchListView;
import com.tangtao.myrestudyandroid2.same_conflict_widget.MyScrollView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;

public class DemoActivity_2 extends AppCompatActivity {

    private MyScrollView scrollView;
    private MatchListView listView, listView2;
    private List<String> datas;
    private List<String> datas2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_2);

        initView();
        initData();
    }

    private void initView() {
        scrollView = findViewById(R.id.scrollView);
        listView = findViewById(R.id.inListView);
        listView2 = findViewById(R.id.listView2);
    }

    @SuppressLint("CheckResult")
    private void initData() {
        datas = new ArrayList<>();
        datas2 = new ArrayList<>();
        Flowable.range(0, 50).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                datas.add("第" + integer + "条item");
            }
        });

        listView.setAdapter(new ArrayAdapter<String>(DemoActivity_2.this, android.R.layout.simple_list_item_1, datas));


        Flowable.range(0, 30).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                datas2.add("第" + integer + "条item2");
            }
        });

        listView2.setAdapter(new ArrayAdapter<String>(DemoActivity_2.this, android.R.layout.simple_list_item_1, datas2));
    }
}
