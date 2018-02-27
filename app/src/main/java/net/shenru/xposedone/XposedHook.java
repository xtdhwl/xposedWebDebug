package net.shenru.xposedone;

import android.os.Build;
import android.webkit.WebView;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

/**
 * Created by xtdhwl on 23/02/2018.
 */

public class XposedHook implements IXposedHookLoadPackage {


    public void handleLoadPackage(final XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
//        MyApplication context = MyApplication.getContext();
//        String spKey = Constant.PACKAGE + lpparam.packageName;
//        boolean aBoolean = SpUtil.getBoolean(context, spKey, false);
//        if (!aBoolean) {
//            SpUtil.putBoolean(context, spKey, false);
//            return;
//        }
//
        XposedBridge.log("Loaded app: " + lpparam.packageName);
        findAndHookMethod("android.app.Application", lpparam.classLoader, "onCreate", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                // this will be called before the clock was updated by the original method

            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                // this will be called after the clock was updated by the original method
                if (Build.VERSION.SDK_INT >= 19) {
                    XposedBridge.log("setWebContentsDebuggingEnabled true");
                    WebView.setWebContentsDebuggingEnabled(true);
                }
            }
        });
    }
}

