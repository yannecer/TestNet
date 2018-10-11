package com.necer.testnet.network;

import com.necer.testnet.base.BaseView;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by necer on 2017/6/28.
 */

public abstract class RxObserver<T> implements Observer<T> {

    private BaseView mBaseView;
    private boolean isShowDialog = true;

    public RxObserver(BaseView baseView) {
        this(baseView, true);
    }

    public RxObserver(BaseView baseView, boolean isShowDialog) {
        this.mBaseView = baseView;
        this.isShowDialog = isShowDialog;
    }


    @Override
    public final void onSubscribe(Disposable d) {
        RxManager.getInstance().add(mBaseView.getTag(), d);
        if (isShowDialog) mBaseView.onStartLoading();
    }

    @Override
    public final void onNext(T value) {
        onSuccess(value);
    }

    @Override
    public final void onError(Throwable e) {
        if (isShowDialog) mBaseView.onEndLoading();

        String errorMessage = getErrorMessage(e);
        mBaseView.onLoadingError(errorMessage);
        onError(e, errorMessage);

    }

    @Override
    public final void onComplete() {
        mBaseView.onLoadingSuccess();
        if (isShowDialog) mBaseView.onEndLoading();
    }

    public abstract void onSuccess(T t);

    public void onError(Throwable e, String errorMessage) {


    }

    private String getErrorMessage(Throwable e) {
        String error;
        if (e instanceof ApiException) {
            error = ((ApiException) e).getApiMessage();
        } else {
            error = e.getMessage();
        }
        return error;
    }
}
