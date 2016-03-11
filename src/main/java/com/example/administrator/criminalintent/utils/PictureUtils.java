package com.example.administrator.criminalintent.utils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.view.Display;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/3/11.
 */
public class PictureUtils {
    public static BitmapDrawable getScaledDrawable(Activity a,String path){
        Display display=a.getWindowManager().getDefaultDisplay();
        Point destPoint=new Point();
        display.getSize(destPoint);
        float destWidth=destPoint.x;
        float destHeight=destPoint.y;

        BitmapFactory.Options options=new BitmapFactory.Options();
        options.inJustDecodeBounds=true;
        BitmapFactory.decodeFile(path,options);

        float srcWidth=options.outWidth;
        float srcHeight=options.outHeight;

        int inSampleSize=1;
        if (srcHeight>destHeight||srcWidth>destWidth){
            if (srcHeight>srcWidth){
                inSampleSize=Math.round(srcWidth/destWidth);
            }else {
                inSampleSize=Math.round(srcHeight/destHeight);
            }
        }
        options.inJustDecodeBounds=false;
        options.inSampleSize=inSampleSize;

        Bitmap bitmap=BitmapFactory.decodeFile(path,options);
        return new BitmapDrawable(a.getResources(),bitmap);
    }

    public static void cleanImageView(ImageView imageView){
        if (!(imageView.getDrawable() instanceof BitmapDrawable))
            return;
        BitmapDrawable b= (BitmapDrawable) imageView.getDrawable();
        b.getBitmap().recycle();
        imageView.setImageDrawable(null);
    }
}
