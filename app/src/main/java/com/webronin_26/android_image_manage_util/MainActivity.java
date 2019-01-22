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

            "https://i.imgur.com/c0Deo1f.jpg"
            , "https://i.imgur.com/2qccfpP.jpg"
            , "https://i.imgur.com/Tsmb92Z.jpg"
            , "https://i.imgur.com/6OmGGH7.jpg"
            , "https://i.imgur.com/ktzBo9E.jpg"
            , "https://i.imgur.com/tDMwqZI.jpg"
            , "https://i.imgur.com/KPseL5e.jpg"
            , "https://i.imgur.com/eRhpnmA.jpg"
            , "https://i.imgur.com/65bewIT.jpg"
            , "https://i.imgur.com/JSRecC8.jpg"
            , "https://i.imgur.com/U9XRrV5.jpg"
            , "https://i.imgur.com/Y6REbgw.jpg"
            , "https://i.imgur.com/iYQDrnv.jpg"
            , "https://i.imgur.com/kYpx62U.jpg"
            , "https://i.imgur.com/NvpEnOL.jpg"
            , "https://i.imgur.com/Jsx12Ny.jpg"
            , "https://i.imgur.com/89cvmdy.jpg"
            , "https://i.imgur.com/ovC4uOD.jpg"
            , "https://i.imgur.com/dlpMpb8.jpg"
            , "https://i.imgur.com/LqZgg9u.jpg"
            , "https://i.imgur.com/WeCxv2a.jpg"
            , "https://i.imgur.com/0sLtjo1.jpg"
            , "https://i.imgur.com/PyW4TiG.jpg"
            , "https://i.imgur.com/9hrZvPJ.jpg"
            , "https://i.imgur.com/2MXOkUP.jpg"
            , "https://i.imgur.com/s3SgjhM.jpg"
            , "https://i.imgur.com/9O7B4Ym.jpg"
            , "https://i.imgur.com/bMVNsS2.jpg"
            , "https://i.imgur.com/IWZETvs.jpg"
            , "https://i.imgur.com/vPowIJg.jpg"
            , "https://i.imgur.com/2dM8Lrm.jpg"
            , "https://i.imgur.com/WAj8TGI.jpg"
            , "https://i.imgur.com/oaZSIBt.jpg"
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
            , "https://i.imgur.com/zccL411.jpg"
            , "https://i.imgur.com/ygLjoMU.jpg"
            , "https://i.imgur.com/S2vL0co.jpg"
            , "https://i.imgur.com/SMAm793.jpg"
            , "https://i.imgur.com/CwlJROQ.jpg"
            , "https://i.imgur.com/fGZpia5.jpg"
            , "https://i.imgur.com/924R0ik.jpg"
            , "https://i.imgur.com/U4FPqG1.jpg"
            , "https://i.imgur.com/rd9s7fR.jpg"
            , "https://i.imgur.com/cL6DDSp.jpg"
            , "https://i.imgur.com/H0fWH2e.jpg"

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
