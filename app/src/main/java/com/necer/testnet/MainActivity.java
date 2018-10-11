package com.necer.testnet;

import android.os.Bundle;
import android.widget.TextView;

import com.necer.testnet.api.Api;
import com.necer.testnet.base.BaseActivity;
import com.necer.testnet.base.BaseView;
import com.necer.testnet.bean.Calendar;
import com.necer.testnet.network.Requestt;
import com.necer.testnet.network.RxObserver;

public class MainActivity extends BaseActivity implements BaseView {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


    private TextView tv_;

    @Override
    protected void onCreatee(Bundle savedInstanceState) {


        tv_ = findViewById(R.id.tv_);
    }


    @Override
    protected void getNetData() {
        Requestt.request(Api.getDefaultService().getCalendarBean("2018-10-10", "1863a50c31d7c"))
                .subscribe(new RxObserver<Calendar>(this) {
                    @Override
                    public void onSuccess(Calendar calendar) {
                        tv_.setText(calendar.toString());
                    }
                });

    }

}
