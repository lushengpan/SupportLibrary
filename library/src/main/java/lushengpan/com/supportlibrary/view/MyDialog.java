//package lushengpan.com.supportlibrary.view;
//
//import android.app.Dialog;
//import android.content.Context;
//import android.content.Intent;
//import android.util.DisplayMetrics;
//import android.view.Gravity;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.WindowManager;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.LinearLayout.LayoutParams;
//
//import com.koudaiqiche.koudaiqiche.R;
//import com.koudaiqiche.koudaiqiche.activity.CouponsActivity;
//import com.koudaiqiche.koudaiqiche.activity.GeneralShopslistviewActivity;
//import com.koudaiqiche.koudaiqiche.activity.MainActivity;
//import com.koudaiqiche.koudaiqiche.activity.RecommendedRewardActivity;
//import com.koudaiqiche.koudaiqiche.activity.RoadsideActivity;
//import com.koudaiqiche.koudaiqiche.activity.ShopDateilsActivity;
//import com.koudaiqiche.koudaiqiche.activity.WashCarActivity;
//import com.koudaiqiche.koudaiqiche.activity.WebViewActivity;
//import com.koudaiqiche.koudaiqiche.been.IndexInfo.Cate;
//import com.koudaiqiche.koudaiqiche.been.TanInfo;
//import com.koudaiqiche.koudaiqiche.utils.UIUtils;
//import com.nostra13.universalimageloader.core.ImageLoader;
//
//import org.xutils.x;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MyDialog extends Dialog implements View.OnClickListener {
//
//    TanInfo tan;
//    private ImageView imageView_redPacket;
//    private ImageView icon_back;
//    private Context context;
//    private UIUtils uiUtils;
//    private ArrayList<String> resIds;
//    private MyViewPager viewpager_home;
//    private Intent intent;
//    private List<Cate> cate;
//
//    public MyDialog(final Context context, int theme, final TanInfo tan, List<Cate> cate) {
//        super(context, theme);
//        this.context = context;
//        this.tan = tan;
//        this.cate = cate;
//        // WindowManager.LayoutParams wlmp = getWindow().getAttributes();
//        // wlmp.gravity = Gravity.CENTER_HORIZONTAL;
//        // getWindow().setAttributes(wlmp);
//        // setTitle(null);
//        // WindowManager wm = (WindowManager)
//        // context.getSystemService(Context.WINDOW_SERVICE);
//        //
//        // LayoutInflater layoutInflater = (LayoutInflater)
//        // context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        // final float scale =
//        // context.getResources().getDisplayMetrics().density;
//        // // 获取屏幕宽度
//        // DisplayMetrics outMetrics = new DisplayMetrics();
//        // wm.getDefaultDisplay().getMetrics(outMetrics);
//        // int width2 = outMetrics.widthPixels;
//        //
//        // View pop =
//        // layoutInflater.inflate(R.layout.popupwindow_home_redpacket, null);
//        // viewpager_home = (MyViewPager)
//        // pop.findViewById(R.id.vp_popupWindow_redpacket);
//        // // 设置图片轮播
//        // if (uiUtils == null) {
//        // uiUtils = new UIUtils();
//        // }
//        // resIds = new ArrayList<String>();
//        //
//        // resIds.add(tan.images);
//        //
//        // ViewPageOfAutomatic v = new ViewPageOfAutomatic(getContext(),
//        // viewpager_home, UIUtils.getImageOptions(R.drawable.icon,
//        // R.drawable.icon, false));
//        // v.initViewPager(resIds, null, new OnClickViewPagerItem() {
//        //
//        // @Override
//        // public void clickToDo(int position) {
//        // Intent intent = new Intent(context, WebViewActivity.class);
//        // intent.putExtra("url", tan.newsurl);
//        // intent.putExtra("title", tan.title);
//        // intent.putExtra("type", 1);
//        // context.startActivity(intent);
//        // dismiss();
//        //
//        // }
//        // }, 6, false, 0);
//        //
//        // LinearLayout ll_viewpager = (LinearLayout)
//        // pop.findViewById(R.id.ll_viewpager);
//        // LayoutParams layoutParams = new LayoutParams((int) width2 * 4 / 5,
//        // (int) width2 * 16 / 15);
//        // ll_viewpager.setLayoutParams(layoutParams);
//        //
//        // LinearLayout ll_popupwindow = (LinearLayout)
//        // pop.findViewById(R.id.ll_popupWindow);
//        // LayoutParams layoutParams_ll_1 = new LayoutParams((int) width2 * 4 /
//        // 5, LayoutParams.WRAP_CONTENT);
//        // ll_popupwindow.setLayoutParams(layoutParams_ll_1);
//        //
//        // LinearLayout ll_back = (LinearLayout)
//        // pop.findViewById(R.id.ll_popupWindow_back);
//        // LayoutParams layoutParams_ll = new LayoutParams((int) width2 * 4 /
//        // 50, LayoutParams.WRAP_CONTENT);
//        // ll_back.setLayoutParams(layoutParams_ll);
//        //
//        // icon_back = (ImageView) pop.findViewById(R.id.tv_popupWindow_back);
//        // LayoutParams layoutParams_back = new LayoutParams((int) width2 * 4 /
//        // 50, (int) width2 * 4 / 50);
//        // icon_back.setLayoutParams(layoutParams_back);
//        // icon_back.setOnClickListener(this);
//        //
//        // TextView textView_line = (TextView)
//        // pop.findViewById(R.id.tv_popupWindow_line);
//        // LayoutParams layoutParams_line = new LayoutParams((int) (1 / scale +
//        // 0.5f), (int) width2 * 2 / 50);
//        // textView_line.setLayoutParams(layoutParams_line);
//        //
//        // x.view().inject(pop);
//        // addContentView(pop, layoutParams_ll_1);
//        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
//
//        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        final float scale = context.getResources().getDisplayMetrics().density;
//        // 获取屏幕宽度
//        DisplayMetrics outMetrics = new DisplayMetrics();
//        wm.getDefaultDisplay().getMetrics(outMetrics);
//        int width2 = outMetrics.widthPixels;
//
//        View pop = layoutInflater.inflate(R.layout.popupwindow_home_redpacket, null);
//        imageView_redPacket = (ImageView) pop.findViewById(R.id.iv_popupWindow_redpacket);
//        LayoutParams layoutParams = new LayoutParams((int) width2 * 4 / 5, (int) width2 * 16 / 15);
//        imageView_redPacket.setLayoutParams(layoutParams);
//        ImageLoader.getInstance().displayImage(tan.images, imageView_redPacket, UIUtils.getImageOptions());
//        imageView_redPacket.setOnClickListener(this);
//
//        LinearLayout ll_popupwindow = (LinearLayout) pop.findViewById(R.id.ll_popupWindow);
//        LayoutParams layoutParams_ll_1 = new LayoutParams((int) width2 * 4 / 5, LayoutParams.WRAP_CONTENT);
//        ll_popupwindow.setLayoutParams(layoutParams_ll_1);
//
//        LinearLayout ll_back = (LinearLayout) pop.findViewById(R.id.ll_popupWindow_back);
//        LayoutParams layoutParams_ll = new LayoutParams((int) width2 * 4 / 50, LayoutParams.WRAP_CONTENT);
//        ll_back.setLayoutParams(layoutParams_ll);
//
//        icon_back = (ImageView) pop.findViewById(R.id.tv_popupWindow_back);
//        LayoutParams layoutParams_back = new LayoutParams((int) width2 * 4 / 50, (int) width2 * 4 / 50);
//        layoutParams_back.gravity = Gravity.CENTER;
//        layoutParams_back.setMargins(0, UIUtils.dip2px(31), 0, 0);
//        icon_back.setLayoutParams(layoutParams_back);
//        icon_back.setOnClickListener(this);
//        x.view().inject(pop);
//        addContentView(pop, layoutParams_ll_1);
//
//    }
//
//    public MyDialog(final Context context, int theme, View view, int width, int height) {
//        super(context, theme);
//        this.context = context;
//        LayoutParams layoutParams = new LayoutParams(width, height);
//        addContentView(view, layoutParams);
//    }
//
//    protected MyDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
//        super(context, cancelable, cancelListener);
//    }
//
//    public MyDialog(Context context) {
//        super(context);
//    }
//
//    public TanInfo getTan() {
//        return tan;
//    }
//
//    public void setTan(TanInfo tan) {
//        this.tan = tan;
//    }
//
//    @Override
//    public void show() {
//        getWindow().setWindowAnimations(R.style.popupwindow);
//        super.show();
//
//    }
//
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.iv_popupWindow_redpacket:
//                if (tan.item_type.equals("cate")) {
//                    getCateJump(tan.item_id);
//                }
//                if (tan.item_type.equals("coupon")) {
//                    intent = new Intent(context, CouponsActivity.class);
//                    context.startActivity(intent);
//                }
//                if (tan.item_type.equals("rerscue")) {
//                    intent = new Intent(context, RoadsideActivity.class);
//                    context.startActivity(intent);
//                }
//
//                if (tan.item_type.equals("weizhang")) {
//
//                }
//                if (tan.item_type.equals("yaoqing")) {
//                    intent = new Intent(context, RecommendedRewardActivity.class);
//                    context.startActivity(intent);
//                }
//                if (tan.item_type.equals("shop")) {
//                    intent = new Intent(context, ShopDateilsActivity.class);
//                    intent.putExtra("shop_id", tan.item_id);
//                    context.startActivity(intent);
//                }
//                if (tan.item_type.equals("goods")) {
//
//                }
//                if (tan.item_type.equals("nianka")) {
//                    ((MainActivity) context).rb_Annual_card_MainActivity.performClick();
//                }
//
//
//                if (tan.item_type.equals("")) {
//                    if (tan.newsurl != null && !tan.newsurl.equals("")) {
//                        Intent intent4 = new Intent(context, WebViewActivity.class);
//                        intent4.putExtra("url", tan.newsurl);
//                        intent4.putExtra("title", tan.title);
//                        intent4.putExtra("type", 1);
//                        context.startActivity(intent4);
//                    }
//                }
//
//                // Intent intent = new Intent(context, WebViewActivity.class);
//                // intent.putExtra("url", tan.newsurl);
//                // intent.putExtra("title", tan.title);
//                // intent.putExtra("type", 1);
//                // context.startActivity(intent);
//                dismiss();
//                break;
//            case R.id.tv_popupWindow_back:
//                dismiss();
//                break;
//            default:
//                break;
//        }
//
//    }
//
//    private void getCateJump(int item_id) {
//        for (int i = 0; i < cate.size(); i++) {
//            if (cate.get(i).catid == item_id) {
//
//                Intent intent;
//                if (cate.get(i).custom.equals("xiche")) {
//                    intent = new Intent(context, WashCarActivity.class);
//                    intent.putExtra("type", cate.get(i).custom);
//                    intent.putExtra("catid", cate.get(i).catid);
//                    intent.putExtra("title", cate.get(i).name);
//                    context.startActivity(intent);
//                    break;
//                } else if (cate.get(i).custom.equals("baoyang")) {
//                    intent = new Intent(context, GeneralShopslistviewActivity.class);
//                    intent.putExtra("type", cate.get(i).custom);
//                    intent.putExtra("catid", cate.get(i).catid);
//                    context.startActivity(intent);
//                    break;
//                } else if (cate.get(i).custom.equals("baoyang")) {
//                    intent = new Intent(context, GeneralShopslistviewActivity.class);
//                    intent.putExtra("type", cate.get(i).custom);
//                    intent.putExtra("catid", cate.get(i).catid);
//                    context.startActivity(intent);
//                    break;
//                } else if (cate.get(i).custom.equals("luntai")) {
//                    intent = new Intent(context, GeneralShopslistviewActivity.class);
//                    intent.putExtra("type", cate.get(i).custom);
//                    intent.putExtra("catid", cate.get(i).catid);
//                    context.startActivity(intent);
//                    break;
//                } else if (cate.get(i).custom.equals("youqi")) {
//                    intent = new Intent(context, GeneralShopslistviewActivity.class);
//                    intent.putExtra("type", cate.get(i).custom);
//                    intent.putExtra("catid", cate.get(i).catid);
//                    context.startActivity(intent);
//                    break;
//                } else if (cate.get(i).custom.equals("")) {
//                    intent = new Intent(context, GeneralShopslistviewActivity.class);
//                    intent.putExtra("type", cate.get(i).custom);
//                    intent.putExtra("catid", cate.get(i).catid);
//                    context.startActivity(intent);
//                    break;
//                }
//            }
//
//        }
//    }
//}
