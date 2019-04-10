package routerdemo.xzt.com.testmodule;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;

import routerdemo.xzt.com.myapplication.TestModuleExportService;

/**
 * 作者：Created by Ding on 2019/4/7
 * 文件描述：
 */
@Route(path = "/testmodule/service")
public class TestModuleService implements TestModuleExportService {


    @Override
    public String ToastMessage(String message) {
       return "调用方法成功并返回:"+message;
    }

    @Override
    public void init(Context context) {

    }
}
