/*
 *   Copyright (C)  2016 android@19code.com
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package lushengpan.com.supportlibrary.utils;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.support.v4.app.ActivityCompat;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import java.io.File;
import java.security.MessageDigest;
import java.util.List;
import java.util.Locale;
import java.util.Random;

/**
 * 系统级的一些方法
 */
@SuppressLint("SimpleDateFormat")
public final class SystemUtils {
    //发送短信
    public static void sendSMS(Context cxt, String smsBody) {
        Uri smsToUri = Uri.parse("smsto:");
        Intent intent = new Intent(Intent.ACTION_SENDTO, smsToUri);
        intent.putExtra("sms_body", smsBody);
        cxt.startActivity(intent);
    }

    //拨打电话
    public static void forwardToDial(Activity activity, String phoneNumber) {
        if (activity != null && !TextUtils.isEmpty(phoneNumber)) {
            activity.startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber)));
        }
    }

    //拨打电话
    public static void callPhone(Activity activity, String phoneNumber) {
        if (activity != null && !TextUtils.isEmpty(phoneNumber)) {
            if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            activity.startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber)));
        }
    }

    //发送邮件
    public static void sendMail(Context mContext, String mailID) {
        Uri uri = Uri.parse("mailto:" + mailID);
        mContext.startActivity(new Intent(Intent.ACTION_SENDTO, uri));
    }

    //打开网站
    public static void openWeb(Context context, String url) {
        Uri uri = Uri.parse(url);
        context.startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }

    public static void openContacts(Activity context, int requestCode) {
        Uri uri = Uri.parse("content://contacts/people");
        context.startActivityForResult(new Intent(Intent.ACTION_PICK, uri), requestCode);
    }

    //打开设置
    public static void openSettings(Activity context, String action) {
        Intent intent = new Intent();
        ComponentName comp = new ComponentName("com.android.settings", action);
        intent.setComponent(comp);
        intent.setAction("android.intent.action.VIEW");
        context.startActivityForResult(intent, 0);
    }

    //隐藏输入法
    public static void hideKeyBoard(Activity aty) {
        ((InputMethodManager) aty.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(aty.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }
    //安装apk
    public static void installApk(Context context, File apkfile) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setType("application/vnd.android.package-archive");
        intent.setData(Uri.fromFile(apkfile));
        intent.setDataAndType(Uri.fromFile(apkfile), "application/vnd.android.package-archive");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    //版本名称
    public static String getAppVersionName(Context context) {
        String version = "0";
        try {
            version = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return version;
    }

    //版本号
    public static int getAppVersionCode(Context context) {
        int version = 0;
        try {
            version = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return version;
    }

}