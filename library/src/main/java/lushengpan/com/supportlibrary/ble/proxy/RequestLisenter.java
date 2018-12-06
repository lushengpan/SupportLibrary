package lushengpan.com.supportlibrary.ble.proxy;


import lushengpan.com.supportlibrary.ble.callback.BleConnCallback;
import lushengpan.com.supportlibrary.ble.callback.BleMtuCallback;
import lushengpan.com.supportlibrary.ble.callback.BleNotiftCallback;
import lushengpan.com.supportlibrary.ble.callback.BleReadCallback;
import lushengpan.com.supportlibrary.ble.callback.BleReadRssiCallback;
import lushengpan.com.supportlibrary.ble.callback.BleScanCallback;
import lushengpan.com.supportlibrary.ble.callback.BleWriteCallback;
import lushengpan.com.supportlibrary.ble.callback.BleWriteEntityCallback;

/**
 *
 * Created by LiuLei on 2017/10/30.
 */

public interface RequestLisenter<T> {

    void startScan(BleScanCallback<T> callback);

    void stopScan();

    boolean connect(T device, BleConnCallback<T> callback);

    boolean connect(String address, BleConnCallback<T> callback);

    void notify(T device, BleNotiftCallback<T> callback);

    void unNotify(T device);

    void disconnect(T device);

    void disconnect(T device, BleConnCallback<T> callback);

    boolean read(T device, BleReadCallback<T> callback);

    boolean readRssi(T device, BleReadRssiCallback<T> callback);

    boolean write(T device, byte[] data, BleWriteCallback<T> callback);

    void writeEntity(T device, final byte[] data, int packLength, int delay, BleWriteEntityCallback<T> callback);

//    boolean writeAutoEntity(T device, final byte[]data, int packLength);

    boolean setMtu(String address, int mtu, BleMtuCallback<T> callback);
}
