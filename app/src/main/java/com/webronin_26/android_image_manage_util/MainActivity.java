package com.webronin_26.android_image_manage_util;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.gridview)
    GridView mGridView;

    private int imageViewWidth = 0;

    private int imageViewHeight = 0;

    GridViewAdapter mGridViewAdapter = null;

    public static String[] imageUrlStringArray = {

            "https://i.imgur.com/oaZSIBt.jpg"
            , "https://i.imgur.com/pc1MsWc.jpg"
            , "https://i.imgur.com/PT2n6Bk.jpg"
            , "https://i.imgur.com/HJqq96y.jpg"
            , "https://i.imgur.com/x3fBTTo.png"
            , "https://i.imgur.com/ivkcfKm.jpg"
            , "https://i.imgur.com/LxTWyzF.jpg"
            , "https://i.imgur.com/luXLnVc.jpg"
            , "https://i.imgur.com/5AIspcc.jpg"
            , "https://i.imgur.com/ZGyZuQY.jpg"
            , "https://i.imgur.com/PLqoi16.jpg"
            , "https://i.imgur.com/idrXfUG.jpg"
            , "https://i.imgur.com/Rh0C4jf.jpg"
            , "https://i.imgur.com/DAUCOla.jpg"
            , "https://i.imgur.com/ygLjoMU.jpg"
            , "https://i.imgur.com/S2vL0co.jpg"
            , "https://i.imgur.com/SMAm793.jpg"
            , "https://i.imgur.com/L42vyKM.jpg"
            , "https://i.imgur.com/CwlJROQ.jpg"
            , "https://i.imgur.com/fGZpia5.jpg"
            , "https://i.imgur.com/924R0ik.jpg"
            , "https://i.imgur.com/pc1MsWc.jpg"
            , "https://i.imgur.com/PT2n6Bk.jpg"
            , "https://i.imgur.com/HJqq96y.jpg"
            , "https://i.imgur.com/x3fBTTo.png"
            , "https://i.imgur.com/ivkcfKm.jpg"
            , "https://i.imgur.com/LxTWyzF.jpg"
            , "https://i.imgur.com/luXLnVc.jpg"
            , "https://i.imgur.com/5AIspcc.jpg"
            , "https://i.imgur.com/ZGyZuQY.jpg"
            , "https://i.imgur.com/PLqoi16.jpg"
            , "https://i.imgur.com/idrXfUG.jpg"
            , "https://i.imgur.com/Rh0C4jf.jpg"
            , "https://i.imgur.com/DAUCOla.jpg"
            , "https://i.imgur.com/ygLjoMU.jpg"
            , "https://i.imgur.com/S2vL0co.jpg"
            , "https://i.imgur.com/SMAm793.jpg"
            , "https://i.imgur.com/L42vyKM.jpg"
            , "https://i.imgur.com/CwlJROQ.jpg"
            , "https://i.imgur.com/fGZpia5.jpg"
            , "https://i.imgur.com/924R0ik.jpg"
            , "https://i.imgur.com/pc1MsWc.jpg"
            , "https://i.imgur.com/PT2n6Bk.jpg"
            , "https://i.imgur.com/HJqq96y.jpg"
            , "https://i.imgur.com/x3fBTTo.png"
            , "https://i.imgur.com/ivkcfKm.jpg"
            , "https://i.imgur.com/LxTWyzF.jpg"
            , "https://i.imgur.com/luXLnVc.jpg"
            , "https://i.imgur.com/5AIspcc.jpg"
            , "https://i.imgur.com/ZGyZuQY.jpg"
            , "https://i.imgur.com/PLqoi16.jpg"
            , "https://i.imgur.com/idrXfUG.jpg"
            , "https://i.imgur.com/Rh0C4jf.jpg"
            , "https://i.imgur.com/DAUCOla.jpg"
            , "https://i.imgur.com/ygLjoMU.jpg"
            , "https://i.imgur.com/S2vL0co.jpg"
            , "https://i.imgur.com/SMAm793.jpg"
            , "https://i.imgur.com/L42vyKM.jpg"
            , "https://i.imgur.com/CwlJROQ.jpg"
            , "https://i.imgur.com/fGZpia5.jpg"
            , "https://i.imgur.com/924R0ik.jpg"
            , "https://i.imgur.com/CwlJROQ.jpg"
            , "https://i.imgur.com/fGZpia5.jpg"
            , "https://i.imgur.com/924R0ik.jpg"
            , "https://i.imgur.com/pc1MsWc.jpg"
            , "https://i.imgur.com/PT2n6Bk.jpg"
            , "https://i.imgur.com/HJqq96y.jpg"
            , "https://i.imgur.com/x3fBTTo.png"
            , "https://i.imgur.com/ivkcfKm.jpg"
            , "https://i.imgur.com/LxTWyzF.jpg"
            , "https://i.imgur.com/luXLnVc.jpg"
            , "https://i.imgur.com/5AIspcc.jpg"
            , "https://i.imgur.com/ZGyZuQY.jpg"
            , "https://i.imgur.com/PLqoi16.jpg"
            , "https://i.imgur.com/idrXfUG.jpg"
            , "https://i.imgur.com/Rh0C4jf.jpg"
            , "https://i.imgur.com/DAUCOla.jpg"
            , "https://i.imgur.com/ygLjoMU.jpg"
            , "https://i.imgur.com/S2vL0co.jpg"
            , "https://i.imgur.com/SMAm793.jpg"
            , "https://i.imgur.com/L42vyKM.jpg"
            , "https://i.imgur.com/CwlJROQ.jpg"
            , "https://i.imgur.com/fGZpia5.jpg"
            , "https://i.imgur.com/924R0ik.jpg"
            , "https://i.imgur.com/pc1MsWc.jpg"
            , "https://i.imgur.com/PT2n6Bk.jpg"
            , "https://i.imgur.com/CwlJROQ.jpg"
            , "https://i.imgur.com/fGZpia5.jpg"
            , "https://i.imgur.com/924R0ik.jpg"
            , "https://i.imgur.com/pc1MsWc.jpg"
            , "https://i.imgur.com/PT2n6Bk.jpg"
            , "https://i.imgur.com/HJqq96y.jpg"
            , "https://i.imgur.com/x3fBTTo.png"
            , "https://i.imgur.com/ivkcfKm.jpg"
            , "https://i.imgur.com/LxTWyzF.jpg"
            , "https://i.imgur.com/luXLnVc.jpg"
            , "https://i.imgur.com/5AIspcc.jpg"
            , "https://i.imgur.com/ZGyZuQY.jpg"
            , "https://i.imgur.com/PLqoi16.jpg"
            , "https://i.imgur.com/idrXfUG.jpg"
            , "https://i.imgur.com/Rh0C4jf.jpg"
            , "https://i.imgur.com/DAUCOla.jpg"
            , "https://i.imgur.com/ygLjoMU.jpg"
            , "https://i.imgur.com/S2vL0co.jpg"
            , "https://i.imgur.com/SMAm793.jpg"
            , "https://i.imgur.com/L42vyKM.jpg"
            , "https://i.imgur.com/CwlJROQ.jpg"
            , "https://i.imgur.com/fGZpia5.jpg"
            , "https://i.imgur.com/924R0ik.jpg"
            , "https://i.imgur.com/pc1MsWc.jpg"
            , "https://i.imgur.com/PT2n6Bk.jpg"
            , "https://i.imgur.com/CwlJROQ.jpg"
            , "https://i.imgur.com/fGZpia5.jpg"
            , "https://i.imgur.com/924R0ik.jpg"
            , "https://i.imgur.com/pc1MsWc.jpg"
            , "https://i.imgur.com/PT2n6Bk.jpg"
            , "https://i.imgur.com/HJqq96y.jpg"
            , "https://i.imgur.com/x3fBTTo.png"
            , "https://i.imgur.com/ivkcfKm.jpg"
            , "https://i.imgur.com/LxTWyzF.jpg"
            , "https://i.imgur.com/luXLnVc.jpg"
            , "https://i.imgur.com/5AIspcc.jpg"
            , "https://i.imgur.com/ZGyZuQY.jpg"
            , "https://i.imgur.com/PLqoi16.jpg"
            , "https://i.imgur.com/idrXfUG.jpg"
            , "https://i.imgur.com/Rh0C4jf.jpg"
            , "https://i.imgur.com/DAUCOla.jpg"
            , "https://i.imgur.com/ygLjoMU.jpg"
            , "https://i.imgur.com/S2vL0co.jpg"
            , "https://i.imgur.com/SMAm793.jpg"
            , "https://i.imgur.com/L42vyKM.jpg"
            , "https://i.imgur.com/CwlJROQ.jpg"
            , "https://i.imgur.com/fGZpia5.jpg"
            , "https://i.imgur.com/924R0ik.jpg"
            , "https://i.imgur.com/pc1MsWc.jpg"
            , "https://i.imgur.com/PT2n6Bk.jpg"
            , "https://i.imgur.com/CwlJROQ.jpg"
            , "https://i.imgur.com/fGZpia5.jpg"
            , "https://i.imgur.com/924R0ik.jpg"
            , "https://i.imgur.com/pc1MsWc.jpg"
            , "https://i.imgur.com/PT2n6Bk.jpg"
            , "https://i.imgur.com/HJqq96y.jpg"
            , "https://i.imgur.com/x3fBTTo.png"
            , "https://i.imgur.com/ivkcfKm.jpg"
            , "https://i.imgur.com/LxTWyzF.jpg"
            , "https://i.imgur.com/luXLnVc.jpg"
            , "https://i.imgur.com/5AIspcc.jpg"
            , "https://i.imgur.com/ZGyZuQY.jpg"
            , "https://i.imgur.com/PLqoi16.jpg"
            , "https://i.imgur.com/idrXfUG.jpg"
            , "https://i.imgur.com/Rh0C4jf.jpg"
            , "https://i.imgur.com/DAUCOla.jpg"
            , "https://i.imgur.com/ygLjoMU.jpg"
            , "https://i.imgur.com/S2vL0co.jpg"
            , "https://i.imgur.com/SMAm793.jpg"
            , "https://i.imgur.com/L42vyKM.jpg"
            , "https://i.imgur.com/CwlJROQ.jpg"
            , "https://i.imgur.com/fGZpia5.jpg"
            , "https://i.imgur.com/924R0ik.jpg"
            , "https://i.imgur.com/pc1MsWc.jpg"
            , "https://i.imgur.com/PT2n6Bk.jpg"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {

        super.onWindowFocusChanged(hasFocus);

        int row = 2;

        int current_width = mGridView.getWidth() - 10;

        int current_height = mGridView.getHeight() - 10;

        if (hasFocus) {

            if ( mGridViewAdapter == null || imageViewHeight != current_height || imageViewWidth != current_width) {

                imageViewWidth = current_width;

                imageViewHeight = current_height;

                mGridViewAdapter = new GridViewAdapter(this, imageViewWidth, imageViewHeight, row );

                mGridView.setAdapter( mGridViewAdapter );

            }

        }

    }
}
