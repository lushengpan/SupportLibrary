package lushengpan.com.supportlibrary.ble.request;

import android.os.Message;

import lushengpan.com.supportlibrary.ble.Ble;
import lushengpan.com.supportlibrary.ble.BleDevice;
import lushengpan.com.supportlibrary.ble.BleHandler;
import lushengpan.com.supportlibrary.ble.BleStates;
import lushengpan.com.supportlibrary.ble.BluetoothLeService;
import lushengpan.com.supportlibrary.ble.annotation.Implement;
import lushengpan.com.supportlibrary.ble.callback.BleReadRssiCallback;


/**
 *
 * Created by LiuLei on 2017/10/23.
 */
@Implement(ReadRssiRequest.class)
public class ReadRssiRequest<T extends BleDevice> implements IMessage {

    private BleReadRssiCallback<T> mBleLisenter;

    protected ReadRssiRequest() {
        BleHandler handler = BleHandler.getHandler();
        handler.setHandlerCallback(this);
    }

    public boolean readRssi(T device, BleReadRssiCallback<T> lisenter){
        this.mBleLisenter = lisenter;
        boolean result = false;
        BluetoothLeService service = Ble.getInstance().getBleService();
        if (Ble.getInstance() != null && service != null) {
            result = service.readRssi(device.getBleAddress());
        }
        return result;
    }

    @Override
    public void handleMessage(Message msg) {
        switch (msg.what){
            case BleStates.BleStatus.ReadRssi:
                if(msg.obj instanceof Integer){
                    int rssi = (int) msg.obj;
                    if(mBleLisenter != null){
                        mBleLisenter.onReadRssiSuccess(rssi);
                    }
                }
                break;
            default:
                break;
        }
    }
}
