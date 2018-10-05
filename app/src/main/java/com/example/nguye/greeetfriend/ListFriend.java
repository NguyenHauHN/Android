package com.example.nguye.greeetfriend;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListFriend extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_friend);

        Resources res = getResources();
        String[] list = res.getStringArray(R.array.list_friend);

        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(this, R.layout.friend_item, R.id.nameFriend, list);

        ListView listView = (ListView) findViewById(R.id.listFriend);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        // Get the selected item text from ListView
        String nameFriend = (String) parent.getItemAtPosition(position);
        Intent in = new Intent(this, HelloFriend.class);
        in.putExtra("nameFriend", nameFriend);
        startActivity(in);
    }
}
