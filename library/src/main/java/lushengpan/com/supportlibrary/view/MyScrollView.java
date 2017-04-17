//package lushengpan.com.supportlibrary.view;
//
//import android.content.Context;
//import android.util.AttributeSet;
//import android.view.GestureDetector;
//import android.view.GestureDetector.SimpleOnGestureListener;
//import android.view.MotionEvent;
//import android.view.View;
//import android.widget.ScrollView;
//
//import com.koudaiqiche.koudaiqiche.pulltorefresh.Pullable;
//
///**
// * 解决ScrollView中嵌套ViewPager的滑动冲突
// *
// * @author Administrator
// *
// */
//
//public class MyScrollView extends ScrollView implements Pullable{
//	private boolean canScroll;
//
//	private GestureDetector mGestureDetector;
//	OnTouchListener mGestureListener;
//
//	public MyScrollView(Context context, AttributeSet attrs, int defStyle) {
//		super(context, attrs, defStyle);
//	}
//
//	public MyScrollView(Context context, AttributeSet attrs) {
//		super(context, attrs);
//		mGestureDetector = new GestureDetector(new YScrollDetector());
//		canScroll = true;
//	}
//
//	public MyScrollView(Context context) {
//		super(context);
//		// TODO Auto-generated constructor stub
//	}
//
//	@Override
//	public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
//		super.requestDisallowInterceptTouchEvent(disallowIntercept);
//	}
//
//	@Override
//	public boolean onInterceptTouchEvent(MotionEvent ev) {
//
//		if (ev.getAction() == MotionEvent.ACTION_UP)
//			canScroll = true;
//		return super.onInterceptTouchEvent(ev)
//				&& mGestureDetector.onTouchEvent(ev);
//
//	}
//
//	class YScrollDetector extends SimpleOnGestureListener {
//
//		@Override
//		public boolean onScroll(MotionEvent e1, MotionEvent e2,
//				float distanceX, float distanceY) {
//			if (canScroll)
//				if (Math.abs(distanceY) >= Math.abs(distanceX))
//					canScroll = true;
//				else
//					canScroll = false;
//			return canScroll;
//		}
//
//	}
//
//	@Override
//	public boolean canPullDown() {
//		if (getScrollY() == 0)
//			return true;
//		else
//			return false;
//	}
//
//	@Override
//	public boolean canPullUp() {
//		if (getScrollY() >= (getChildAt(0).getHeight() - getMeasuredHeight()))
//			return true;
//		else
//			return false;
//	}
//}
