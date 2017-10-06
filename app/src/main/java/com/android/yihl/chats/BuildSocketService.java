package com.android.yihl.chats;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;


public class BuildSocketService extends IntentService {
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.v("henry","onIntent");
        Client client = new Client("henry","localhost",16790);
        client.begin();
    }
    public BuildSocketService(){
        super("BuildSocketService");
        Log.v("henry","onIntent");
    }
}
