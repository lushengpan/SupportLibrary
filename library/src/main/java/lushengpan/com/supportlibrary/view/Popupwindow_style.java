//package lushengpan.com.supportlibrary.view;
//
//import android.app.Activity;
//import android.view.Gravity;
//import android.view.View;
//import android.widget.PopupWindow;
//import android.widget.TextView;
//
//import com.koudaiqiche.koudaiqiche.R;
//import com.koudaiqiche.koudaiqiche.utils.UIUtils;
//
//public class Popupwindow_style {
//
//	public static void Hint_Guan(Activity context, String msg, View view) {
//		View v = UIUtils.createView(R.layout.popupwindow_you);
//		TextView tv_text = (TextView) v.findViewById(R.id.tv_text);
//		tv_text.setText(msg);
//		PopupWindow popupWindow = new PopupWindow(v, UIUtils.dip2px(129), UIUtils.dip2px(28));
//		popupWindow.setFocusable(true);
//		popupWindow.setOutsideTouchable(true);
//		popupWindow.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.you));
//
//		int[] location = new int[2];
//		view.getLocationOnScreen(location);
//
//		popupWindow.showAtLocation(view, Gravity.NO_GRAVITY, location[0] - popupWindow.getWidth() / 2 + view.getWidth() / 2, location[1] - popupWindow.getHeight());
//
//	}
//
//	public static void Hint_you(Activity context, String msg, View view) {
//		View v = UIUtils.createView(R.layout.popupwindow_you);
//		TextView tv_text = (TextView) v.findViewById(R.id.tv_text);
//		tv_text.setText(msg);
//		PopupWindow popupWindow = new PopupWindow(v, UIUtils.dip2px(90), UIUtils.dip2px(28));
//		popupWindow.setFocusable(true);
//		popupWindow.setOutsideTouchable(true);
//		popupWindow.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.you));
//
//		int[] location = new int[2];
//		view.getLocationOnScreen(location);
//
//		popupWindow.showAtLocation(view, Gravity.NO_GRAVITY, location[0] - popupWindow.getWidth() / 2 + view.getWidth() / 2, location[1] - popupWindow.getHeight());
//
//	}
//}
