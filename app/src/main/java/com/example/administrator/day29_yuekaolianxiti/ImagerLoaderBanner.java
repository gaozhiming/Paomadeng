package com.example.administrator.day29_yuekaolianxiti;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;



public class ImagerLoaderBanner extends ImageLoader{
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {

        Glide.with(context).load(path).into(imageView);
    }
}
