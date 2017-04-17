//package lushengpan.com.supportlibrary.view;
//
//import android.annotation.SuppressLint;
//import android.content.Context;
//import android.os.Handler;
//import android.os.Message;
//import android.support.v4.view.PagerAdapter;
//import android.support.v4.view.ViewPager;
//import android.support.v4.view.ViewPager.OnPageChangeListener;
//import android.view.Gravity;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.ImageView.ScaleType;
//import android.widget.LinearLayout;
//import android.widget.LinearLayout.LayoutParams;
//
//import com.koudaiqiche.koudaiqiche.R;
//import com.lushengpan.baselibrary.utils.UIUtils;
//import com.nostra13.universalimageloader.core.DisplayImageOptions;
//import com.nostra13.universalimageloader.core.ImageLoader;
//
//import java.lang.reflect.Field;
//import java.util.List;
//import java.util.Timer;
//import java.util.TimerTask;
//
//public class ViewPageOfAutomatic1 {
//    /**
//     * 上一个高亮指示点的角标
//     */
//    private int mLastPoint;
//    private int myIndex = 0;
//    private Context context;
//    private List<String> resIds; // 图片uri集
//    int currentPage = 0;
//    private int seconds; // 轮播的秒数
//    private ViewPager view;
//    private DisplayImageOptions displayImageOptions; // 图片的基本设置
//    private OnClickViewPagerItem onclickViewPagerItem; // 点击的接口
//    private boolean auto;
//    private boolean isTaskRun;
//    private Timer mTimer;
//    private TimerTask mTask;
//    private int style;
//    private FixedSpeedScroller mScroller;
//    private Field mField;
//
//    /*
//     * ViewPager的构造函数
//     */
//    public ViewPageOfAutomatic1(Context context, ViewPager view, DisplayImageOptions displayImageOptions) {
//        // super();
//        this.view = view;
//        this.context = context;
//        this.displayImageOptions = displayImageOptions;
//
//    }
//
//    /**
//     * 生成自动轮播的ViewPager
//     *
//     * @param resIds   图片的uri
//     * @param ll_point ViewPager
//     * @param listener 点击的监听
//     * @param seconds  轮播的时间
//     * @param seconds  是否自动轮播
//     */
//    @SuppressWarnings("deprecation")
//    public void initViewPager(final List<String> resIds, final LinearLayout ll_point, final OnClickViewPagerItem listener, int seconds, boolean auto, final int style) {
//        this.style = style;
//        this.resIds = resIds;
//        this.seconds = seconds;
//        onclickViewPagerItem = listener;
//        this.auto = auto;
//        if (ll_point != null && resIds.size() > 1) {
//            ll_point.removeAllViews();
//            for (int i = 0; i < resIds.size(); i++) {
//                // 创建指示点
//                ImageView point = new ImageView(context);
//                point.setImageResource(R.drawable.point_white_4);
//                point.setAlpha(0.5f);
//                // 利用布局参数对象来设置指示点的间距
//                LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
//                params.gravity = Gravity.CENTER_VERTICAL;
//                if (i == 0) {
//                    // 第一个指示点默认高亮
//                    point.setEnabled(true);
//                    point.setImageResource(R.drawable.point_white_6);
//                    point.setAlpha(1f);
//                } else {
//                    // 除了第一个,都离前一个有5px的距离
//                    params.leftMargin = UIUtils.dip2px(5, context);
//                    point.setEnabled(false);
//                }
//                point.setLayoutParams(params);
//                // 添加到布局中
//                ll_point.addView(point);
//            }
//        }
//        MyViewpagerAdapter mViewpagerAdapter = new MyViewpagerAdapter();
//        view.setAdapter(mViewpagerAdapter);
//        view.setOffscreenPageLimit(3);
//        // 设置viewpager的监听事件
//        view.setOnPageChangeListener(new OnPageChangeListener() {
//            /**
//             * 某个条目被选中时回调
//             */
//            @Override
//            public void onPageSelected(int position) {
//                myIndex = (position % (resIds.size()));
////				Toast.makeText(context, position + "-->" + myIndex, Toast.LENGTH_SHORT).show();
//                if (ll_point != null) {
//                    if (myIndex == -1)
//                        myIndex = resIds.size() - 1;
//                    if (myIndex == resIds.size())
//                        myIndex = 0;
//                    if (mLastPoint != myIndex) {
//                        // 改变指示点高亮,通过父节点获得子节点
//                        ll_point.getChildAt(myIndex).setEnabled(true);
//                        // 指示点变大
//                        ((ImageView) ll_point.getChildAt(myIndex)).setImageResource(R.drawable.point_white_6);
//                        ((ImageView) ll_point.getChildAt(myIndex)).setAlpha(1f);
//                        // 将上一个指示点取消高亮
//                        ll_point.getChildAt(mLastPoint).setEnabled(false);
//                        // 上一个指示点恢复小圈
//                        ((ImageView) ll_point.getChildAt(mLastPoint)).setImageResource(R.drawable.point_white_4);
//                        ((ImageView) ll_point.getChildAt(mLastPoint)).setAlpha(0.5f);
//
//                    }
//                }
//                mLastPoint = myIndex;
//                currentPage = position;
//            }
//
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//                if (state == 2 && !isTaskRun) {
//                    setCurrentItem(currentPage, view);
//                    startTask();
//                    return;
//                } else if (state == 1 && isTaskRun) {
//                    stopTask();
//                    return;
//                }
//            }
//
//        });
//        setCurrentItem(currentPage, view);
//        if (resIds.size() > 1 && auto) {
//
//            startTask();
//        }
//    }
//
//    // 图片轮播viewpager的适配器
//    class MyViewpagerAdapter extends PagerAdapter {
//        @Override
//        public boolean isViewFromObject(View view, Object arg1) {
//            return (view == arg1);
//        }
//
//        @Override
//        public int getCount() {
//            // return resIds.size() + 2;
//            return resIds.size();
//
//        }
//
//        @Override
//        public void destroyItem(ViewGroup container, int position, Object object) {
//            container.removeView((View) object);
//        }
//
//        @Override
//        public Object instantiateItem(ViewGroup container, int position) {
//            int index = (position % (resIds.size()));
//            if (index == -1)
//                index = resIds.size() - 1;
//            if (index == resIds.size())
//                index = 0;
//
//            ImageView iv_viewpager = new ImageView(context);
//            iv_viewpager.setScaleType(ScaleType.FIT_XY);
//            ImageLoader.getInstance().displayImage(resIds.get(index), iv_viewpager, displayImageOptions);
//
//            iv_viewpager.setOnClickListener(new OnClickListener() {
//
//                @Override
//                public void onClick(View v) {
//                    if (onclickViewPagerItem != null) {
//                        onclickViewPagerItem.clickToDo(myIndex);
//                    }
//
//                }
//            });
//
//            container.addView(iv_viewpager);
//
//            return iv_viewpager;
//        }
//    }
//
//    /**
//     * 开启定时任务
//     */
//    public void startTask() {
//        isTaskRun = true;
//        mTimer = new Timer();
//        mTask = new TimerTask() {
//            @Override
//            public void run() {
//                currentPage++;
//                mHandler.sendEmptyMessage(0);
//
//            }
//        };
//        mTimer.schedule(mTask, seconds * 1000, seconds * 1000);// 这里设置自动切换的时间，单位是毫秒，2*1000表示2秒
//    }
//
//    /**
//     * 停止定时任务
//     */
//    public void stopTask() {
//        isTaskRun = false;
//        if (mTimer != null) {
//            mTimer.cancel();
//        }
//    }
//
//    // 处理EmptyMessage(0)
//    @SuppressLint("HandlerLeak")
//    Handler mHandler = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            setCurrentItem(currentPage, view);
//        }
//    };
//
//    /**
//     * 处理Page的切换逻辑
//     */
//    public void setCurrentItem(int currentPage, ViewPager viewPager) {
//
//        if (currentPage == resIds.size())
//            currentPage = 0;
//        viewPager.setCurrentItem(currentPage);// 取消动画
//    }
//
//    /**
//     * 轮播图item点击监听
//     *
//     * @author Administrator
//     */
//    public interface OnClickViewPagerItem {
//        /**
//         * 点击轮播图时的事件
//         */
//        public void clickToDo(int currentPage);
//    }
//
//    public void setOnclickViewPagerItem(OnClickViewPagerItem onclickViewPagerItem) {
//        this.onclickViewPagerItem = onclickViewPagerItem;
//    }
//
//}
