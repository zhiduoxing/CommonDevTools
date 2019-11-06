package com.lanson.common.utils;

import android.util.Log;

public class LogUtil {

    private LogUtil(){
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static boolean isDebug = true;// 是否需要打印bug，可以在application的onCreate函数里面初始化
    private static final String TAG = "WOLF"; //默认TAG

    // 下面四个是默认tag的函数

    /**
     * 打印默认tag的verbose级别日志
     * @param msg
     */
    public static void v(String msg){
        if (isDebug) {
            Log.v(TAG, msg);
        }
    }

    /**
     * 打印默认tag的debug级别日志
     * @param msg
     */
    public static void d(String msg){
        if (isDebug) {
            Log.d(TAG, msg);
        }
    }

    /**
     * 打印默认tag的info级别日志
     * @param msg
     */
    public static void i(String msg){
        if (isDebug) {
            Log.i(TAG, msg);
        }
    }

    /**
     * 打印默认tag的warn级别日志
     * @param msg
     */
    public static void w(String msg){
        if (isDebug) {
            Log.w(TAG, msg);
        }
    }

    /**
     * 打印默认tag的error级别日志
     * @param msg
     */
    public static void e(String msg){
        if (isDebug) {
            Log.e(TAG, msg);
        }
    }


    /**
     * 打印verbose级别的log
     * @param tag
     * @param msg
     */
    public static void v(String tag, String msg){
        if (isDebug) {
            Log.v(tag, msg);
        }
    }

    /**
     * 打印debug级别的log
     * @param tag
     * @param msg
     */
    public static void d(String tag, String msg){
        if (isDebug) {
            Log.d(tag, msg);
        }
    }

    /**
     * 打印info级别的log
     * @param tag
     * @param msg
     */
    public static void i(String tag, String msg){
        if (isDebug) {
            Log.i(tag, msg);
        }
    }

    /**
     * 打印warn级别的log
     * @param tag
     * @param msg
     */
    public static void w(String tag, String msg){
        if (isDebug) {
            Log.w(tag, msg);
        }
    }

    /**
     * 打印error级别的log
     * @param tag
     * @param msg
     */
    public static void e(String tag, String msg){
        if (isDebug) {
            Log.e(tag, msg);
        }
    }

}
