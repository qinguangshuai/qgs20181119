package com.umeng.soexample.model;

import com.google.gson.Gson;
import com.umeng.soexample.bean.User;
import com.umeng.soexample.http.OkHttp;

import java.util.ArrayList;
import java.util.List;

/**
 * date:2018/11/19    9:03
 * author:秦广帅(Lenovo)
 * fileName:TwoModel
 */
public class TwoModel {
    List<User.DataBean.ListBean>  mList =new ArrayList<>();
    public void two(String path, final OkHttp.HttpCallBack callBack){
        OkHttp okHttp = new OkHttp();
        okHttp.two(path, new OkHttp.HttpCallBack() {
            @Override
            public void getData(String s) {
                Gson gson = new Gson();
                User user = gson.fromJson(s, User.class);
                //String msg = user.getMsg();
                //callBack.getData(msg);
                for (int i = 0; i < mList.size(); i++) {
                    mList.addAll(user.getData().get(i+1).getList());
                }

                callBack.setData(mList);
            }

            @Override
            public void setData(List<User.DataBean.ListBean> data) {

            }
        });
    }
}
