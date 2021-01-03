package com.zbk.lib_network.util;

import android.util.Log;

import com.zbk.lib_network.BuildConfig;

/**
 * Created by ZBK on 2020-12-20.
 *
 * @function
 */
public class LogUtil {
    private static final String TAG = "LogUtil";
    public final static int logSubLenth = 3000;//每行log长度

    public static void show(String content) {
        if (BuildConfig.DEBUG) {
            logSplit(TAG, content, 1);
        }
    }
    public static void show(String tag,String content) {
        if (BuildConfig.DEBUG) {
            logSplit(tag, content, 1);
        }
    }

    public static void logSplit(String explain, String message, int i) {
        //TODO 添加非debug下不打印日志
        //        if (!BuildConfig.DEBUG) return;
        if (i > 10) return;
        if (message.length() <= logSubLenth) {
            Log.i(explain, explain + i + "：     " + message);
            return;
        }

        String msg1 = message.substring(0, logSubLenth);
        Log.i(explain, explain + i + "：     " + msg1);
        String msg2 = message.substring(logSubLenth);
        logSplit(explain, msg2, ++i);
    }
}

