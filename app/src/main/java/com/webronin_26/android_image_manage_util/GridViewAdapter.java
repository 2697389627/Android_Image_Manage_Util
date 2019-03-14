package com.webronin_26.android_image_manage_util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.webronin_26.android_image_manage_util.util.ImageLruCacheManager;

import java.util.HashMap;

public class GridViewAdapter extends BaseAdapter {

    private Context mContext;
    private ImageLruCacheManager mImageLruCacheManager = null;
    public  static HashMap<ViewHolder, Integer> viewHolderItemMap;

    public GridViewAdapter( Context context, int imageViewWidth, int imageViewHeight) {

        mContext = context;
        mImageLruCacheManager = new ImageLruCacheManager( context, imageViewWidth, imageViewHeight);
        viewHolderItemMap = new HashMap<>();
    }

    @Override
    public int getCount() { return MainActivity.imageUrlStringArray.length; }

    @Override
    public Object getItem( int position ) { return MainActivity.imageUrlStringArray[ position ]; }

    @Override
    public long getItemId( int position ) { return 0; }

    @Override
    public View getView( int position, View convertView, ViewGroup parent ) {

        ViewHolder mViewHolder;
        LayoutInflater mLayoutInflater = LayoutInflater.from( mContext );

        if ( convertView == null ) {
            mViewHolder = new ViewHolder();
            convertView = mLayoutInflater.inflate( R.layout.image_view, null, false );
            mViewHolder.mImageView = convertView.findViewById( R.id.image_view );
            convertView.setTag( mViewHolder );

        } else {

            mViewHolder = ( ViewHolder ) convertView.getTag();

        }
        viewHolderItemMap.put( mViewHolder , position );
        mViewHolder.mImageView.setImageResource( R.drawable.white );
        mImageLruCacheManager.getImage( MainActivity.imageUrlStringArray[ position ], mViewHolder, position );
        return convertView;
    }
}