package com.xzt.routerdemo;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;

/**
 * 作者：Created by Ding on 2019/4/6
 * 文件描述：
 */

@Interceptor(priority = 5)
public class CustomInterceptor implements IInterceptor {
    private static final String TAG = "MainActivity";


    public static boolean isLogin =true;

    //中断路由进程
    // 以上两种类型至少需要调用其中一种，否则将不会继续路由
    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
//        if(postcard.getPath().equals(Constants.LOGINPATH) || postcard.getPath().equals(Constants.MAINPATH)) {
//            Log.e(TAG, CustomInterceptor.class.getName() + " 进行了拦截处理！");
        //判断页面是否需要进行登陆
        int extra =postcard.getExtra();
        if(postcard.getExtra()== ArouteConfig.INTERCEPTORLOGIN){
            //此处判断是否进行了登陆操作
            if(isLogin){
                callback.onContinue(postcard);
            }
            else{
                callback.onInterrupt(new Exception("请先登录"));
            }
        }else{//不需要先进行登陆判断的界面
            callback.onContinue(postcard);
        }
    }


    //拦截器初始化，此方法在sdk初始化时调用，只调用一次
    @Override
    public void init(Context context) {
        Log.e(TAG, CustomInterceptor.class.getName() + " 进行了拦截器初始化！");
    }
}
