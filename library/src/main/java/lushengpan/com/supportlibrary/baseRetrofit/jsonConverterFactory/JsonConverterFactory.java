package lushengpan.com.supportlibrary.baseRetrofit.jsonConverterFactory;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

public class JsonConverterFactory extends Converter.Factory {

    public static JsonConverterFactory create() {
        return new JsonConverterFactory();
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        if (type.toString().equals("class org.json.JSONObject")) {
            return new JsonResponseBodyConverter<Type>(type);
        } else {
            Gson gson = new Gson();

            TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(type));
            return new GsonResponseBodyConverter_lsp<>(gson, adapter);
        }
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {

        return new JsonRequestBodyConverter<Type>();
    }
}
