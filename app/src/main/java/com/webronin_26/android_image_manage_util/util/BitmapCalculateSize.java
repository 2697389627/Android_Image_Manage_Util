package com.webronin_26.android_image_manage_util.util;

import android.graphics.BitmapFactory;


public class BitmapCalculateSize {

    private int resHeight = 0;

    private int resWidth = 0;

    private int targetHeight = 0;

    private int targetWidth = 0;

    private int sampleSize = 1;

    public void init(){

        resHeight = 0;

        resWidth = 0;

        targetHeight = 0;

        targetWidth = 0;

        sampleSize = 1;

    }

    public int BitmapCalculateSize( BitmapFactory.Options options , int target_height , int target_width ){

        init();

        resHeight = options.outHeight;

        resWidth = options.outWidth;

        this.targetHeight = target_height;

        this.targetWidth = target_width;

        calculate( options );

        return sampleSize;

    }


    public void calculate( BitmapFactory.Options options ){

        if( resHeight > targetHeight || resWidth > targetWidth ){

            int half_res_height = resHeight / 2;

            int half_res_width = resWidth / 2;

            while( ( half_res_height / sampleSize ) >= targetHeight &&
                    ( half_res_width / sampleSize ) >= targetWidth ){

                sampleSize *= 2;

            }

        }

    }

}