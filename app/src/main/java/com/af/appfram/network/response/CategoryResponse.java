package com.af.appfram.network.response;

import com.af.appfram.model.Category;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: winton
 * @time: 2017/11/15 20:59
 * @package: com.af.appfram.network.response
 * @project: APPFram
 * @mail:
 * @describe: 一句话描述
 */
public class CategoryResponse {


    /**
     * error : false
     * results : [{"_id":"59f463ff421aa90fe72535cf","createdAt":"2017-10-28T19:03:27.978Z","desc":"是时候客观评价Retrofit了，这几点你必须明白！","publishedAt":"2017-11-14T10:43:36.180Z","source":"web","type":"Android","url":"http://www.jianshu.com/p/1f10d5477566","used":true,"who":"Tamic (码小白)"},{"_id":"59f681c7421aa90fe72535d6","createdAt":"2017-10-30T09:35:03.780Z","desc":"30多个Android开发者超赞的工具","publishedAt":"2017-11-14T10:43:36.180Z","source":"web","type":"Android","url":"https://mp.weixin.qq.com/s?__biz=MzIwMzYwMTk1NA==&mid=2247487835&idx=1&sn=3b8ddd7fd4c52e1a4d6e5c1e601d91d7","used":true,"who":"陈宇明"},{"_id":"5a095a9c421aa90fef203520","createdAt":"2017-11-13T16:41:00.788Z","desc":"2017上半年技术文章集合\u2014184篇文章分类汇总","publishedAt":"2017-11-14T10:43:36.180Z","source":"web","type":"Android","url":"https://mp.weixin.qq.com/s/grssAxDKeDLHhURp0qtVPg","used":true,"who":"codeGoogler"},{"_id":"5a097d3b421aa90fe7253630","createdAt":"2017-11-13T19:08:43.576Z","desc":"微信资深工程师张绍文答读者问：T 型工程师更受大公司欢迎","publishedAt":"2017-11-14T10:43:36.180Z","source":"web","type":"Android","url":"https://mp.weixin.qq.com/s?__biz=MzU4MjAzNTAwMA==&mid=2247483827&idx=1&sn=a92f525a37c80290da7d48047ceb241b&chksm=fdbf32e4cac8bbf290cb317edba0c320f83dd2c024e9157dc58ab8f1b5cbccf3345cafee574d#rd","used":true,"who":null},{"_id":"5a0a5677421aa90fe7253633","createdAt":"2017-11-14T10:35:35.631Z","desc":"支持 Item 展开效果的 RecyclerView。","images":["http://img.gank.io/0101e6bf-3042-495b-94d9-c88fb0bf60a6"],"publishedAt":"2017-11-14T10:43:36.180Z","source":"chrome","type":"Android","url":"https://github.com/hgDendi/ExpandableRecyclerView","used":true,"who":"代码家"},{"_id":"5a085efb421aa90fe50c01f6","createdAt":"2017-11-12T22:47:23.292Z","desc":"Android持续集成：Jenkins+Github+蒲公英/Fir.im+邮件通知","publishedAt":"2017-11-13T12:10:58.643Z","source":"web","type":"Android","url":"https://mp.weixin.qq.com/s?__biz=MzIwMzYwMTk1NA==&mid=2247488151&idx=1&sn=f329687505b416cd898c843ca558b693","used":true,"who":"陈宇明"},{"_id":"5a08f676421aa90fe50c01f7","createdAt":"2017-11-13T09:33:42.968Z","desc":"Android性能优化之列表卡顿（以\u201c简书\u201d为例）","publishedAt":"2017-11-13T12:10:58.643Z","source":"web","type":"Android","url":"https://mp.weixin.qq.com/s?__biz=MzIwMzYwMTk1NA==&mid=2247488175&idx=1&sn=b8d044fdd6b534b685e84a8fdf25398b","used":true,"who":"陈宇明"},{"_id":"5a091a1d421aa90fe50c01f8","createdAt":"2017-11-13T12:05:49.452Z","desc":"兼容 RFC 3986 的 URL lib。","publishedAt":"2017-11-13T12:10:58.643Z","source":"chrome","type":"Android","url":"https://github.com/EricEdens/urllib","used":true,"who":"代码家"},{"_id":"5a091a8a421aa90fef20351e","createdAt":"2017-11-13T12:07:38.313Z","desc":"Android Bottom Sheet 布局效果。","images":["http://img.gank.io/3fcb8ca3-fb8c-4958-9dd7-e986e3743407"],"publishedAt":"2017-11-13T12:10:58.643Z","source":"chrome","type":"Android","url":"https://github.com/qhutch/BottomSheetLayout","used":true,"who":"代码家"},{"_id":"5a027569421aa90fe7253610","createdAt":"2017-11-08T11:09:29.236Z","desc":"免费专栏推荐：小米 MIUI 系统工程师 的《从源码角度看 Android》","publishedAt":"2017-11-10T08:10:02.838Z","source":"web","type":"Android","url":"https://mp.weixin.qq.com/s?__biz=MzU4MjAzNTAwMA==&mid=2247483816&idx=1&sn=9129a1fff64c6da7dde9143dc6995ec1&chksm=fdbf32ffcac8bbe943e81a23a487e3caac0dbb64e18509e61b28666074234c58e820b1a0aeea#rd","used":true,"who":null}]
     */

    private boolean error;
    private List<Category> results;


    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }


    public List<Category> getResults() {
        return results;
    }

    public void setResults(List<Category> results) {
        this.results = results;
    }
}
