package com.tangtao.myrestudyandroid2.diff_conflict_widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

public class InBadViewPager extends ViewPager {


    public InBadViewPager(@NonNull Context context) {
        this(context, null);
    }

    public InBadViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int action = ev.getAction() & MotionEvent.ACTION_MASK;
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                super.onInterceptTouchEvent(ev);
                return false;
        }
        return super.onInterceptTouchEvent(ev);
    }
}
