package com.bk.ft_weather.api;




import com.bk.ft_weather.bean.RealtimeWeather;
import com.zbk.lib_network.bean.ApiResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface  BizService {


    @GET("/v2.5/{token}/{lonlat}/realtime")
    Observable<ApiResponse<RealtimeWeather>> getRealtimeWeather(@Path("token") String token,
                                                                @Path("lonlat") String lonlat);

}
