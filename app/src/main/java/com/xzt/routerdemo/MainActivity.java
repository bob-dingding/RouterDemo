package com.xzt.routerdemo;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

@Route(path = Constants.MAINPATH , extras = ArouteConfig.INTERCEPTORLOGIN)
public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";

    Button btnJumpLogin;
    Button btnStartActivity;
    TextView tvShow;


    @Override
    public int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        btnJumpLogin=findViewById(R.id.btn_samemodulejump);
        btnStartActivity=findViewById(R.id.btn_startActivity);
        tvShow=findViewById(R.id.tv_show);
    }

    @Override
    public void initData() {
        btnJumpLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Uri uri =Uri.parse(Constants.LOGINPATH);
                ARouter.getInstance().build(uri)
                        .withString("name","张三") //传String
                        .withInt("age",20)//传Int
                        .withParcelable("userbean",new UserBean("家住大城市铁岭"))
                        .navigation(MainActivity.this, new CustomNavigationCallback(MainActivity.this));
            }
        });

        btnStartActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build(Constants.LOGINPATH).navigation(MainActivity.this,123,new CustomNavigationCallback(MainActivity.this));
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (resultCode){
            case 456:
                tvShow.setText("接受到的数据是:"+data.getStringExtra("data"));
                break;
        }
    }
}
