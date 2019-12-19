package com.tangtao.myrestudyandroid2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

public class MainActivity extends AppCompatActivity {

    private static final String REMOTE_ACTION = "remote_action";
    private static final String EXTRA_REMOTE_VIEWS = "extra";
    private Button btnDiff, btnSame;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDiff = findViewById(R.id.btn_diff);
        btnDiff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DemoActivity_1.class));
            }
        });

        btnSame = findViewById(R.id.btn_same);
        btnSame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DemoActivity_2.class));
            }
        });


        //notifyRemoteView();


    }

    private void notifyRemoteView() {
        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.remote_notify_layout);
        remoteViews.setTextViewText(R.id.tv_remote, "msg from process: " + Process.myPid());
        remoteViews.setImageViewResource(R.id.iv_remote, R.mipmap.ic_launcher);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
                new Intent(this, DemoActivity_1.class), PendingIntent.FLAG_UPDATE_CURRENT);
        PendingIntent openActivity2PendingIntent = PendingIntent.getActivity(this,
                0, new Intent(this, DemoActivity_2.class),
                PendingIntent.FLAG_UPDATE_CURRENT);
        remoteViews.setOnClickPendingIntent(R.id.iv_remote, pendingIntent);
        remoteViews.setOnClickPendingIntent(R.id.open_activity2, openActivity2PendingIntent);

        Intent intent = new Intent(REMOTE_ACTION);
        intent.putExtra(EXTRA_REMOTE_VIEWS, remoteViews);
        sendBroadcast(intent);
    }
}
