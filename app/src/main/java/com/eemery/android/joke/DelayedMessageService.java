package com.eemery.android.joke;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

public class DelayedMessageService extends IntentService {

    public static final String EXTRA_MESSAGE = "message";

    public DelayedMessageService() {
        super("DelayedMessageService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        synchronized (this) {
            try {
                wait(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        showText(intent.getStringExtra(EXTRA_MESSAGE));
    }

    private void showText(final String stringExtra) {
        Log.v("DelayedMessageService", "The message is: " + stringExtra);
    }
}
