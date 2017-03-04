package com.nathanielmorihara.ourmessenger;

import java.util.Date;

/**
 * Created by Nathaniel on 3/4/2017.
 */

public class ChatMessage {

    private String messageText;
    private String messageUser;
    //private long messageTime;

    public ChatMessage(String messageText, String messageUser) {
        this.messageText = messageText;
        this.messageUser = messageUser;

        //initialize to current time
        //messageTime = new Date().getTime();
    }

    public ChatMessage() {}

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getMessageUser() {
        return messageUser;
    }

    public void setMessageUser(String messageUser) {
        this.messageUser = messageUser;
    }
//
//    public long getMessageTime() {
//        return getMessageTime();
//    }
//
//    public void setMessageTime(long messageTime) {
//        this.messageTime = messageTime;
//    }
}
