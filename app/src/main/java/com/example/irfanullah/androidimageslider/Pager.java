package com.example.irfanullah.androidimageslider;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.VideoView;

public class Pager extends PagerAdapter {
    private Context context;
    private int images[] = {R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four};

    public Pager(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        if(position == 10){
            View view = LayoutInflater.from(context).inflate(R.layout.video_layout,container,false);
            VideoView iv = view.findViewById(R.id.videoView);
           String videoPath = "android.resource://" + context.getPackageName() + "/" + R.raw.kotlin;
            Uri uri = Uri.parse(videoPath);
            iv.setVideoURI(uri);
            iv.start();
            Log.i("working",Integer.toString(images[position]));
            container.addView(view);
            return view;
        }else {
        View view = LayoutInflater.from(context).inflate(R.layout.image_layout,container,false);
        ImageView iv = view.findViewById(R.id.imageView);
        iv.setImageResource(images[position]);
        Log.i("working",Integer.toString(images[position]));
        container.addView(view);
        return view;
        }
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return (view == (LinearLayout) o);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
       // super.destroyItem(container, position, object);
        container.removeView((View)object);
    }
}
