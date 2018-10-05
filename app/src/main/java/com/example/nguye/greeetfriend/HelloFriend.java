package com.example.nguye.greeetfriend;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HelloFriend extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_friend);

        Intent intent = getIntent();
        String nameFriend = intent.getStringExtra("nameFriend");
        TextView helloFriend = (TextView) this.findViewById(R.id.helloFriend);
        helloFriend.setText("Hello " + nameFriend);
    }
}
