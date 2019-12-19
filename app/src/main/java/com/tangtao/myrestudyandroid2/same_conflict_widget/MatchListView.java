package com.tangtao.myrestudyandroid2.same_conflict_widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

public class MatchListView extends ListView {
    public MatchListView(Context context) {
        this(context, null);
    }

    public MatchListView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MatchListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST));
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        int action = ev.getAction() & MotionEvent.ACTION_MASK;
        switch (action) {

            case MotionEvent.ACTION_DOWN:
                getParent().requestDisallowInterceptTouchEvent(false);
                break;

            case MotionEvent.ACTION_MOVE:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

                    if (this.canScrollVertically(-1)) {  //-1表示向下滑动  true 还没到顶， false 到顶了不能在下滑了
                        getParent().requestDisallowInterceptTouchEvent(true);

                    } else {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }

                    if (this.canScrollVertically(1)) {  //1表示向上滑动  true 还没到底， false 到底了不能往上滑了
                        getParent().requestDisallowInterceptTouchEvent(true);
                    } else {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                }

            case MotionEvent.ACTION_UP:
                break;

        }

        return super.dispatchTouchEvent(ev);
    }
}
