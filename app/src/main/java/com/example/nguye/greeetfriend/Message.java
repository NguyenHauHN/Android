package com.example.nguye.greeetfriend;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {
    private String fromName,message;
    private boolean isFromMe;
    private Date date;

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isFromMe() {
        return isFromMe;
    }

    public void setFromMe(boolean fromMe) {
        isFromMe = fromMe;
    }

    public String getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
        return sdf.format(date);
    }

    public String getTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
        return sdf.format(date);
    }

    public Message(String fromName, String message, boolean isFromMe, Date date) {
        this.fromName = fromName;
        this.message = message;
        this.isFromMe = isFromMe;
        this.date = date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Message() {

    }
}
