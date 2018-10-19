package com.example.nguye.greeetfriend;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

public class Explosion {
    private int x, y;
    private Bitmap explosion;
    private int count = 24;

    public Explosion(int x, int y, Context context) {
        this.x = x;
        this.y = y;
        explosion = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.bum),
                50, 50, false);
    }

    public Boolean draw(Canvas canvas) {
        count = count - 1;
        if (count >= 0) {
            canvas.drawBitmap(explosion, x,y, null);
            return true;
        }
        return false;
    }
}
