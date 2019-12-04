package com.example.pp.rest;

import android.util.Log;

import com.example.pp.data.default_data.SettingDefault;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {
    private static NetworkService mInstance;
    private static String URL = SettingDefault.BASE_CONNECTION_URL;
    // office
    //private static final String BASE_URL = "http://213.108.47.244:9090";
    // home
 //   private static final String BASE_URL = "http://109.251.205.79:9090";


    private Retrofit mRetrofit;

    private NetworkService() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder client = new OkHttpClient.Builder()
                .addInterceptor(interceptor);

        //todo проверить как устанавливается URL в потоке
        Log.i("*********** URL: ", "Create with URL: " + URL);

        mRetrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build();
    }

    public static NetworkService getInstance() {
        if (mInstance == null) {
            mInstance = new NetworkService();
        }
        return mInstance;
    }

    public static void setUrl(String url){
        Log.i("********** URL", "Old URL: " + URL);
        URL = url;
        Log.i("********** URL", "New URL: " + URL);
    }

    public <T extends ApiRestRequest> T getJSONApi(Class<T> service) {
        return mRetrofit.create(service);
    }
}