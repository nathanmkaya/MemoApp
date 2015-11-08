package com.mkaya.nathan.memoapp.data;

import android.util.Log;

import com.mkaya.nathan.memoapp.data.model.Message;
import com.mkaya.nathan.memoapp.data.remote.MemoApi;
import com.mkaya.nathan.memoapp.data.remote.RemoteHelper;
import com.mkaya.nathan.memoapp.ui.activity.WelcomeActivity;
//import com.mkaya.nathan.memoapp.utils.EmptyOutput;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by marvel on 9/30/15.
 */
public class DataManager {
    RemoteHelper remoteHelper;

    public DataManager() {
        remoteHelper = new RemoteHelper();
    }

    public void tryAuth(){
        Call<Message> messageCall = remoteHelper.getMemoApi().individualAuth(/*MemoApi.BASIC_AUTH,*/"77-7777","Pass");
        messageCall.enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Response<Message> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    // request successful (status code 200, 201)
                    Log.i("Retrofit Success: ", String.valueOf(response.code()));

                } else {
                    //request not successful (like 400,401,403 etc)
                    //Handle errors
                    Log.i("Retrofit Error: ", String.valueOf(response.code()));
                    //Log.i("Retrofit: ", result.message);
                }
                //message = response.body();
                //Log.i("Retrofit: ", message.toString());
            }

            @Override
            public void onFailure(Throwable t) {
                Log.i("Retrofit: ", t.getMessage());
            }
        });
    }


}
