package com.xzt.routerdemo;

import android.content.Intent;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * 作者：Created by Ding on 2019/4/6
 * 文件描述：
 */
@Route(path = Constants.LOGINPATH , extras = ArouteConfig.INTERCEPTORLOGIN)
public class LoginActivity extends BaseActivity {

    private static final String TAG = "LoginActivity";

    @Autowired
    String name;
    @Autowired
    int age;
    @Autowired (name="userbean")
    UserBean userBean;


    @Override
    public int setLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
        findViewById(R.id.btn_jumpmain).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build(Constants.MAINPATH)
                        .navigation(LoginActivity.this,new CustomNavigationCallback(LoginActivity.this));

            }
        });

        Intent mIntent =new Intent().putExtra("data","456");
        setResult(456,mIntent);
        finish();
    }


}
