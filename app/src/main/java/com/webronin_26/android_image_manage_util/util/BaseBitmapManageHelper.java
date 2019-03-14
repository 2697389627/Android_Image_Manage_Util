package com.webronin_26.android_image_manage_util.util;


import android.content.res.Resources;
import android.graphics.Bitmap;

import java.io.InputStream;

public interface BaseBitmapManageHelper {

    /**
     *  This methods is only use to manage image from resource
     *  you should input :
     *  1. currently context's( Activity's ) Resource ( getContext( ) . getResource( ) )
     *  2. the image target's ID as Integer
     *  3. the height & width where the image place you want to show
     */
    public Bitmap decodeFormResource( Resources res, int R_id, int height, int width );

    /**
     *  This methods is only use to manage image from file path
     *  you should input :
     *  1. Target image's file path
     *  2. the height & width where the image place you want to show
     */
    public Bitmap decodeFormFile(String file_path, int height, int width);

    /**
     *  This methods is only use to manage image which is byte-array type
     *  you should input :
     *  1. Target image's byte-array data
     *  2. the height & width where the image place you want to show
     */
    public Bitmap decodeFromByteArray(byte[] array, int height, int width);

}
