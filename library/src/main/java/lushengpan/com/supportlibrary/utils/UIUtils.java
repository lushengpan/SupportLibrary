package lushengpan.com.supportlibrary.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class UIUtils {
    public List<String> resIds;

    private int mSeconds = 6;
    // 轮播图当前页码
    private int currentPage = 1;

    private static final int IMAGE_MAX = 60 * 60 * 2;

    public UIUtils() {
    }

    ;

    /**
     * dip转换成px
     */
    public static int dip2px(int dip, Context context) {
        final float scale = getResource(context).getDisplayMetrics().density;
        return (int) (dip * scale + 0.5f);
    }

    /**
     * px转换成dip
     */

    public static int px2dip(int px, Context context) {
        final float scale = getResource(context).getDisplayMetrics().density;
        return (int) (px / scale + 0.5f);
    }

    public static Resources getResource(Context context) {
        return context.getResources();
    }

    // /**
    // * 判断用户是否登录,若没有,跳转到登录界面进行登录
    // */
    // public static boolean checkedLogin() {
    // // 假如用户没有登录,跳转到登录界面
    // if (!SharedPreferencesUtils.getBoolean(getContext(), "isLogin", false)) {
    // Intent loginIntent = new Intent(getContext(), LoginActivity.class);
    // loginIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    // getContext().startActivity(loginIntent);
    // Toast.makeText(getContext(), "请先登录", 0).show();
    // return false;
    // } else {
    // return true;
    // }
    // }

    /**
     * 将Unix timestamp转换成普通时间(格式为yyyy/MM/dd HH:mm:ss)
     *
     * @param time
     * @return
     */
    public static String DateFormatYMDHms(long time) {
        String date = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .format(new java.util.Date(time * 1000));
        return date;
    }

    /**
     * 将Unix timestamp转换成普通时间(格式为yyyy/MM/dd)
     *
     * @param time
     * @return
     */
    public static String DateFormatYMD(long time) {
        String date = new java.text.SimpleDateFormat("yyyy-MM-dd")
                .format(new java.util.Date(time * 1000));
        return date;
    }

    /**
     * 获得ArrayString中的字符串
     *
     * @param resid id
     * @return
     */
    public static String[] getArrayString(int resid, Context context) {
        return getResource(context).getStringArray(resid);
    }

    /**
     * 设置Listview的高度
     */
    public static void setListViewHeight(ListView listView) {

        ListAdapter listAdapter = listView.getAdapter();

        if (listAdapter == null) {

            return;

        }

        int totalHeight = 0;

        for (int i = 0; i < listAdapter.getCount(); i++) {

            View listItem = listAdapter.getView(i, null, listView);

            listItem.measure(0, 0);

            totalHeight += listItem.getMeasuredHeight();

        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();

        params.height = totalHeight
                + (listView.getDividerHeight() * (listAdapter.getCount() - 1));

        listView.setLayoutParams(params);

    }

    /**
     * 创建一个View对象
     *
     * @param layoutId 布局文件id
     * @return
     */
    public static View createView(int layoutId, Context context) {
        return View.inflate(context, layoutId, null);
    }

    /**
     * 获得资源文件中的String对象
     *
     * @param id
     * @return
     */
    public static String getString(int id, Context context) {
        return getResource(context).getString(id);
    }

    /**
     * 根据包名判断app是否安装
     *
     * @param context
     * @param packageName
     * @return
     */
    public static boolean isAppInstalled(Context context, String packageName) {
        PackageManager packageManager = context.getPackageManager();
        List<PackageInfo> packages = packageManager.getInstalledPackages(0);
        ArrayList<String> pName = new ArrayList<String>();
        if (packages != null) {
            // 遍历获取已安装的包名
            for (int i = 0; i < packages.size(); i++) {
                String pn = packages.get(i).packageName;
                pName.add(pn);
            }
        }
        return pName.contains(pName);
    }

    /**
     * 根据uri判断app是否安装
     *
     * @param context
     * @param uri
     * @return
     */
    public static boolean isAppInstalledByUri(Context context, String uri) {
        PackageManager pm = context.getPackageManager();
        boolean installed = false;
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            installed = true;
        } catch (PackageManager.NameNotFoundException e) {
            installed = false;
        }
        return installed;
    }
}
