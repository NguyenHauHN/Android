package com.example.nguye.greeetfriend;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    String[] names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        names = getResources().getStringArray(R.array.list_friend);
        ListView listFriend = findViewById(R.id.listFriend);
        listFriend.setAdapter(new ArrayAdapter<>(this, R.layout.item_friend, names));
        listFriend.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent in = new Intent(this, ChatFriend.class);
        in.putExtra("nameFriend", names[position]);
        startActivity(in);
    }
}
