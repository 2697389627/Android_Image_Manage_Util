package com.webronin_26.android_image_manage_util.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.util.LruCache;

import com.jakewharton.disklrucache.DiskLruCache;
import com.webronin_26.android_image_manage_util.SetImageView;
import com.webronin_26.android_image_manage_util.ViewHolder;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.ByteBuffer;

public class ImageLruCacheManager {

    private final String IMAGE_FILE_NAME = "IMAGE_CACHE";

    private final int MAX_MEMOORY = ( int ) ( Runtime.getRuntime().maxMemory() );

    private int cacheSize = ( MAX_MEMOORY / 8 );


    private Context mContext = null;

    private long diskCacheSize = 1024 * 1024 * 50;

    private DiskLruCache mDiskLruCache = null;

    LruCache<String, Bitmap> mLruCache = null;


    private int targetWidth = 0;

    private int targetHeight = 0;

    private int showingRows = 1;

    private boolean isUsingDiskLRU = false;


    private HashkeyMD5 mHashkeyMD5 = null;


    public ImageLruCacheManager( int image_width, int image_height, int rows ) {

        targetWidth = image_width;

        targetHeight = image_height;

        showingRows = rows;

        mLruCache = new LruCache<String, Bitmap>( cacheSize ) {

            @Override
            protected int sizeOf( String string, Bitmap bitmap ) {

                return (bitmap.getRowBytes() * bitmap.getHeight() / 1024);
                // can also write like this : return value.getByteCount() / 1024;

            }

        };

    }

    public ImageLruCacheManager(Context context, int image_width, int image_height, int rows) {

        mContext = context.getApplicationContext();

        targetWidth = image_width;

        targetHeight = image_height;

        showingRows = rows;

        try {

            File storagePath = new File(mContext.getCacheDir(), IMAGE_FILE_NAME);

            mDiskLruCache = DiskLruCache.open( storagePath, 1, 1, diskCacheSize );

            isUsingDiskLRU = true;

        } catch ( Exception exception ) {

            isUsingDiskLRU = false;

        }

        mLruCache = new LruCache<String, Bitmap>( cacheSize ) {

            @Override
            protected int sizeOf(String string, Bitmap bitmap) {

                return (bitmap.getRowBytes() * bitmap.getHeight() / 1024);
                // can also write like this : return value.getByteCount() / 1024;

            }

        };

    }

    public void changeCacheSize( int newSizeMb ) {

        if ( ( 1024 * 1024 * newSizeMb ) >= ( MAX_MEMOORY / 8 ) ) {

            //  if the new size is too big
            //  we remain the default setting

        } else {

            diskCacheSize = 1024 * 1024 * newSizeMb;

        }

    }

    public void getImage( final String httpUrlString , final ViewHolder mViewHolder , final int position ) {

        new Thread(new Runnable() {

            @Override
            public void run() {

                if( mHashkeyMD5 == null )
                    mHashkeyMD5 = new HashkeyMD5();

                String httpUrlHashKey = mHashkeyMD5.hashkeyFromString( httpUrlString );

                Bitmap bitmap = null;

                bitmap = getInLruCache( httpUrlHashKey );

                if( bitmap != null ) {

                    new SetImageView( bitmap , mViewHolder , position );

                    putInLruCache( httpUrlHashKey , bitmap );

                }else {

                    bitmap = getInDiskLruCache( httpUrlHashKey );

                    if( bitmap != null ){

                        new SetImageView( bitmap , mViewHolder , position );

                        putInLruCache( httpUrlHashKey , bitmap );

                    } else {

                        downLoadFromInternet( httpUrlString , mViewHolder , position );

                    }

                }

            }

        }).start();

    }

    private Bitmap getInLruCache( String httpUrlHashKey ) {

        return mLruCache.get( httpUrlHashKey );

    }

    private Bitmap getInDiskLruCache( String httpUrlHashKey) {

        Bitmap bitmap = null;

        try {

            if ( isUsingDiskLRU ) {

                DiskLruCache.Snapshot snapshot = mDiskLruCache.get( httpUrlHashKey );

                if( snapshot != null ){

                    InputStream mInputStream = snapshot.getInputStream(0);

                    bitmap = BitmapFactory.decodeStream(mInputStream);

                }

            }

        } catch ( Exception exception ) {

            Log.e( "----------" , exception.toString() );

            return null;

        }

        return bitmap;

    }

    private void putInLruCache( String httpUrlHashKey , Bitmap bitmap ) {

        mLruCache.put( httpUrlHashKey , bitmap );

    }

    private void putInDiskLruCache( String httpUrlHashKey , Bitmap bitmap ) {

        if ( isUsingDiskLRU ) {

            OutputStream mOutputStream = null;

            try {

                DiskLruCache.Editor editor = mDiskLruCache.edit( httpUrlHashKey );

                mOutputStream = editor.newOutputStream(0);

                int bytes = bitmap.getByteCount();

                ByteBuffer mByteBuffer = ByteBuffer.allocate(bytes);

                bitmap.copyPixelsToBuffer(mByteBuffer);

                try {

                    mOutputStream.write(mByteBuffer.array());

                    editor.commit();

                } catch (Exception exception) {

                    editor.abort();

                }

            } catch ( Exception exception ) {

                Log.e( "----------" , exception.toString() );

            } finally {

                if (mOutputStream != null) {

                    try {

                        mOutputStream.close();

                    } catch ( IOException exception) {

                        Log.e( "----------" , exception.toString() );

                    }

                }

            }

        }

    }

    private void downLoadFromInternet( String httpUrlString , ViewHolder mViewHolder , int position ) {

        Bitmap bitmap = null;

        HttpURLConnection mHttpURLConnection = null;

        InputStream mInputStream = null;

        try {

            URL url = new URL( httpUrlString );

            mHttpURLConnection = (HttpURLConnection) url.openConnection();

            mHttpURLConnection.setReadTimeout(1000 * 4);
            mHttpURLConnection.setConnectTimeout(1000 * 4);
            mHttpURLConnection.setDoInput(true);
            mHttpURLConnection.setUseCaches(true);
            mHttpURLConnection.setRequestMethod("GET");

            mInputStream = mHttpURLConnection.getInputStream();

            int targetSize = mHttpURLConnection.getContentLength();

            byte[] targetByteArray = new byte[ targetSize ];

            mInputStream.read( targetByteArray );

            bitmap = new BitmapManageHelper().decodeFromByteArray( targetByteArray , targetHeight, targetWidth );

        } catch (Exception exception) {

            Log.e( "----------" , exception.toString() );

        } finally {

            try{

                if( mInputStream != null ) {

                    mInputStream.close();

                }

            }catch ( Exception e ) {

                Log.e( "----------" , e.toString() );

            }

            if (mHttpURLConnection != null) {

                mHttpURLConnection.disconnect();

            }

        }

        if( bitmap != null ) {

            String httpUrlHashKey = mHashkeyMD5.hashkeyFromString( httpUrlString );

            new SetImageView( bitmap , mViewHolder , position );

            putInLruCache( httpUrlHashKey , bitmap );

            putInDiskLruCache( httpUrlHashKey , bitmap );

        }

    }

}


