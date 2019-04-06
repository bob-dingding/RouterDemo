package com.xzt.routerdemo;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * 作者：Created by Ding on 2019/4/5
 * 文件描述：
 */
public class BaseApplication extends Application {
    //是否开启调试
    private static boolean isDebug =true;
    @Override
    public void onCreate() {
        super.onCreate();
       //必须在初始化之前写入这两行
        if (isDebug) {
            //打印日志
            ARouter.openLog();
            //开始调试
            ARouter.openDebug();
        }
        //ARouter的实例化
        ARouter.init(this);
    }
}
