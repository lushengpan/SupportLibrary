package lushengpan.com.supportlibrary.base_mvp;

import android.app.Dialog;
import android.os.Bundle;
import android.widget.Toast;

/**
 *
 * Created by lushengpan on 2017/2/15.
 */

public abstract class BaseMVPActivity<V, T extends BasePresenter<V>> extends BaseActivity implements BaseView {
    public T presenter;
    public Dialog dialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = initPresenter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.attach((V) this);
    }

    @Override
    protected void onDestroy() {
        presenter.dettach();
        super.onDestroy();
    }

    // 实例化presenter
    public abstract T initPresenter();

    /**
     * 关闭进度条
     */
    @Override
    public void hideProgress() {
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLongToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}
