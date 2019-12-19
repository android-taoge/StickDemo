package com.tangtao.myrestudyandroid2.diff_conflict_widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

public class InMyListView extends ListView {

    public InMyListView(Context context) {
        this(context, null);
    }

    public InMyListView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public InMyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    private int mLastXTouch;
    private int mLastYTouch;


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        int x = (int) ev.getX();
        int y = (int) ev.getY();

        int action = ev.getAction() & MotionEvent.ACTION_MASK;
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                getParent().requestDisallowInterceptTouchEvent(true);
                break;

            case MotionEvent.ACTION_MOVE:
                int deltaX = x - mLastXTouch;
                int deltaY = y - mLastYTouch;
                if (Math.abs(deltaX) > Math.abs(deltaY)) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                } else {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                break;

            case MotionEvent.ACTION_UP:
                break;
        }

        mLastXTouch = x;
        mLastYTouch = y;
        return super.dispatchTouchEvent(ev);
    }
}
