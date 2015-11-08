package com.mkaya.nathan.memoapp.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Created by marvel on 9/30/15.
 */
public class Message {

    @SerializedName("message")
    @Expose
    public String message;

    @SerializedName("Error")
    @Expose
    public String Error;
}
