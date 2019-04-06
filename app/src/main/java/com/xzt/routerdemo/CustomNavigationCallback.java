package com.xzt.routerdemo;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;

/**
 * 作者：Created by Ding on 2019/4/6
 * 文件描述：
 */
public class CustomNavigationCallback implements NavigationCallback {
    private static final String TAG = "MainActivity";

    Context mContext;

    public CustomNavigationCallback(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void onFound(Postcard postcard) {
        //路由目标被发现时调用
        Log.e(TAG, "路由目标被发现时调用" );
    }

    @Override
    public void onLost(Postcard postcard) {
        //路由被丢失时调用
        Log.e(TAG, "路由被丢失时调用" );
    }

    @Override
    public void onArrival(Postcard postcard) {
       //路由到达之后调用
        Log.e(TAG, "路由到达之后调用" );
    }

    @Override
    public void onInterrupt(final Postcard postcard) {
        //路由被拦截时调用
        Log.e(TAG, "路由被拦截时调用" );
        //假设值处理onInterrupt方法,这里只把为什么被拦截的信息打出来
        new Handler(mContext.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(mContext, (String) postcard.getTag(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
