package lushengpan.com.supportlibrary.Fresh;

import android.content.Context;
import android.util.AttributeSet;

import lushengpan.com.supportlibrary.Fresh.indicator.PtrTensionIndicator;
import lushengpan.com.supportlibrary.utils.UIUtils;


/**
 * Created by ${lushengpan} on 2016/10/10.
 */
public class PtrTireFrameLayout extends PtrFrameLayout {
    private PtrTensionIndicator mPtrTensionIndicator;

    public PtrTireFrameLayout(Context context) {
        super(context);
        initViews();
    }

    public PtrTireFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews();
    }

    public PtrTireFrameLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initViews();
    }

    private void initViews() {
        RentalsSunHeaderView header = new RentalsSunHeaderView(getContext());
        header.setLayoutParams(new PtrFrameLayout.LayoutParams(-1, -2));
        header.setPadding(0, UIUtils.dip2px(5, getContext()), 0, UIUtils.dip2px(5, getContext()));
        header.setUp(this);
        setHeaderView(header);
        addPtrUIHandler(header);
    }


}
