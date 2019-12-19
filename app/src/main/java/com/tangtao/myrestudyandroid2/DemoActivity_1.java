package com.tangtao.myrestudyandroid2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.tangtao.myrestudyandroid2.diff_conflict_widget.InBadViewPager;
import com.tangtao.myrestudyandroid2.diff_conflict_widget.InMyListView;
import com.tangtao.myrestudyandroid2.diff_conflict_widget.OutBadViewPager;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;

public class DemoActivity_1 extends AppCompatActivity {

    private OutBadViewPager badViewPager;
    private InBadViewPager inBadPager;
    private List<View> views;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_1);
        initView();

        initData(true);
    }

    private void initView() {
        badViewPager = findViewById(R.id.badPager);
        inBadPager = findViewById(R.id.inBadPager);
        views = new ArrayList<>();
    }

    @SuppressLint("CheckResult")
    private void initData(final boolean isList) {

        Flowable.just("view1", "view2", "view3", "view4").subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                View view;
                if (isList) {
                    //ListView listView = new ListView(DemoActivity_1.this);
                    InMyListView listView = new InMyListView(DemoActivity_1.this);
                    final List<String> datas = new ArrayList<>();

                    Flowable.range(0, 50).subscribe(new Consumer<Integer>() {
                        @Override
                        public void accept(Integer integer) throws Exception {
                            datas.add(integer + "");
                        }
                    });

                    listView.setAdapter(new ArrayAdapter<String>(DemoActivity_1.this, android.R.layout.simple_list_item_1, datas));
                    view = listView;
                } else {
                    TextView textView = new TextView(DemoActivity_1.this);
                    textView.setGravity(Gravity.CENTER);
                    textView.setTextSize(24);
                    textView.setTextColor(getResources().getColor(android.R.color.black));
                    textView.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_dark));
                    textView.setText(s);
                    //textView.setClickable(false);
                    view = textView;
                }

                views.add(view);
                inBadPager.setAdapter(new MyPagerAdapter(DemoActivity_1.this, views));

            }
        });


    }
}
