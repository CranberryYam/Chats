package com.android.yihl.chats;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MessageAdapter extends BaseAdapter {
    private Activity activity;
    private ArrayList<ChatMessage> mDataSource;
    private LayoutInflater mInflater;

    public MessageAdapter(Activity context, ArrayList<ChatMessage> items){
        activity = context;
        mDataSource = items;
        mInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return mDataSource.size();
    }


    @Override
    public Object getItem(int position) {
        return mDataSource.get(position);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ChatMessage message = mDataSource.get(position);
        View rowView;
        if (message.isMine() == true){
            rowView = mInflater.inflate(R.layout.item_chat_right,parent, false);
        }else {
            rowView = mInflater.inflate(R.layout.item_chat_left,parent,false);
        }
        TextView contentTextView = (TextView) rowView.findViewById(R.id.txt_msg);
        contentTextView.setText(message.getContent());
        ImageView photoImageView = (ImageView) rowView.findViewById(R.id.tex_photo);
        photoImageView.setImageResource(R.mipmap.ic_launcher);
        return  rowView;
    }
}
