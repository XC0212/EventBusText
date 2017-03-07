package com.example.administrator.eventbus_text;

/**
 * Created by Administrator on 2017/2/20.
 */

public class MessageEvent {
    private String message;

    public MessageEvent(String message) {
        this.message = message;

    }
    public String getMessage(){
        return message;
    }
}
