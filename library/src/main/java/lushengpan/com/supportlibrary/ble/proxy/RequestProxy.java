package lushengpan.com.supportlibrary.ble.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import lushengpan.com.supportlibrary.ble.L;
import lushengpan.com.supportlibrary.ble.request.ConnectRequest;
import lushengpan.com.supportlibrary.ble.request.MtuRequest;
import lushengpan.com.supportlibrary.ble.request.NotifyRequest;
import lushengpan.com.supportlibrary.ble.request.ReadRequest;
import lushengpan.com.supportlibrary.ble.request.ReadRssiRequest;
import lushengpan.com.supportlibrary.ble.request.Rproxy;
import lushengpan.com.supportlibrary.ble.request.ScanRequest;
import lushengpan.com.supportlibrary.ble.request.WriteRequest;

/**
 *
 * Created by LiuLei on 2017/9/1.
 */

public class RequestProxy implements InvocationHandler{
    private static final String TAG = "RequestProxy";

    private Object tar;

    private static RequestProxy instance = new RequestProxy();


    public static RequestProxy getInstance(){
        return instance;
    }

    //Bind the delegate object and return the proxy class
    public Object bindProxy(Object tar){
        this.tar = tar;
        //绑定委托对象，并返回代理类
        L.e(TAG, "bindProxy: "+"Binding agent successfully");
        Rproxy.getInstance().init(ScanRequest.class,
                ConnectRequest.class,
                NotifyRequest.class,
                ReadRequest.class,
                ReadRssiRequest.class,
                WriteRequest.class,
                MtuRequest.class
        );
        return Proxy.newProxyInstance(
                tar.getClass().getClassLoader(),
                tar.getClass().getInterfaces(),
                this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(tar,args);
    }
}
