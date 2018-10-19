package com.example.nguye.greeetfriend;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Date;

public class ChatFriend extends AppCompatActivity implements View.OnClickListener {
    RecyclerView msgRecyclerView;
    EditText msgEditText;
    ImageButton sendBtn;
    MsgAdapter msgAdapter;
    ArrayList<Message> messages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_friend);

        msgEditText = findViewById(R.id.msgContent);
        sendBtn = findViewById(R.id.sendBtn);
        sendBtn.setOnClickListener(this);
        messages = new ArrayList<Message>();

        // xac dinh bo quan ly layout cho RecyclerView
        msgRecyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        msgRecyclerView.setLayoutManager(llm);

        // set adapter cho recycler view
        msgAdapter = new MsgAdapter(messages, this);
        msgRecyclerView.setAdapter(msgAdapter);
        msgAdapter.notifyDataSetChanged();

    }

    @Override
    public void onClick(View v) {
        String msgContent = msgEditText.getText().toString();
        Message message = new Message("Hoa Rom", msgContent, false, new Date());
        messages.add(message);
        message = new Message("Hauhau", "Ahihi", true, new Date());
        messages.add(message);
        msgEditText.setText("");
        msgRecyclerView.scrollToPosition(messages.size() - 1);
        msgAdapter.notifyDataSetChanged();
    }
}
