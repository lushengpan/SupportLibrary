//package lushengpan.com.supportlibrary.view;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import android.app.Dialog;
//import android.content.Context;
//import android.os.Bundle;
//import android.os.Handler;
//import android.os.Message;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.koudaiqiche.koudaiqiche.R;
//import com.koudaiqiche.koudaiqiche.been.Area;
//import com.koudaiqiche.koudaiqiche.been.City;
//import com.koudaiqiche.koudaiqiche.been.Province;
//import com.koudaiqiche.koudaiqiche.wheel.AbstractWheelTextAdapter;
//import com.koudaiqiche.koudaiqiche.wheel.OnWheelChangedListener;
//import com.koudaiqiche.koudaiqiche.wheel.OnWheelScrollListener;
//import com.koudaiqiche.koudaiqiche.wheel.WheelView;
//
///**
// * 更改封面对话框
// *
// * @author ywl
// *
// */
//public class ChangeAddressDialog extends Dialog implements
//		View.OnClickListener {
//
//	private WheelView wvProvince;
//	private WheelView wvCitys;
//	private View lyChangeAddress;
//	private View lyChangeAddressChild;
//	private TextView btnSure;
//	private TextView btnCancel;
//
//	private Context context;
//	private JSONObject mJsonObj;
//	private String[] mProvinceDatas;
//	private Map<String, String[]> mCitisDatasMap = new HashMap<String, String[]>();
//	private Map<String, String[]> mAreaDatasMap = new HashMap<String, String[]>();
//	private ArrayList<Province> provinces = new ArrayList<Province>();
//	private ArrayList<City> arrProvinces = new ArrayList<City>();
//	private ArrayList<Area> arrCitys = new ArrayList<Area>();
//	private ArrayList<String> arrArea = new ArrayList<String>();
//	private AddressTextAdapter provinceAdapter;
//	private AddressTextAdapter cityAdapter;
//	private String currentText;
//	private String strProvince = "河北";
//	private String strCity = "石家庄";
//	private String strArea = "长安区";
//	private OnAddressCListener onAddressCListener;
//	private boolean isProvince;
//	private boolean iscity;
//	private boolean isArea;
//	private int maxsize = 24;
//	private int minsize = 14;
//	private WheelView wvArea;
//	private AddressTextAdapter AreaAdapter;
//	private Handler hander;
//	private AddressTextAdapter areaAdapter;
//	private int ProvincePoint;
//	public ChangeAddressDialog(Context context) {
//		super(context, R.style.ShareDialog);
//		this.context = context;
//	}
//
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.dialog_myinfo_changeaddress);
//
//		wvProvince = (WheelView) findViewById(R.id.wv_address_province);
//		wvCitys = (WheelView) findViewById(R.id.wv_address_city);
//		wvArea = (WheelView) findViewById(R.id.wv_address_region);
//
//		lyChangeAddress = findViewById(R.id.ly_myinfo_changeaddress);
//		lyChangeAddressChild = findViewById(R.id.ly_myinfo_changeaddress_child);
//
//		btnSure = (TextView) findViewById(R.id.btn_myinfo_sure);
//		btnCancel = (TextView) findViewById(R.id.btn_myinfo_cancel);
//		hander = new Handler() {
//
//			@Override
//			public void handleMessage(Message msg) {
//				super.handleMessage(msg);
//
//			}
//
//		};
//		lyChangeAddress.setOnClickListener(this);
//		lyChangeAddressChild.setOnClickListener(this);
//		btnSure.setOnClickListener(this);
//		btnCancel.setOnClickListener(this);
//
//		initJsonData();
//		initDatas();
//		provinceAdapter = new AddressTextAdapter(context, GetList(provinces),0, maxsize, minsize);
//		wvProvince.setVisibleItems(5);
//		wvProvince.setViewAdapter(provinceAdapter);
//		wvProvince.setCurrentItem(0);
//
//
//		cityAdapter = new AddressTextAdapter(context,GetCity(provinces.get(0)),0, maxsize, minsize);
//		wvCitys.setVisibleItems(5);
//		wvCitys.setViewAdapter(cityAdapter);
//		wvCitys.setCurrentItem(0);
//
//		AreaAdapter = new AddressTextAdapter(context,GetArea(provinces.get(0).citys.get(0)),0, maxsize, minsize);
//		wvArea.setVisibleItems(5);
//		wvArea.setViewAdapter(AreaAdapter);
//		wvArea.setCurrentItem(0);
//
//		wvProvince.addChangingListener(new OnWheelChangedListener() {
//
//
//
//			@SuppressWarnings("unchecked")
//			@Override
//			public void onChanged(WheelView wheel, int oldValue, int newValue) {
//				currentText = (String) provinceAdapter.getItemText(wheel
//						.getCurrentItem());
//				strProvince = currentText;
//				setTextviewSize(currentText, provinceAdapter);
//				Toast.makeText(context, currentText, 0).show();
//				ProvincePoint=GetProvince(currentText);
//				cityAdapter = new AddressTextAdapter(context,GetCity(provinces.get(ProvincePoint)),0,maxsize, minsize);
//				wvCitys.setVisibleItems(5);
//				wvCitys.setViewAdapter(cityAdapter);
//				wvCitys.setCurrentItem(0);
//
//				areaAdapter = new AddressTextAdapter(context, GetArea(provinces.get(GetProvince(currentText)).citys.get(0)), 0,
//						maxsize, minsize);
//				wvArea.setVisibleItems(5);
//				wvArea.setViewAdapter(areaAdapter);
//				wvArea.setCurrentItem(0);
//
//			}
//		});
//
//		wvProvince.addScrollingListener(new OnWheelScrollListener() {
//
//			@Override
//			public void onScrollingStarted(WheelView wheel) {
//
//			}
//
//			@Override
//			public void onScrollingFinished(WheelView wheel) {
//				isProvince = true;
//				String currentText = (String) provinceAdapter.getItemText(wheel
//						.getCurrentItem());
//				setTextviewSize(currentText, provinceAdapter);
//			}
//		});
//
//		wvCitys.addChangingListener(new OnWheelChangedListener() {
//
//			private AddressTextAdapter areaAdapter;
//
//			@SuppressWarnings("unchecked")
//			@Override
//			public void onChanged(WheelView wheel, int oldValue, int newValue) {
//				String currentText = (String) cityAdapter.getItemText(wheel
//						.getCurrentItem());
//				strCity = currentText;
//				setTextviewSize(currentText, cityAdapter);
//
//					areaAdapter = new AddressTextAdapter(context,  GetArea(provinces.get(GetProvince(currentText)).citys.get(GetCity(strCity))), 0,maxsize, minsize);
//					wvArea.setVisibleItems(5);
//					wvArea.setViewAdapter(areaAdapter);
//					wvArea.setCurrentItem(0);
//
//			}
//		});
//
//		wvCitys.addScrollingListener(new OnWheelScrollListener() {
//
//			@Override
//			public void onScrollingStarted(WheelView wheel) {
//
//			}
//
//			@Override
//			public void onScrollingFinished(WheelView wheel) {
//				String currentText = (String) cityAdapter.getItemText(wheel
//						.getCurrentItem());
//				setTextviewSize(currentText, cityAdapter);
//				iscity = true;
//			}
//		});
//
//		wvArea.addChangingListener(new OnWheelChangedListener() {
//
//			@Override
//			public void onChanged(WheelView wheel, int oldValue, int newValue) {
//				String currentText = (String) AreaAdapter.getItemText(wheel
//						.getCurrentItem());
//				strArea = currentText;
//				setTextviewSize(currentText, cityAdapter);
//			}
//		});
//
//		wvArea.addScrollingListener(new OnWheelScrollListener() {
//
//			@Override
//			public void onScrollingStarted(WheelView wheel) {
//
//			}
//
//			@Override
//			public void onScrollingFinished(WheelView wheel) {
//				String currentText = (String) AreaAdapter.getItemText(wheel
//						.getCurrentItem());
//				setTextviewSize(currentText, cityAdapter);
//			}
//		});
//	}
//
//	private class AddressTextAdapter extends AbstractWheelTextAdapter {
//		ArrayList<String> list;
//
//		protected AddressTextAdapter(Context context, ArrayList<String> list,
//				int currentItem, int maxsize, int minsize) {
//			super(context, R.layout.item_birth_year, NO_RESOURCE, currentItem,
//					maxsize, minsize);
//			this.list = list;
//			setItemTextResource(R.id.tempValue);
//		}
//
//		@Override
//		public View getItem(int index, View cachedView, ViewGroup parent) {
//			View view = super.getItem(index, cachedView, parent);
//			return view;
//		}
//
//		@Override
//		public int getItemsCount() {
//			return list.size();
//		}
//
//		@Override
//		protected CharSequence getItemText(int index) {
//			return list.get(index) + "";
//		}
//	}
//
//	/**
//	 * 设置字体大小
//	 *
//	 * @param curriteItemText
//	 * @param adapter
//	 */
//	public void setTextviewSize(String curriteItemText,
//			AddressTextAdapter adapter) {
//		ArrayList<View> arrayList = adapter.getTestViews();
//		int size = arrayList.size();
//		String currentText;
//		for (int i = 0; i < size; i++) {
//			TextView textvew = (TextView) arrayList.get(i);
//			currentText = textvew.getText().toString();
//			if (curriteItemText.equals(currentText)) {
//				textvew.setTextSize(24);
//			} else {
//				textvew.setTextSize(14);
//			}
//		}
//	}
//
//	public void setAddresskListener(OnAddressCListener onAddressCListener) {
//		this.onAddressCListener = onAddressCListener;
//	}
//
//	@Override
//	public void onClick(View v) {
//		if (v == btnSure) {
//			if (onAddressCListener != null) {
//				onAddressCListener.onClick(strProvince, strCity);
//			}
//		} else if (v == btnCancel) {
//
//		} else if (v == lyChangeAddressChild) {
//			return;
//		} else {
//			dismiss();
//		}
//		dismiss();
//	}
//
//	/**
//	 * 回调接口
//	 *
//	 * @author Administrator
//	 *
//	 */
//	public interface OnAddressCListener {
//		public void onClick(String province, String city);
//	}
//
//	/**
//	 * 从文件中读取地址数据
//	 */
//	private void initJsonData() {
//		try {
//			StringBuffer sb = new StringBuffer();
//			InputStream is = context.getAssets().open("city.json");
//			int len = -1;
//			byte[] buf = new byte[1024];
//			while ((len = is.read(buf)) != -1) {
//				sb.append(new String(buf, 0, len, "gbk"));
//			}
//			is.close();
//			mJsonObj = new JSONObject(sb.toString());
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (JSONException e) {
//			e.printStackTrace();
//		}
//	}
//
//	/**
//	 * 解析数据
//	 */
//	private void initDatas() {
////		try {
////			JSONArray jsonArray = mJsonObj.getJSONArray("citylist");
////			mProvinceDatas = new String[jsonArray.length()];
//			for (int i = 0; i <30; i++) {
////				JSONObject jsonP = jsonArray.getJSONObject(i);
////				String province = jsonP.getString("p");
////
////				JSONArray jsonCs = null;
////				try {
////					jsonCs = jsonP.getJSONArray("c");
////				} catch (Exception e1) {
////					continue;
////				}
////				String[] mCitiesDatas = new String[jsonCs.length()];
//				arrProvinces.clear();
//
//				ArrayList<City> Pro = new ArrayList<City>();
//				for (int j = 0; j <4; j++) {
////					JSONObject jsonCity = jsonCs.getJSONObject(j);
////					String city = jsonCity.getString("n");
////
////					JSONArray jsonAreas = null;
////					try {
////						/**
////						 * Throws JSONException if the mapping doesn't exist or
////						 * is not a JSONArray.
////						 */
////						jsonAreas = jsonCity.getJSONArray("a");
////					} catch (Exception e) {
////						continue;
////					}
////
////					String[] mAreasDatas = new String[jsonAreas.length()];
//					ArrayList<Area> c = new ArrayList<Area>();
//					for (int k = 0; k <5; k++) {
////						String area = jsonAreas.getJSONObject(k).getString("s");
//						Area a = new Area("永康"+k+"<--"+j);
//						c.add(a);
//					}
////					arrProvinces.add(new City("金华"+j+"<--"+i, arrCitys));
//					Pro.add(new City("金华"+j+"<--"+i, c));
//					// mAreaDatasMap.put(city, mAreasDatas);
//				}
//
//				provinces.add(new Province("浙江"+i, Pro));
//
//				// mCitisDatasMap.put(province, mCitiesDatas);
//			}
//
////		} catch (JSONException e) {
////			e.printStackTrace();
////		}
////		mJsonObj = null;
//	}
//
//	ArrayList GetList(ArrayList<Province> view){
//		ArrayList<String> list = new ArrayList<String>();
//		for (int i = 0; i < view.size(); i++) {
//			list.add(view.get(i).getName());
//		}
//		return list;
//
//
//
//
//
//	}
//
//
//	int GetProvince(String name){
//		for (int i = 0; i <provinces.size(); i++) {
//			if(provinces.get(i).getName().equals(name)){
//
//				return i;
//			}
//		}
//
//
//
//
//		return 0;
//
//
//
//
//
//
//	}
//
//	int GetCity(String name){
//		for (int i = 0; i <provinces.get(ProvincePoint).citys.size(); i++) {
//			if(provinces.get(ProvincePoint).citys.get(i).getName().equals(name)){
//
//				return i;
//			}
//		}
//
//
//
//
//		return 0;
//
//
//
//
//
//
//	}
//
//
//
//
//
//
//
//
//	ArrayList GetCity(Province province){
//		ArrayList<String> list = new ArrayList<String>();
//		for (int i = 0; i < province.citys.size(); i++) {
//			list.add( province.citys.get(i).getName());
//		}
//		return list;
//
//
//
//
//
//	}
//	ArrayList GetArea(City city){
//		ArrayList<String> list = new ArrayList<String>();
//		for (int i = 0; i <city.areas.size(); i++) {
//			list.add(city.areas.get(i).getName());
//		}
//		return list;
//	}
//
//
//}