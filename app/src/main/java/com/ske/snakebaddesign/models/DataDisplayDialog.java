package com.ske.snakebaddesign.models;

import android.content.DialogInterface;

/**
 * Created by Warata on 3/17/16 AD.
 */
public class DataDisplayDialog {
    private String title;
    private String message;
    private DialogInterface.OnClickListener listener;
    private int value;

    public DataDisplayDialog(String title, String message, DialogInterface.OnClickListener listener){
        this.title = title;
        this.message = message;
        this.listener = listener;
    }

    public DataDisplayDialog(int value){
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public DialogInterface.OnClickListener getListener() {
        return listener;
    }

    public int getValue() {
        return value;
    }
}
