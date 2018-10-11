package com.necer.testnet.base;

/**
 * Created by 闫彬彬 on 2017/10/11.
 * QQ:619008099
 */

public interface BaseView {

    void onStartLoading();

    void onEndLoading();

    void onLoadingSuccess();

    void onLoadingError(String error);

    String getTag();
}
