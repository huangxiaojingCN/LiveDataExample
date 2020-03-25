package com.honey.livedataexample;

import retrofit2.Retrofit;

public class RetrofitInstance {
    private static final String BASE_URL = "https://api.jisuapi.com/recipe/search/";

    private static Retrofit retrofit = null;

    public static RestApiService getApiService() {
        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(LenientGsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(RestApiService.class);
    }
}
