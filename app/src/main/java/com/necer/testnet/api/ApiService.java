package com.necer.testnet.api;

import com.necer.testnet.bean.Calendar;
import com.necer.testnet.network.HttpResult;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by necer on 2018/10/11.
 */
public interface ApiService {


    @GET("calendar/day")
    Observable<String> getCalendarJson(@Query("date") String date, @Query("key") String key);

    @GET("calendar/day")
    Observable<HttpResult<Calendar>> getCalendarBean(@Query("date") String date,@Query("key") String key);







}
