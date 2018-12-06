package lushengpan.com.supportlibrary.ble.request;

import android.os.Message;


import lushengpan.com.supportlibrary.ble.Ble;
import lushengpan.com.supportlibrary.ble.BleDevice;
import lushengpan.com.supportlibrary.ble.BleHandler;
import lushengpan.com.supportlibrary.ble.BleStates;
import lushengpan.com.supportlibrary.ble.BluetoothLeService;
import lushengpan.com.supportlibrary.ble.annotation.Implement;
import lushengpan.com.supportlibrary.ble.callback.BleMtuCallback;

/**
 *
 * Created by LiuLei on 2017/10/23.
 */
@Implement(MtuRequest.class)
public class MtuRequest<T extends BleDevice> implements IMessage {

    private BleMtuCallback<T> mBleLisenter;

    protected MtuRequest() {
        BleHandler handler = BleHandler.getHandler();
        handler.setHandlerCallback(this);
    }

    public boolean setMtu(String address, int mtu, BleMtuCallback<T> lisenter){
        this.mBleLisenter = lisenter;
        boolean result = false;
        BluetoothLeService service = Ble.getInstance().getBleService();
        if (Ble.getInstance() != null && service != null) {
            result = service.setMTU(address, mtu);
        }
        return result;
    }

    @Override
    public void handleMessage(Message msg) {
        switch (msg.what){
            case BleStates.BleStatus.MTUCHANGED:
                if(msg.obj instanceof BleDevice){
                    BleDevice device = (BleDevice) msg.obj;
                    if(mBleLisenter != null){
                        mBleLisenter.onMtuChanged(device, msg.arg1, msg.arg2);
                    }
                }
                break;
            default:
                break;
        }
    }
}
