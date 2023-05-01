package com.example.randomfunny.networking;

import com.google.gson.annotations.SerializedName;

public class MemeResult {

    @SerializedName("title")
    String title;

    @SerializedName("url")
    String url;


    public String getTitle() {
        return title;
    }

    @Override
    public String toString() { return url; }
}
