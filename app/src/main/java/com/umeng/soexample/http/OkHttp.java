package com.umeng.soexample.http;

import com.umeng.soexample.bean.User;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * date:2018/11/19    9:04
 * author:秦广帅(Lenovo)
 * fileName:OkHttp
 */
public class OkHttp {
    public OkHttp two(String path, final HttpCallBack callBack){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(path)
                .get()
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                int code = response.code();
                if(code==200){
                    ResponseBody body = response.body();
                    String string = body.string();
                    callBack.getData(string);
                }
            }
        });
        return this;
    }
    public interface HttpCallBack{
        void getData(String s);
        void setData(List<User.DataBean.ListBean> data);
    }
}
