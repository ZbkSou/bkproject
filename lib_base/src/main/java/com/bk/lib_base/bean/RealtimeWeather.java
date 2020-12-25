package com.bk.lib_base.bean;

public class RealtimeWeather {

    /**
     * realtime : {"status":"ok","temperature":27.09,"humidity":0.78,"cloudrate":0.42,"skycon":"LIGHT_RAIN","visibility":24.13,"dswrf":310,"wind":{"speed":13.71,"direction":172.16},"pressure":101040,"apparent_temperature":19.6,"precipitation":{"local":{"status":"ok","datasource":"gfs","intensity":0.1693}},"air_quality":{"pm25":0,"pm10":0,"o3":0,"so2":0,"no2":0,"co":0,"aqi":{"chn":0,"usa":0},"description":{"usa":"","chn":"缺数据"}},"life_index":{"ultraviolet":{"index":5,"desc":"中等"},"comfort":{"index":3,"desc":"热"}}}
     * primary : 0
     */

    private RealtimeBean realtime;
    private Integer primary;


    public static class RealtimeBean {
        /**
         * status : ok
         * temperature : 27.09
         * humidity : 0.78
         * cloudrate : 0.42
         * skycon : LIGHT_RAIN
         * visibility : 24.13
         * dswrf : 310
         * wind : {"speed":13.71,"direction":172.16}
         * pressure : 101040
         * apparent_temperature : 19.6
         * precipitation : {"local":{"status":"ok","datasource":"gfs","intensity":0.1693}}
         * air_quality : {"pm25":0,"pm10":0,"o3":0,"so2":0,"no2":0,"co":0,"aqi":{"chn":0,"usa":0},"description":{"usa":"","chn":"缺数据"}}
         * life_index : {"ultraviolet":{"index":5,"desc":"中等"},"comfort":{"index":3,"desc":"热"}}
         */

        private String status;
        private Double temperature;
        private Double humidity;
        private Double cloudrate;
        private String skycon;
        private Double visibility;
        private Integer dswrf;
        private WindBean wind;
        private Integer pressure;
        private Double apparent_temperature;
        private PrecipitationBean precipitation;
        private AirQualityBean air_quality;
        private LifeIndexBean life_index;

        public static class WindBean {
            /**
             * speed : 13.71
             * direction : 172.16
             */

            private Double speed;
            private Double direction;
        }


        public static class PrecipitationBean {
            /**
             * local : {"status":"ok","datasource":"gfs","intensity":0.1693}
             */

            private LocalBean local;

            public static class LocalBean {
                /**
                 * status : ok
                 * datasource : gfs
                 * intensity : 0.1693
                 */

                private String status;
                private String datasource;
                private Double intensity;
            }
        }

        public static class AirQualityBean {
            /**
             * pm25 : 0
             * pm10 : 0
             * o3 : 0
             * so2 : 0
             * no2 : 0
             * co : 0
             * aqi : {"chn":0,"usa":0}
             * description : {"usa":"","chn":"缺数据"}
             */

            private Integer pm25;
            private Integer pm10;
            private Integer o3;
            private Integer so2;
            private Integer no2;
            private Integer co;
            private AqiBean aqi;
            private DescriptionBean description;

            public static class AqiBean {
                /**
                 * chn : 0
                 * usa : 0
                 */

                private Integer chn;
                private Integer usa;
            }

            public static class DescriptionBean {
                /**
                 * usa :
                 * chn : 缺数据
                 */

                private String usa;
                private String chn;
            }
        }

        public static class LifeIndexBean {
            /**
             * ultraviolet : {"index":5,"desc":"中等"}
             * comfort : {"index":3,"desc":"热"}
             */

            private UltravioletBean ultraviolet;
            private ComfortBean comfort;

            public static class UltravioletBean {
                /**
                 * index : 5
                 * desc : 中等
                 */

                private Integer index;
                private String desc;
            }

            public static class ComfortBean {
                /**
                 * index : 3
                 * desc : 热
                 */

                private Integer index;
                private String desc;
            }
        }
    }
}
