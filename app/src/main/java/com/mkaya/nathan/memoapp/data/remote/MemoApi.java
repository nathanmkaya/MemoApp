package com.mkaya.nathan.memoapp.data.remote;

import com.mkaya.nathan.memoapp.data.model.Message;
import com.squareup.okhttp.Credentials;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Headers;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;
import rx.Observable;

/**
 * Created by marvel on 9/30/15.
 */
public interface MemoApi {

    /**

     Groups
         url - groups/{name}
         GET - {name}
         POST - (name-R,fullname,password-R,image)
         PUT - {name} (name-R,fullname,password-R,image)
         DELETE {name}

         url - groups/authenticate
         POST (username-R,password-R)

     Individuals
         url - individuals/{id-no}
         GET - {id-no}
         POST - (id-no-R,name,password-R,image)
         PUT - {id-no} (id-no-R,name,password-R,image)
         DELETE {id-no}

         url -individuals/authenticate
         POST (username-R,password-R)
     */

    static final String BASE_URL = "http://dita.dev.ngrok.io/api/";
    static final String BASIC_AUTH = Credentials.basic("mobile","mobile");

    /**
     *
     */
    static final String INDIVIDUAL_AUTH = "individuals/authenticate/";
    static final String INDIVIDUAL_ = "";

    /**
     *
     */
    static final String GROUP_AUTH = "groups/authenticate/";




    /**
     * Retrofit Callbacks
     */

    @FormUrlEncoded
    @POST(INDIVIDUAL_AUTH)
    Call<Message> individualAuth(/*@Header("Authorization") String auth, */@Field("username") String username, @Field("password") String password);

    @POST(GROUP_AUTH)
    Call<Message> groupAuth(@Header("Authorization") String auth, @Body String empty);

    @GET("/")
    Call<Message> trial();

}
