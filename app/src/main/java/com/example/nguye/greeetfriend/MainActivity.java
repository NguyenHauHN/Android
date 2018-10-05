package com.example.nguye.greeetfriend;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
//
//    Button btnClick;
//    EditText nameFriend;

    Button btnSend;
    EditText msgEditText;
    ListView listViewMsg;
    MyAdapter myAdapter = null;
    ArrayList<Message> messages = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        btnClick = (Button) this.findViewById(R.id.btnClick);
//        btnClick.setOnClickListener(this);
//        Log.w("MainActivity", "onCreate: ");

        btnSend = (Button) this.findViewById(R.id.btnSend);
        btnSend.setOnClickListener(this);

        msgEditText = (EditText) this.findViewById(R.id.msgEditText);

        // thiết lập adapter cho listview
        listViewMsg = (ListView) this.findViewById(R.id.listViewMsg);
        messages = new ArrayList<Message>();
        myAdapter = new MyAdapter(this, messages);
        listViewMsg.setAdapter((ListAdapter) myAdapter);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnSend:
                String messageString = msgEditText.getText().toString();
                if (!messageString.equals("")) {
                    messages.add(new Message("", messageString, true, new Date()));
                    messages.add(new Message("", messageString, false, new Date()));

                    myAdapter.notifyDataSetChanged();
                    listViewMsg.post(new Runnable() {
                        @Override
                        public void run() {
                            listViewMsg.setSelection(myAdapter.getCount() - 1);
                        }
                    });
                }
                break;
            default:
                break;
        }
    }

//    @Override
//    public void onClick(View v) {
//        Intent intent = new Intent(this, ListFriend.class);
//        startActivity(intent);
//
//        Log.w("MainActivity", "onClick: ");
//    }
}
