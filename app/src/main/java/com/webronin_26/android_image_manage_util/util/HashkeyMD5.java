package com.webronin_26.android_image_manage_util.util;


import java.security.MessageDigest;


public class HashkeyMD5 {


    public String hashkeyFromString( String targetString ) {

        String hashString = null;

        StringBuilder sb = new StringBuilder();


        try{

            MessageDigest mMessageDigest = MessageDigest.getInstance( "MD5" );

            mMessageDigest.update( targetString.getBytes() );


            byte[] bytes = mMessageDigest.digest();


            for ( int i = 0; i < bytes.length; i++ ) {

                String hex = Integer.toHexString(0xFF & bytes[i] );

                if ( hex.length() == 1 ) {

                    sb.append('0');

                }

                sb.append( hex );

            }

            hashString = sb.toString();

        }catch ( Exception e ){

            hashString = String.valueOf( targetString.hashCode() );

        }

        return hashString;
    }

}
