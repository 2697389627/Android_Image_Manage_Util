package com.webronin_26.android_image_manage_util.util;

import android.graphics.BitmapFactory;


public class BitmapCalculateSize {

    private int resHeight , resWidth , targetHeight , targetWidth , sampleSize;

    public BitmapCalculateSize(){

        resHeight = 0;
        resWidth = 0;
        targetHeight = 0;
        targetWidth = 0;
        sampleSize = 1;

    }

    public int BitmapCalculateSize( BitmapFactory.Options options , int target_height , int target_width ) {

        resHeight = options.outHeight;
        resWidth = options.outWidth;

        this.targetHeight = target_height;
        this.targetWidth = target_width;

        calculate();

        return sampleSize;

    }


    private void calculate() {

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