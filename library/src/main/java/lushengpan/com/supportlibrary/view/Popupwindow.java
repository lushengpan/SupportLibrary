package lushengpan.com.supportlibrary.view;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;

import lushengpan.com.supportlibrary.R;


public class Popupwindow {

    private PopupWindow popupWindow;
    private View view;

    public Popupwindow(View v, int width, int high) {
        super();
        // 创建一个PopuWidow对象
        popupWindow = new PopupWindow(v, width, high, true);
        this.view = v;
    }

    /**
     * @param context
     * @param color   -1为默认，代表白色
     * @param effect  //使部分变暗的效果图层
     */

    public void popupwindowSet(final Activity context, int color, final View effect, float backgroundAlpha) {
        // 设置允许在外点击消失
        popupWindow.setOutsideTouchable(true);

        if (effect != null) {
            effect.setVisibility(View.VISIBLE);
        }
        // 这个是为了点击“返回Back”也能使其消失，并且并不会影响你的背景
        if (color != -1) {
            @SuppressWarnings("deprecation")
            Drawable drawable = context.getResources().getDrawable(color);
            popupWindow.setBackgroundDrawable(drawable);

        } else {
            @SuppressWarnings("deprecation")
            Drawable drawable = context.getResources().getDrawable(R.color.white);
            popupWindow.setBackgroundDrawable(drawable);
        }
        if (backgroundAlpha <= 1f && backgroundAlpha > 0f) {
            backgroundAlpha(context, backgroundAlpha);

        }

        //  popupWindow.getBackground().setAlpha(153);
        popupWindow.setOnDismissListener(new OnDismissListener() {

            @Override
            public void onDismiss() {
                backgroundAlpha(context, 1f);
                if (effect != null) {
                    effect.setVisibility(View.INVISIBLE);

                }

            }
        });

    }

    public PopupWindow getPopupWindow() {

        return popupWindow;

    }

    public void show(int Gravity, int x, int y) {
        popupWindow.showAtLocation(view, Gravity, 0, 0);

    }

    public void show(View v, int Gravity, int x, int y) {
        popupWindow.showAtLocation(v, Gravity, 0, 0);

    }

    public void show(View v, int x, int y) {
        popupWindow.showAsDropDown(v, x, y);

    }

    private void backgroundAlpha(Activity activity, float alp) {
        WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
        lp.alpha = alp;
        activity.getWindow().setAttributes(lp);
    }

    public void dismiss() {
        if (popupWindow != null) {
            popupWindow.dismiss();
        }

    }

}
