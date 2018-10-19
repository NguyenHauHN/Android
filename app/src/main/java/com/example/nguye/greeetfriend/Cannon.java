package com.example.nguye.greeetfriend;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Cannon {
    private int x;
    private Paint paint;
    private int width, height;
    private int stepX = 15;

    public Cannon(int color) {
        paint = new Paint(color);
    }

    public void setBound(int width, int height) {
        this.width = width;
        this.height = height;
        x = width / 2;
    }

    public void moveLeft() {
        if (x - 100 >= 0) {
            x = x - stepX;
        }
    }

    public void moveRight() {
        if (x + stepX <= width - 100) {
            x = x + stepX;
        }
    }

    public void draw(Canvas canvas) {
        canvas.drawLine(x, height, x, height - 100, paint);
        canvas.drawRect(x - 25, height - 50, x + 25, height - 25, paint);
        canvas.drawRect(x - 50, height - 25, x + 50, height, paint);
    }

    public int getX() {
        return x;
    }
}
