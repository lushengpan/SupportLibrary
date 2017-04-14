package lushengpan.com.supportlibrary.baseRetrofit.jsonConverterFactory;


import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;

final class JsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {

    private Type type;
    Gson mGson = new Gson();

    JsonResponseBodyConverter(Type type) {
        this.type = type;
    }


    //zhi
    @Override
    public T convert(ResponseBody value) throws IOException {

        Class clazz = (Class) type;
        String canonicalName = clazz.getCanonicalName();
        if (canonicalName.equals(JSONObject.class.getName())) {
//            LogUtils.d("进来了 JSONObject");

            try {
                JSONObject jsonObj;
                jsonObj = new JSONObject(value.string());
                return (T) jsonObj;
            } catch (Exception e) {
 //               LogUtils.e("apiservice 写的JSONObject不对");
  //              LogUtils.e("" + value.string());
 //               LogUtils.e("解析返回json数据出错:" + e.toString());
            }
        }
        return null;
    }
}
