package com.example.nguye.greeetfriend;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

// adapter để lấy dữ liệu cho listview và quy định cách hiển thị các mục trong 1 item listview
public class MyAdapter extends ArrayAdapter<Message> {

    private final Context context;
    private final ArrayList<Message> messages;

    public MyAdapter(@NonNull Context context, ArrayList<Message> messages) {
        super(context, R.layout.item_sms_send, messages);
        this.context = context;
        this.messages = messages;
    }


    // hiển thị dữ liệu cho listview, được gọi mỗi lần render ra một mục của listview
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View msgView;
        Message message = this.messages.get(position);
        //
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // tham chieu toi activity mess
        if (message.isFromMe()){
            msgView = inflater.inflate(R.layout.item_sms_send, parent, false);
            // set gia tri cho 2 textview-+
            TextView timeTextView = (TextView) msgView.findViewById(R.id.timeMsg);
            timeTextView.setText(message.getTime());
            TextView msgTextView = (TextView) msgView.findViewById(R.id.messageContent);
            msgTextView.setText(message.getMessage());
        }
        else {
            msgView = inflater.inflate(R.layout.item_sms_reply, parent, false);
            TextView replyContent = (TextView) msgView.findViewById(R.id.replyContent);
            // set gia tri cho 2 textview-+
            replyContent.setText("Hello!");
            TextView timeReply = (TextView) msgView.findViewById(R.id.timeReply);
            SimpleDateFormat sdf = new SimpleDateFormat("h:mm a*");
            timeReply.setText(sdf.format(new Date()));
        }


        return msgView;
    }
}
