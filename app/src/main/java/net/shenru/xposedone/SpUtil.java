package net.shenru.xposedone;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by xtdhwl on 27/02/2018.
 */

public class SpUtil {

    private static final String SP_NAME = "sp.xml";


    public static String getString(Context context,String key, String defValue){
        SharedPreferences sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        return sp.getString(key, defValue);
    }

    public static boolean putString(Context context,String key, String defValue){
        SharedPreferences sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        return sp.edit().putString(key, defValue).commit();
    }

    public static boolean getBoolean(Context context,String key, boolean defValue){
        SharedPreferences sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        return sp.getBoolean(key, defValue);
    }

    public static boolean putBoolean(Context context,String key, boolean defValue){
        SharedPreferences sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        return sp.edit().putBoolean(key, defValue).commit();
    }


}
