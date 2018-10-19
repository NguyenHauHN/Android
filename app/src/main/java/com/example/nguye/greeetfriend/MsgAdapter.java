package com.example.nguye.greeetfriend;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MsgAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<Message> messages;
    Context context;
    private final int TYPE1 = 1;
    private final int TYPE2 = 2;

    public MsgAdapter(ArrayList<Message> messages, Context context) {
        this.messages = messages;
        this.context = context;
    }

    public static class ViewHolderType1 extends RecyclerView.ViewHolder { // cho hien thi thong diep cua ban
        public TextView contentLeftMsg;
        public TextView timeLeftMsg;
        public TextView nameLeftMsg;

        public ViewHolderType1(@NonNull View itemView) {
            super(itemView);
            this.contentLeftMsg = itemView.findViewById(R.id.contentLeftMsg);
            this.timeLeftMsg = itemView.findViewById(R.id.timeLeftMsg);
            this.nameLeftMsg = itemView.findViewById(R.id.nameLeftMsg);
        }
    }


    public static class ViewHolderType2 extends RecyclerView.ViewHolder { //cho hien thi thong diep cua minh
        public TextView contentRightMsg;
        public TextView timeRightMsg;
        public TextView nameRightMsg;

        public ViewHolderType2(@NonNull View itemView) {
            super(itemView);
            this.contentRightMsg = itemView.findViewById(R.id.contentRightMsg);
            this.timeRightMsg = itemView.findViewById(R.id.timeRightMsg);
            this.nameRightMsg = itemView.findViewById(R.id.nameRightMsg);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        if(viewType == TYPE1){
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_left_msg, parent, false);
            return new ViewHolderType1(v);
        }
        else{
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_right_msg, parent, false);
            return new ViewHolderType2(v);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Message message = messages.get(position);
        if(getItemViewType(position) == TYPE1){
            ViewHolderType1 viewholderType1 = (ViewHolderType1) holder;
            TextView contentLeftMsg = viewholderType1.contentLeftMsg;
            contentLeftMsg.setText(message.getMessage());
            TextView timeLeftMsg = viewholderType1.timeLeftMsg;
            timeLeftMsg.setText(message.getTime());
            TextView nameLeftMsg = viewholderType1.nameLeftMsg;
            nameLeftMsg.setText(message.getFromName());
        }
        else{
            ViewHolderType2 viewholderType2 = (ViewHolderType2) holder;
            TextView contentRightMsg = viewholderType2.contentRightMsg;
            contentRightMsg.setText(message.getMessage());
            TextView timeRightMsg = viewholderType2.timeRightMsg;
            timeRightMsg.setText(message.getTime());
            TextView nameRightMsg = viewholderType2.nameRightMsg;
            nameRightMsg.setText(message.getFromName());
        }
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (messages.get(position).isFromMe() == true) {
            return TYPE2;
        } else {
            return TYPE1;
        }
    }
}
