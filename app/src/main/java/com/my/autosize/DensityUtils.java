package com.my.autosize;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;

/**
 * 源码出自今日头条文章：https://mp.weixin.qq.com/s/d9QCoBP6kV9VSWvVldVVwA
 */
public class DensityUtils {

    private static float sNoncompatDensity;
    private static float sNoncompatScaleDensity;

    public static void setCustomDensity(@NonNull Activity activity, @NonNull final Application application){
        final DisplayMetrics appDisplayMetrics = application.getResources().getDisplayMetrics();

        if (sNoncompatDensity == 0){
            //density：屏幕密度
            sNoncompatDensity = appDisplayMetrics.density;
            //scaledDensity: 字体的缩放因子，正常情况下与density相等，但是调节系统字体大小后会改变这个值
            sNoncompatScaleDensity = appDisplayMetrics.scaledDensity;
            //监听系统字体切换
            application.registerComponentCallbacks(new ComponentCallbacks() {
                @Override
                public void onConfigurationChanged(Configuration newConfig) {
                    if (newConfig != null && newConfig.fontScale > 0){
                        sNoncompatScaleDensity = application.getResources().getDisplayMetrics().scaledDensity;
                    }
                }

                @Override
                public void onLowMemory() {

                }
            });
        }

        final float targetDensity = appDisplayMetrics.widthPixels / 360;
        final float targetScaledDensity = targetDensity * (sNoncompatScaleDensity / sNoncompatDensity);
        final int targetDensityDpi = (int) (160 * targetDensity);

        appDisplayMetrics.density = targetDensity;
        appDisplayMetrics.scaledDensity = targetScaledDensity;
        appDisplayMetrics.densityDpi = targetDensityDpi;

        final DisplayMetrics activityDisplayMetrics = activity.getResources().getDisplayMetrics();
        activityDisplayMetrics.density = targetDensity;
        activityDisplayMetrics.scaledDensity = targetScaledDensity;
        activityDisplayMetrics.densityDpi = targetDensityDpi;
    }
}
