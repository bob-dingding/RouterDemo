package com.xzt.routerdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * 作者：Created by Ding on 2019/4/6
 * 文件描述：
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(setLayoutId() != 0){
            setContentView(setLayoutId());
            ARouter.getInstance().inject(this);
            initView();
            initData();
        }
    }

    /**
     * 不带参数跳转
     * @param context
     * @param path
     */
    public static void toActivity(final Context context, String path) {
        ARouter.getInstance().build(path).navigation(context, new CustomNavigationCallback(context));
    }

    /**
     * 带参数跳转
     * @param context
     * @param path
     * @param bundle
     */
    public static void toActivity(final Context context, String path, Bundle bundle) {
        ARouter.getInstance().build(path)
                .withBundle("data", bundle).navigation(context, new CustomNavigationCallback(context));
    }


    public abstract  int setLayoutId();
    public abstract  void initView();
    public abstract  void initData();
}
