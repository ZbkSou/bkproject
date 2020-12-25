package com.bk.lib_base.module;

import com.bk.lib_base.bean.RealtimeWeather;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface  BizService {

    @GET("/v2.5/{token}/{lonlat}/realtime")
    Observable<RealtimeWeather> getRealtimeWeather(@Path("token") String token,
                                               @Path("lonlat") String lonlat);
}
