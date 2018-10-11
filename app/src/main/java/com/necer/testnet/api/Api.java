package com.necer.testnet.api;

import com.necer.testnet.network.RxRetrofit;

/**
 * Created by necer on 2018/10/11.
 */
public class Api {


    //http://apicloud.mob.com/appstore/calendar/day?key=1863a50c31d7c&date=2018-10-10

    public static String BASE_URL = "http://apicloud.mob.com/appstore/";




    private static ApiService defaultService;
    public static ApiService getDefaultService() {
        if (defaultService == null) {
            defaultService = RxRetrofit.getRetrofit(BASE_URL,true).create(ApiService.class);
        }
        return defaultService;
    }




}
