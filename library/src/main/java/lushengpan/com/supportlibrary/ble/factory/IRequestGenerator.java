package lushengpan.com.supportlibrary.ble.factory;


import lushengpan.com.supportlibrary.ble.request.IMessage;

/**
 *
 * Created by LiuLei on 2017/12/28.
 */

public abstract class IRequestGenerator {
    public abstract <R extends IMessage>IMessage generateRequest(Class<R> clazz) throws Exception;
}
