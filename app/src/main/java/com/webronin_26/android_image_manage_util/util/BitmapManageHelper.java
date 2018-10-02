package com.webronin_26.android_image_manage_util.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapManageHelper implements BaseBitmapManageHelper {

    private BitmapCalculateSize mBitmapCalculateSize = null;

    @Override
    public Bitmap decodeFormResource(Resources res, int R_id, int height, int width) {

        BitmapFactory.Options options = new BitmapFactory.Options();

        options.inJustDecodeBounds = true;

        BitmapFactory.decodeResource( res, R_id, options );

        if ( mBitmapCalculateSize == null ) {

            mBitmapCalculateSize = new BitmapCalculateSize();

        }

        options.inSampleSize = mBitmapCalculateSize.BitmapCalculateSize(options, height, width);

        options.inJustDecodeBounds = false;

        return BitmapFactory.decodeResource(res, R_id, options);

    }


    @Override
    public Bitmap decodeFormFile(String file_path, int height, int width) {

        BitmapFactory.Options options = new BitmapFactory.Options();

        options.inJustDecodeBounds = true;

        BitmapFactory.decodeFile(file_path, options);


        if (mBitmapCalculateSize == null) {

            mBitmapCalculateSize = new BitmapCalculateSize();

        }

        options.inSampleSize = mBitmapCalculateSize.BitmapCalculateSize(options, height, width);


        options.inJustDecodeBounds = false;

        return BitmapFactory.decodeFile(file_path, options);
    }


    @Override
    public Bitmap decodeFromByteArray(byte[] array, int height, int width) {

        BitmapFactory.Options options = new BitmapFactory.Options();

        options.inJustDecodeBounds = true;

        BitmapFactory.decodeByteArray(array, 0, array.length, options);

        if (mBitmapCalculateSize == null) {

            mBitmapCalculateSize = new BitmapCalculateSize();

        }

        options.inSampleSize = mBitmapCalculateSize.BitmapCalculateSize(options, height, width);


        options.inJustDecodeBounds = false;

        return BitmapFactory.decodeByteArray(array, 0, array.length, options);

    }

}

