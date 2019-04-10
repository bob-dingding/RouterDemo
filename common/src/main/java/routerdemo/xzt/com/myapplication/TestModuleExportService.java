package routerdemo.xzt.com.myapplication;

        import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * 作者：Created by Ding on 2019/4/7
 * 文件描述：
 */


public interface TestModuleExportService extends IProvider {

    String ToastMessage(String message);
}
