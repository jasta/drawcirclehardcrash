package org.devtcg.bugreport.drawcirclehardcrash;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class CrashView extends View {
    private static final String TAG = CrashView.class.getSimpleName();

    private final Paint paint;
    private boolean tryCrash;

    public CrashView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CrashView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        paint = new Paint();
    }

    public void setTryCrash(boolean tryCrash) {
        if (this.tryCrash != tryCrash) {
            this.tryCrash = tryCrash;
            invalidate();

            if (tryCrash) {
                Log.i(TAG, "Next draw pass should trigger a crash.");
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (tryCrash) {
            Log.i(TAG, "Invoking drawCircle with infinite radius; should crash after this completes");
            canvas.drawCircle(0, 0, Float.POSITIVE_INFINITY, paint);
            Log.i(TAG, "Sayonara");
        }
    }
}
