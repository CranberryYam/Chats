package com.android.yihl.chats;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class MainActivity extends AppCompatActivity {
    private ListView mListView;
    public BroadcastReceiver msmReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionbarTitleCenter();
        mListView = (ListView) findViewById(R.id.recipe_list_view);
        mockChatClient();
        Log.v("henry","........................");
        Intent socketIntent = new Intent(this,BuildSocketService.class);
        startService(socketIntent);
        msmReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Log.v("henry","got a broadcast");
            }
        };

    }
    private void actionbarTitleCenter(){
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar);
    }
    private void mockChatClient(){
        ChatMessage m1 = new ChatMessage("Hello", TRUE);
        ChatMessage m2 = new ChatMessage("Hi", FALSE);
        ChatMessage m3 = new ChatMessage("What's up?", TRUE);
        ChatMessage m4 = new ChatMessage("Nothing much", FALSE);
        ChatMessage m5 = new ChatMessage("Sometimes you gotta run before you can walk", TRUE);
        ChatMessage m6 = new ChatMessage("If you want to change the world, start with yourself", TRUE);
        ChatMessage m7 = new ChatMessage("u r so boring....", FALSE);
        ArrayList<ChatMessage> messages = new ArrayList<ChatMessage>();
        messages.add(m1);
        messages.add(m2);
        messages.add(m3);
        messages.add(m4);
        messages.add(m5);
        messages.add(m6);
        //messages.add(m7);
        MessageAdapter mAdapter = new MessageAdapter(this, messages);
        mListView.setAdapter(mAdapter);
    }

}
