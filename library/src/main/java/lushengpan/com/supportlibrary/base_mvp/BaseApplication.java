package lushengpan.com.supportlibrary.base_mvp;

import android.app.Application;
import android.content.Context;

/**
 * Created by lushengpan on 2017/2/15.
 */

public class BaseApplication extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static boolean isDebug() {
        return true;  //默认debug
    }

    public static Context getContext() {
        return context;
    }


}
