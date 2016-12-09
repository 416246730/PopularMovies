package com.personal.alice.popularmovies.util;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.personal.alice.popularmovies.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import static android.content.ContentValues.TAG;

/**
 * Created by alice on 2016/11/29.
 */

public class PicassoUtil {

    public static void loagPic(Context context, ImageView imageView,String url){
        Log.i(TAG, "loagPic: "+url);
        final Context  mContext = context;
        Picasso.with(mContext).load(url)
                .placeholder(R.drawable.ic_border_load_pic)
                .into(imageView,new Callback() {
                    @Override
                    public void onSuccess() {
                    }
                    @Override
                    public void onError() {
                        Toast.makeText(mContext,R.string.alert_image_loading_unsuccessful,Toast.LENGTH_SHORT).show();
                    }
                });

    }
}
