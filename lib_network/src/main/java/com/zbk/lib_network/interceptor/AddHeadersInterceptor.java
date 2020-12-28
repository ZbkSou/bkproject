package com.zbk.lib_network.interceptor;

import com.zbk.lib_network.config.Configurator;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AddHeadersInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {


        Request request = chain.request();
        Request.Builder requestBuilder = request.newBuilder();

        //查看配置中的config
        Map<String,String>  headerConfig = Configurator.getHeaderConfigs();
        // process header params inject
        Headers.Builder headerBuilder = request.headers().newBuilder();
        // 以 Entry 添加消息头
        if (headerConfig.size() > 0) {
            Iterator iterator = headerConfig.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry) iterator.next();
                headerBuilder.add((String) entry.getKey(), (String) entry.getValue());
            }
            requestBuilder.headers(headerBuilder.build());
        }

        request = requestBuilder.build();
        return chain.proceed(request);
    }

}
