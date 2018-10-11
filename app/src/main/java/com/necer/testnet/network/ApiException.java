package com.necer.testnet.network;

/**
 * 自定义异常
 */
public class ApiException extends Exception {
    private String code;//错误码
    private String apiMessage;//错误信息

    public ApiException(String code, String apiMessage) {
        this.code = code;
        this.apiMessage = apiMessage;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public String getApiMessage() {
        return apiMessage;
    }

    public void setApiMessage(String apiMessage) {
        this.apiMessage = apiMessage;
    }
}
