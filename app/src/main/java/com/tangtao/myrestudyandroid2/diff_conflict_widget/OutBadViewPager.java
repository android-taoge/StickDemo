package com.tangtao.myrestudyandroid2.diff_conflict_widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

public class OutBadViewPager extends ViewPager {

    private int mLastXIntercept;
    private int mLastYIntercept;

    public OutBadViewPager(@NonNull Context context) {
        this(context, null);
    }

    public OutBadViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        int x = (int) ev.getX();
        int y = (int) ev.getY();
        boolean intercept = false;

        int action = ev.getAction() & MotionEvent.ACTION_MASK;
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                super.onInterceptTouchEvent(ev);
                intercept = false;
                break;

            case MotionEvent.ACTION_MOVE:
                int deltaX = x - mLastXIntercept;
                int deltaY = y - mLastYIntercept;
                if (Math.abs(deltaX) > Math.abs(deltaY)) {  //表明当前是水平滑动;
                    intercept = true;
                } else {                                     //表明当前是垂直滚动
                    intercept = false;
                }
                break;

            case MotionEvent.ACTION_UP:
                intercept = false;
                break;
        }

        mLastXIntercept = x;
        mLastYIntercept = y;
        return intercept;
    }
}
