package com.necer.testnet.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.necer.testnet.R;

/**
 * Created by necer on 2018/10/11.
 */
public class LoadingView extends FrameLayout {


    private ProgressBar pb_;
    private TextView tv_error;

    public LoadingView(@NonNull Context context, View.OnClickListener onClickListener) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.view_loading, this);

        pb_ = findViewById(R.id.pb_);
        tv_error = findViewById(R.id.tv_error);
        tv_error.setOnClickListener(onClickListener);
    }


    public void onStart() {
        tv_error.setVisibility(GONE);
        pb_.setVisibility(VISIBLE);
    }


    public void onError(String failedMessage) {
        tv_error.setVisibility(VISIBLE);
        pb_.setVisibility(GONE);
        tv_error.setText(failedMessage);
    }

    public void onSuccess() {
        setVisibility(GONE);
    }

  /*  public interface OnGetNetListener {
        void getNetData();
    }

*/
}
