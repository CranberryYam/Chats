package com.android.yihl.chats;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class MainActivity extends AppCompatActivity {
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar);

        mListView = (ListView) findViewById(R.id.recipe_list_view);

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

    private void buildChatClient(){
        Client client = new Client("henry","localhost",16790);
        client.begin();
    }
}
