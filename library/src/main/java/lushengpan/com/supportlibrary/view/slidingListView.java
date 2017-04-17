package lushengpan.com.supportlibrary.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.TranslateAnimation;
import android.widget.ListView;

public class slidingListView extends ListView {

	private int mLastDownX;
	private int mCurryX;
	private int mDelX;
    private Context context;
	private TranslateAnimation animation;
	@SuppressLint("NewApi")
	public slidingListView(Context context, AttributeSet attrs, int defStyleAttr,
			int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
		this.context=context;
	}

	public slidingListView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		this.context=context;
	}

	public slidingListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context=context;
	}

	public slidingListView(Context context) {
		super(context);
		this.context=context;
		
	}
	

}
