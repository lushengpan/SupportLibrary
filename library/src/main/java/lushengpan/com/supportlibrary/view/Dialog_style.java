//package lushengpan.com.supportlibrary.view;
//
//import android.app.AlertDialog;
//import android.content.Context;
//import android.content.DialogInterface;
//import android.content.Intent;
//import android.net.Uri;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.ImageView;
//import android.widget.TextView;
//public class Dialog_style {
//
//	/**
//	 * 显示呼叫客服对话框
//	 */
//	public static void showKefuDialog(final Context context, final String phone) {
//		AlertDialog.Builder builder = new AlertDialog.Builder(context, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
//		// builder.setMessage("是否呼叫客服:"
//		// + getResources().getString(R.string.customerservice_number));
//
//		View v = LayoutInflater.from(context).inflate(R.layout.dailog_customer_phone, null);
//
//		ImageView iv_dismiss = (ImageView) v.findViewById(R.id.iv_dismiss);
//		TextView tv_phone = (TextView) v.findViewById(R.id.tv_phone);
//		tv_phone.setText(phone);
//		builder.setView(v);
//		builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
//
//			@Override
//			public void onClick(DialogInterface dialog, int which) {
//
//				dialog.dismiss();
//			}
//		});
//
//		builder.setPositiveButton("呼叫", new DialogInterface.OnClickListener() {
//
//			@Override
//			public void onClick(DialogInterface dialog, int which) {
//				// 拨打客服
//				Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));
//				context.startActivity(intent);
//				dialog.dismiss();
//			}
//		});
//		builder.setCancelable(true);
//
//		final AlertDialog dialog = builder.create();
//		iv_dismiss.setOnClickListener(new OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				dialog.dismiss();
//			}
//		});
//		dialog.show();
//
//	}
//
//	/**
//	 * 显示呼叫客服对话框
//	 */
//	public static void showKefuDialog(final Context context, final String phone, int style) {
//		AlertDialog.Builder builder = new AlertDialog.Builder(context, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
//		View v = LayoutInflater.from(context).inflate(R.layout.dailog_customer_phone1, null);
//		TextView tv_phone = (TextView) v.findViewById(R.id.tv_phone);
//		tv_phone.setText(phone);
//		builder.setView(v);
//		builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
//
//			@Override
//			public void onClick(DialogInterface dialog, int which) {
//
//				dialog.dismiss();
//			}
//		});
//
//		builder.setPositiveButton("呼叫", new DialogInterface.OnClickListener() {
//
//			@Override
//			public void onClick(DialogInterface dialog, int which) {
//				// 拨打客服
//				Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));
//				context.startActivity(intent);
//				dialog.dismiss();
//			}
//		});
//		builder.setCancelable(true);
//
//		final AlertDialog dialog = builder.create();
//		dialog.show();
//
//	}
//}
