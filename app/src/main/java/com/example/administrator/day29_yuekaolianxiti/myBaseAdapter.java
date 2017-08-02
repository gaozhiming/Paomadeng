package com.example.administrator.day29_yuekaolianxiti;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.List;

/**
 * date 2017/7/24
 * author:张学雷(Administrator)
 * functinn:
 */

public class myBaseAdapter extends BaseAdapter {
    private List<myBean.NewslistBean.NewsBean> list;
    private Context context;

    public myBaseAdapter(List<myBean.NewslistBean.NewsBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder holder = null;
        if (convertView == null) {
            holder = new viewHolder();
            convertView = View.inflate(context,R.layout.item,null);

            holder.image = (ImageView) convertView.findViewById(R.id.image_image);
            holder.title = (TextView) convertView.findViewById(R.id.title_title);

            convertView.setTag(holder);

        }else{
            holder= (viewHolder) convertView.getTag();

        }

        holder.title.setText(list.get(position).title);

        //这步骤是用imageloder加载图片的
                DisplayImageOptions displayImageOptions = new DisplayImageOptions.Builder()
                        .cacheInMemory(true)
                        .cacheOnDisk(true)  .build();
                ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
                        .defaultDisplayImageOptions(displayImageOptions)
                        .build();
                ImageLoader.getInstance().init(config);
                ImageLoader.getInstance().displayImage(list.get(position).image, holder.image);



        return convertView;
    }

    class viewHolder {

        ImageView image;
        TextView title;


    }
}
