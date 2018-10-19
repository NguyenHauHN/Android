package com.example.nguye.greeetfriend;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

public class AndroidGuy {
    private int x, y;
    private int stepY = 5;
    private Bitmap androidGuy;
    private int width, height;
    private Context context;
    private Paint paint;

    public AndroidGuy(Context context) {
        this.context = context;
        androidGuy = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher),
                50, 50, false);
        paint = new Paint(Color.BLUE);
    }

    public Boolean move() {
        y = y + stepY;
        if (y >= height) {
            return false;
        }
        return true;
    }

    public void reset() {
        y = 0;
        x = (int) ((width - 50) * Math.random());
    }

    public void setBound(int width, int height) {
        this.width = width;
        this.height = height;
        y = 0;
        x = (int) ((width - 50) * Math.random());
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(androidGuy, x, y, null);
    }

    public RectF getRectF() {
        return new RectF(x, y, x + 50, y + 50);
    }
}
