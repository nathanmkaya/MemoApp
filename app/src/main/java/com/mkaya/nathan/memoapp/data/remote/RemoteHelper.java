package com.mkaya.nathan.memoapp.data.remote;


import com.squareup.okhttp.Credentials;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
/*
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
*/


import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;



/**
 * Created by marvel on 9/30/15.
 */
public class RemoteHelper {
    MemoApi memoApi;

    public RemoteHelper() {
        OkHttpClient client = new OkHttpClient();
        client.interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();

                // Customize the request
                Request request = original.newBuilder()
                        .header("Accept", "application/json")
                        .header("Authorization", MemoApi.BASIC_AUTH)
                        .build();

                Response response = chain.proceed(request);

                // Do anything with response here

                return response;
            }
        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MemoApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                //.client(client)
                .build();



        memoApi = retrofit.create(MemoApi.class);
    }

    public MemoApi getMemoApi(){
        return memoApi;
    }
}
