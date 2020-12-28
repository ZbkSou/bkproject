package com.zbk.lib_network.config;

import java.util.ArrayList;
import java.util.HashMap;

import okhttp3.Interceptor;


/**
 * 网路参数配置
 */
public class Configurator {

    private static final HashMap<String, String> HEADER_CONFIGS = new HashMap<>();
    private static final HashMap<String, String> MOREBASEURL_CONFIGS = new HashMap<>();
    //配置连接器
    private static final ArrayList<Interceptor> INTERCEPTORS = new ArrayList<>();

    public static Configurator getInstance() {
        return Holder.INSTANCE;
    }

    public static HashMap<String, String> getHeaderConfigs() {
        return HEADER_CONFIGS;
    }

    public static HashMap<String, String> getMorebaseurlConfigs() {
        return MOREBASEURL_CONFIGS;
    }

    public static ArrayList<Interceptor> getINTERCEPTORS() {
        return INTERCEPTORS;
    }

    private static class Holder {
        private static final Configurator INSTANCE = new Configurator();
    }
    /**
     * 配置拦截器
     * @param interceptor
     * @return
     */
    public final Configurator withInterceptor(Interceptor interceptor){
        INTERCEPTORS.add(interceptor);
        return this;
    }

    /**
     * 配置header
     * @param  k
     * @param v
     * @return
     */
    public final Configurator withHeader(String k,String v){
        HEADER_CONFIGS.put(k,v);
        return this;
    }


    /**
     * 配置url
     * @param  k
     * @param v
     * @return
     */
    public final Configurator withBaseUrl(String k,String v){
        MOREBASEURL_CONFIGS.put(k,v);
        return this;
    }
}
