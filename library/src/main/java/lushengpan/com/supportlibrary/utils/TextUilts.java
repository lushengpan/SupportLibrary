package lushengpan.com.supportlibrary.utils;

import android.content.Context;
import android.text.TextPaint;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Created by lushengpan on 2016/12/28.
 */

public class TextUilts {


    /**
     * 检查字符串，不存在则赋值
     *
     * @param str     需要检测的字符串
     * @param storage 复制的字符串
     * @return
     */
    public static boolean sStringValid(String str, String storage) {
        if (str != null && str.trim().length() > 0) {
            return true;
        }
        if (storage != null && storage.trim().length() > 0) {
            str = storage;
            return true;
        }

        return false;

    }



    /**
     * 手机号码加密
     *
     * @param phone
     * @return
     */
    public static String PhoneEncryption(String phone) {
        if (phone.length() == 11) {
//            String phoneState = phone.substring(0, 3);
//            String phoneEnd = phone.substring(phone.length() - 3, phone.length());
//            return phoneState + "*****" + phoneEnd;
            StringBuffer buffer = new StringBuffer(phone);
            buffer.replace(3, phone.length() - 3, "*****");
            return buffer.toString();
        } else {
            return "";

        }

    }

    /**
     * 规范数字的显示
     *
     * @param num
     * @return 如01，12
     */

    public static String Addzero(int num) {
        if (num < 10) {
            return "0" + num;
        }
        return num + "";
    }

    /**
     * 获取字体的宽度
     *
     * @param context
     * @param text
     * @param textSize
     * @return
     */
    public static float TextWidth(Context context, String text, int textSize) {
        TextPaint paint = new TextPaint();
        float scaledDensity = (context.getResources()).getDisplayMetrics().scaledDensity;
        paint.setTextSize(scaledDensity * textSize);
        return paint.measureText(text);
    }


    /**
     * 转化成带2为小数的字符串
     * @param str
     * @return
     */
    public static String SumConversionStr(double str) {
        java.text.DecimalFormat df = new java.text.DecimalFormat("0.00");
        return df.format(str);
    }

    /**
     * 转化成带2为小数的double类型的
     *
     * @param str
     * @return
     */
    public static Double SumConversionDou(double str) {
        java.text.DecimalFormat df = new java.text.DecimalFormat("0.00");
        return Double.parseDouble(df.format(str));
    }




    public static String ToDBC(String input) {
        char[] c = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 12288) {
                c[i] = (char) 32;
                continue;
            }
            if (c[i] > 65280 && c[i] < 65375)
                c[i] = (char) (c[i] - 65248);
        }
        return new String(c);
    }

    /**
     * 替换、过滤特殊字符
     * @param str
     * @return
     * @throws PatternSyntaxException
     */
    public static String StringFilter(String str) throws PatternSyntaxException {
        str = str.replaceAll("【", "[").replaceAll("】", "]").replaceAll("！", "!").replaceAll("（", "(").replaceAll("）", ")");// 替换中文标号
        String regEx = "[『』]"; // 清除掉特殊字符
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("").trim();
    }

}
