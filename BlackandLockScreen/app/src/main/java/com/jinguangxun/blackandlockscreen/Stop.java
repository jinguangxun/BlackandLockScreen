package com.jinguangxun.blackandlockscreen;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class Stop extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent intents = new Intent(context, MyService.class);
        context.stopService(intents);
    }
}
