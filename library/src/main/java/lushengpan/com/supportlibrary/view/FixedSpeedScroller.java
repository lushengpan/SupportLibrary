package lushengpan.com.supportlibrary.view;

import java.lang.reflect.Field;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.animation.Interpolator;
import android.widget.Scroller;

/**
 * FixedSpeedScroller for controlling sliding animation speed. It uses the java
 * reflection mechanism.
 * 
 * @version 1.00 2014.1.6
 * @author Huang.xin gkx100120
 * 
 */
public class FixedSpeedScroller extends Scroller {

	private int mDuration = 1500; // default time is 1500ms

	public FixedSpeedScroller(Context context) {
		super(context);
	}

	public FixedSpeedScroller(Context context, Interpolator interpolator) {
		super(context, interpolator);
	}

	@Override
	public void startScroll(int startX, int startY, int dx, int dy, int duration) {
		// Ignore received duration, use fixed one instead
		super.startScroll(startX, startY, dx, dy, mDuration);
	}

	@Override
	public void startScroll(int startX, int startY, int dx, int dy) {
		// Ignore received duration, use fixed one instead
		super.startScroll(startX, startY, dx, dy, mDuration);
	}

	 /**
     * 设置速度速度
     * @param duration
     */
    public void setScrollDuration(int duration){
        this.mDuration = duration;
    }
	
    public void initViewPagerScroll(ViewPager viewPager) {
        try {
			Field mScroller = ViewPager.class.getDeclaredField("mScroller");
            mScroller.setAccessible(true);
            mScroller.set(viewPager, this);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
	/**
	 * set animation time
	 * 
	 * @param time
	 */
	public void setmDuration(int time) {
		mDuration = time;
	}

	/**
	 * get current animation time
	 * 
	 * @return
	 */
	public int getmDuration() {
		return mDuration;
	}
}