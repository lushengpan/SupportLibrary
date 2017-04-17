package lushengpan.com.supportlibrary.view;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.WindowManager;

/**
 * 取消日期选择对话框时不会再次调用onDateSet方法
 * 
 * @author Administrator
 * 
 */
public class MyDatePickerDialog extends DatePickerDialog {

	public MyDatePickerDialog(Context context, OnDateSetListener callBack,
			int year, int monthOfYear, int dayOfMonth) {
		super(context, callBack, year, monthOfYear, dayOfMonth);
	}

	public MyDatePickerDialog(Context context, int theme, OnDateSetListener callBack, int year,
            int monthOfYear, int dayOfMonth) {
		super(context,theme, callBack, year, monthOfYear, dayOfMonth);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		//不弹出软键盘
		getWindow().setSoftInputMode(
				WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
	}

	@Override
	protected void onStop() {
		// super.onStop();
	}

}
