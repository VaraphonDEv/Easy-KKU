package com.example.ooy.easykku;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by Ooy on 12/11/2559.
 */

public class MyAlert {
    private Context context;
    private int anInt;
    private String titleString, messageString;

    public MyAlert(Context context, int anInt, String titleString, String messageString) {
        this.context = context;
        this.anInt = anInt;
        this.titleString = titleString;
        this.messageString = messageString;
    }

    public void myDialog() {
        AlertDialog.Builder bulier = new AlertDialog.Builder(context);
        bulier.setCancelable(false);
        bulier.setIcon(anInt);
        bulier.setTitle(titleString);
        bulier.setMessage(messageString);
        bulier.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
               dialogInterface.dismiss();
            }
        });
        bulier.show();
    }
}