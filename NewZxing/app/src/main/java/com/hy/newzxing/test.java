package com.hy.newzxing;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by xtich on 2018/1/16.
 */

public class test extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"OK",Toast.LENGTH_SHORT).show();

    }
}
