package lushengpan.com.supportlibrary.view;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;

public class Dialog {
    Builder builder;
    private AlertDialog dialog;

    public Dialog(Context context) {
        builder = new Builder(context, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);

    }

    public Dialog(Context context, int style) {
        builder = new Builder(context, style);

    }

    public void DialogSet(View v, final Callback callback, String left, String right) {
        builder.setView(v);
        if (callback != null) {
            if (right != null) {
                builder.setPositiveButton(right, new OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        callback.RightClickListener(dialog);
                    }

                });

            }

            if (left != null) {
                builder.setNegativeButton(left, new OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        callback.LeftClickListener(dialog);
                    }

                });

            }

        }


    }

    public void show(final Callback callback) {
        dialog = builder.create();
        dialog.show();
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                callback.dismiss();
            }
        });
    }

    public void show() {
        dialog = builder.create();
        dialog.show();

    }

    public void dismiss(final Callback callback) {


    }


    public void dismiss() {
        dialog.dismiss();

    }

    public interface Callback {
        void LeftClickListener(DialogInterface dialog);

        void RightClickListener(DialogInterface dialog);

        void dismiss();
    }


}