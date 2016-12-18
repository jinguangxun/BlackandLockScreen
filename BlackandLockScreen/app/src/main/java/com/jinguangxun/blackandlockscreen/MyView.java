package com.jinguangxun.blackandlockscreen;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.ViewGroup;

public class MyView extends ViewGroup {
    private Paint paint;

    public MyView(Context context){
        super(context);

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setARGB(255,0,0,0);
    }

    @Override
    protected void dispatchDraw(Canvas canvas){
        super.dispatchDraw(canvas);
        canvas.drawRect(0,0,4100,4100,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return true;
    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {

    }
}
