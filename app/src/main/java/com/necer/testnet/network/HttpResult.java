package com.necer.testnet.network;

/**
 * Created by necer on 2018/3/22.
 */

public class HttpResult<T> {

    public String msg;
    public String retCode;
    public T result;

    public boolean isSuccess() {
        return "200".equals(retCode);
    }

}
