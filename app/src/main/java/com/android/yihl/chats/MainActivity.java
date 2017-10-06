package com.android.yihl.chats;

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

        mListView = (ListView) findViewById(R.id.recipe_list_view);

        ChatMessage m1 = new ChatMessage("haha", TRUE);
        ChatMessage m2 = new ChatMessage("haha", FALSE);
        ChatMessage m3 = new ChatMessage("hahahahahahahahahahahahahahaha", TRUE);
        ArrayList<ChatMessage> messages = new ArrayList<ChatMessage>();
        messages.add(m1);
        messages.add(m2);
        messages.add(m3);
        MessageAdapter mAdapter = new MessageAdapter(this, messages);
        mListView.setAdapter(mAdapter);
    }

    private void buildChatClient(){
        Client client = new Client("henry","localhost",16790);
        client.begin();
    }
}
