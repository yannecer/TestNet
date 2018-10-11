package com.necer.testnet.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.necer.testnet.R;
import com.necer.testnet.network.RxManager;
import com.necer.testnet.utils.Util;
import com.necer.testnet.view.LoadingView;

/**
 * Created by necer on 2018/10/11.
 */
public abstract class BaseActivity extends AppCompatActivity {


    private LoadingView loadingView;
    private ProgressDialog loadingDialog;
    private String TAG;//当前页面联网标识

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        TAG = getPackageName() + "." + getClass().getSimpleName();
        loadingDialog = new ProgressDialog(this);

        ViewGroup content = findViewById(R.id.content);
        if (content != null) {
            ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            loadingView = new LoadingView(this, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getNetData();
                }
            });
            content.addView(loadingView, content instanceof LinearLayout ? 0 : content.getChildCount(), layoutParams);
        }

        onCreatee(savedInstanceState);
        getNetData();
    }


    protected abstract int getLayoutId();

    protected abstract void onCreatee(Bundle savedInstanceState);

    protected abstract void getNetData();


    public String getTag() {
        return TAG;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
        RxManager.getInstance().clear(TAG);
    }


    //loadingView和loadingDialog开始
    public void onStartLoading() {
        if (Util.isEnabled(loadingView)) {
            loadingView.onStart();
        } else {
            loadingDialog.show();
        }
    }


    //loadingDialog结束
    public void onEndLoading() {
        if (loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
    }

    //loadingView成功结束
    public void onLoadingSuccess() {
        if (Util.isEnabled(loadingView)) {
            loadingView.onSuccess();
        }
    }

    //loadingView失败结束
    public void onLoadingError(String error) {
        if (Util.isEnabled(loadingView)) {
            loadingView.onError(error);
        }
    }
}
