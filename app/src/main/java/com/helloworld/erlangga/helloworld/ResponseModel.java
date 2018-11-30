package com.helloworld.erlangga.helloworld;

import android.hardware.camera2.TotalCaptureResult;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseModel {

    @SerializedName("status")
    private String status;

    @SerializedName("totalResults")
    private int totalResults;

    @SerializedName("articles")
    private List<Article> articles = null;

    public String getStatus(){
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults(){
        return totalResults;
    }

    public void setTotalResults(){
        this.totalResults = totalResults;
    }

    public List<Article> getArticles(){
        return articles;
    }

    public void setArticles(List<Article> articles){
        this.articles = articles;
    }
}
