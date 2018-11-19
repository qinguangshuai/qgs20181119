package com.umeng.soexample.view;

import com.umeng.soexample.bean.User;

import java.util.List;

/**
 * date:2018/11/19    9:02
 * author:秦广帅(Lenovo)
 * fileName:TwoView
 */
public interface TwoView {
    void onSuccess(String result);
    void onFailer(String msg);
    void onGetData(List<User.DataBean.ListBean> list);
}
