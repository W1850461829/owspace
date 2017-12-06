package com.navy.owspace.util;

import android.content.Context;
import android.telephony.TelephonyManager;

/**
 * Created by Administrator on 2017/12/6.
 */

public class AppUtil {
    public static String getDeviceId(Context context){
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return tm.getDeviceId();
    }
}
