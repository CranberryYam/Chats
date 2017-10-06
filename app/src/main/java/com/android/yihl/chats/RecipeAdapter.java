package com.android.yihl.chats;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

public class RecipeAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<Recipe> mDataSource;

    public RecipeAdapter(Context context, ArrayList<Recipe> items){
        mContext = context;
        mDataSource = items;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
        // Get view for row item
        View rowView = mInflater.inflate(R.layout.list_item_recipe, parent, false);
        TextView titleTextView =
                (TextView) rowView.findViewById(com.android.yihl.chats.R.id.recipe_list_title);
        TextView subtitleTextView =
                (TextView) rowView.findViewById(com.android.yihl.chats.R.id.recipe_list_subtitle);
        TextView detailTextView =
                (TextView) rowView.findViewById(com.android.yihl.chats.R.id.recipe_list_detail);
        final ImageView thumbnailImageView =
                (ImageView) rowView.findViewById(com.android.yihl.chats.R.id.recipe_list_thumbnail);

        Recipe recipe = (Recipe) getItem(position);
        titleTextView.setText(recipe.title);
        subtitleTextView.setText(recipe.description);
        detailTextView.setText(recipe.label);
        Log.v("henry",recipe.imageUrl);
        Log.v("henry","good");
//        Picasso.with(mContext).load(recipe.imageUrl).placeholder(R.mipmap.ic_launcher).into(thumbnailImageView, new Callback() {
//            @Override
//            public void onSuccess() {
//                Log.v("henry","success");
//            }
//
//            @Override
//            public void onError() {
//                Log.v("henry", "fail");
//            }
//        });

        Picasso.Builder builder = new Picasso.Builder(mContext);
        builder.listener(new Picasso.Listener()
        {
            @Override
            public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception)
            {
                exception.printStackTrace();
                Log.v("henry", exception.getMessage());
            }
        });
        builder.build().load(recipe.imageUrl).into(thumbnailImageView);

        return rowView;
    }
}
