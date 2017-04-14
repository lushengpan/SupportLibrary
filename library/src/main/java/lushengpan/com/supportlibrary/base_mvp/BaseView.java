package lushengpan.com.supportlibrary.base_mvp;

import android.support.annotation.Nullable;

/**
 * Created by lushengpan on 2017/2/15.
 */

public interface BaseView {

    void showProgress(@Nullable String msg);
    void hideProgress();
    void showToast(String msg);
    void showAlert(String msg);
    void showLongToast(String msg);

















}
