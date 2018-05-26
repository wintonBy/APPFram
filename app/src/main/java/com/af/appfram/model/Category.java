package com.af.appfram.model;

import com.af.appfram.mvp.IModel;
import com.af.appfram.network.BaseSubscriber;
import com.af.appfram.network.RetrofitClient;
import com.af.appfram.network.ServerApi;
import com.af.appfram.network.response.CategoryResponse;

import java.util.List;

/**
 * @author: winton
 * @time: 2018/5/26 11:10
 * @package: com.af.appfram.model
 * @project: APPFram
 * @mail:
 * @describe: 一句话描述
 */
public class Category implements IModel {

    private String _id;
    private String createdAt;
    private String desc;
    private String publishedAt;
    private String source;
    private String type;
    private String url;
    private boolean used;
    private String who;
    private List<String> images;


    public static void getCategoryList(String category,int count,int page,BaseSubscriber<CategoryResponse> subscriber){
        RetrofitClient.getInstance().getServer().getCategory(category,count,page)
                .compose(RetrofitClient.schedulersTransForm())
                .subscribe(subscriber);
    }


    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
