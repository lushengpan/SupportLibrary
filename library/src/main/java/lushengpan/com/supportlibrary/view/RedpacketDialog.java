package lushengpan.com.supportlibrary.view;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

public class RedpacketDialog extends AlertDialog {

	private View v;

	public RedpacketDialog(Context context, int themeResId, View v) {
		super(context, themeResId);
		this.v = v;

	}

	public RedpacketDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
		super(context, cancelable, cancelListener);
	}

	public RedpacketDialog(Context context) {
		super(context);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(v);

	}

}
