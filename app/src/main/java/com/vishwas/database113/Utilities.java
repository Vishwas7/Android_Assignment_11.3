package com.vishwas.database113;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;

/**
 * creating a class Utilities this class will convert from byte array to bitmap..
 */
public class Utilities {
    public static byte[] getBytes(Bitmap bitmap){
        //first created an object of ByteArrayOutputStream..
        ByteArrayOutputStream stream=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,0,stream);
        return stream.toByteArray();
    }
    // convert from byte array to bitmap
    public static Bitmap getImage(byte[] image) {
        return BitmapFactory.decodeByteArray(image, 0, image.length);
    }

}
