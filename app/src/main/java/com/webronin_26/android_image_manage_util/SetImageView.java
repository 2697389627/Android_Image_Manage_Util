package com.webronin_26.android_image_manage_util;

import android.graphics.Bitmap;
import android.os.AsyncTask;

public class SetImageView extends AsyncTask<Void , Void , Void> {

    private Bitmap mBitmap = null;

    private ViewHolder mViewHolder = null;

    private int position = 0;

    public SetImageView( Bitmap bitmap , ViewHolder viewHolder , int Position ) {

        mBitmap = bitmap;

        mViewHolder = viewHolder;

        position = Position;

        this.execute();

    }

    @Override
    protected Void doInBackground(Void... voids) {
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {

        super.onPostExecute(aVoid);

        if ( GridViewAdapter.viewHolderItemMap.get( mViewHolder ) != position ) {

            // do nothing

        } else {

            mViewHolder.mImageView.setImageBitmap( mBitmap );

        }

    }
}
