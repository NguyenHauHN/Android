package com.example.nguye.greeetfriend.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

import com.example.nguye.greeetfriend.AndroidGuy;
import com.example.nguye.greeetfriend.Bullet;
import com.example.nguye.greeetfriend.Cannon;
import com.example.nguye.greeetfriend.Explosion;
import com.example.nguye.greeetfriend.R;

import java.util.ArrayList;

public class DrawView extends View {

    private int width, height;
    private AndroidGuy androidGuy;
    private Cannon cannon;
    private ArrayList<Bullet> bullets;
    private ArrayList<Explosion> explosions;
    private Context context;


    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        androidGuy = new AndroidGuy(context);
        cannon = new Cannon(Color.BLUE);
        bullets = new ArrayList<Bullet>();
        explosions = new ArrayList<Explosion>();
        this.context = context;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
        androidGuy.setBound(w, h);
        cannon.setBound(w, h);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawGameLoad(canvas);
        try {
            Thread.sleep(30);
        } catch (Exception e) {

        }
        invalidate();
    }

    public void drawGameLoad(Canvas canvas) {
        cannon.draw(canvas);
        androidGuy.draw(canvas);
        for (int i = bullets.size() - 1; i >= 0; i--) {
            Bullet bullet = bullets.get(i);
            bullet.draw(canvas);
            if (RectF.intersects(androidGuy.getRectF(), bullet.getRectF())) {
                androidGuy.reset();
                bullets.remove(i);
                Explosion explosion = new Explosion(bullet.getX(), bullet.getY(), context);
                explosions.add(explosion);
                explosion.draw(canvas);
            } else {
                bullet.move();
            }
        }

        for (int i = explosions.size() - 1; i >= 0; i--) {
            Explosion explosion = explosions.get(i);
            if (explosion.draw(canvas) == false) {
                explosions.remove(i);
            }
        }

        if (androidGuy.move() == false) {
            androidGuy.reset();
        }
    }

    public void moveLeft() {
        cannon.moveLeft();
    }

    public void moveRight() {
        cannon.moveRight();
    }

    public void shoot() {
        Bullet bullet = new Bullet(Color.RED, cannon.getX(), height - 100);
        bullets.add(bullet);
    }
}
