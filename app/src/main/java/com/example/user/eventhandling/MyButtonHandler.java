package com.example.user.eventhandling;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

/**
 * Created by user on 2017-03-30.
 */

public class MyButtonHandler implements View.OnClickListener {
    private Context c;

    public MyButtonHandler(Context ctx) {
        c = ctx;
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(c, "First Button Clicked", Toast.LENGTH_SHORT).show();
    }
}
