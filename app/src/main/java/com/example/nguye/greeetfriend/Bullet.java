package com.example.nguye.greeetfriend;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import java.io.BufferedOutputStream;

public class Bullet {
    private int x, y;
    private Paint paint;
    private int stepY = 5;
    private int radius = 5;

    public Bullet(int color, int x, int y) {
        paint = new Paint(color);
        this.x = x;
        this.y = y;
    }

    public Boolean move() {
        y = y - stepY;
        if (y < radius) {
            return false;
        }
        return true;
    }

    public void draw(Canvas canvas) {
        canvas.drawCircle(x, y, radius, paint);
    }

    public RectF getRectF() {
        return new RectF(x - radius, y - radius, x + radius, y + radius);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
