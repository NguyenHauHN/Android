package com.example.nguye.greeetfriend.customview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.nguye.greeetfriend.Bullet;
import com.example.nguye.greeetfriend.R;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private Button leftBtn, rightBtn, shootBtn;
    private DrawView drawView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        leftBtn = findViewById(R.id.leftBtn);
        rightBtn = findViewById(R.id.rightBtn);
        shootBtn = findViewById(R.id.shootBtn);
        leftBtn.setOnClickListener(this);
        rightBtn.setOnClickListener(this);
        shootBtn.setOnClickListener(this);
        drawView = findViewById(R.id.drawView);
    }

    @Override
    public void onClick(View v) {
        if (v == leftBtn) {
            drawView.moveLeft();
        } else if (v == rightBtn) {
            drawView.moveRight();
        } else {
            drawView.shoot();
        }
    }
}
