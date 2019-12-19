package com.tangtao.myrestudyandroid2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.tangtao.myrestudyandroid2.recyclerview.ParentRecyclerView;

public class DemoActivity_3 extends AppCompatActivity {

    private ParentRecyclerView rv_parent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_3);

        rv_parent = findViewById(R.id.rv_parent);
    }
}
