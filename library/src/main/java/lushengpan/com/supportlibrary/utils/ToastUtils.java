package lushengpan.com.supportlibrary.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by gh0st on 2017/1/17.
 */

public class ToastUtils {
    private static Toast mToast;

    public static void showToast(Context context, int id) {
        Toast.makeText(context, context.getText(id), Toast.LENGTH_LONG).show();
    }

    public static void showToast(Context context, String string) {
        Toast.makeText(context, string, Toast.LENGTH_LONG).show();
    }
}
