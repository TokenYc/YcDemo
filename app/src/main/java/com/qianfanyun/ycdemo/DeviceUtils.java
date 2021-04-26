package com.qianfanyun.ycdemo;

import android.content.Context;
import android.telephony.TelephonyManager;

/**
 * @author ArcherYc
 * @date on 2019-12-23  16:39
 * @mail 247067345@qq.com
 */
public class DeviceUtils {
    public static String getImei(Context context){
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String imei = telephonyManager.getDeviceId();
        return imei;
    }
}
