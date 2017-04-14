package lushengpan.com.supportlibrary.base_mvp;

/**
 * Created by lushengpan on 2017/2/15.
 */

public abstract class BasePresenter<T> {

    public T mView;

    public void attach(T mView) {
        this.mView = mView;
    }

    public void dettach() {
        mView = null;
    }

    public abstract void onCreate();
    public abstract void onDestroy();

}