package com.umeng.soexample.presenter;

import com.umeng.soexample.bean.User;
import com.umeng.soexample.http.OkHttp;
import com.umeng.soexample.model.TwoModel;
import com.umeng.soexample.view.TwoView;

import java.util.List;

/**
 * date:2018/11/19    9:03
 * author:秦广帅(Lenovo)
 * fileName:TwoPresenter
 */
public class TwoPresenter {
    private TwoView mTwoView;
    private TwoModel mTwoModel;
    private List<User.DataBean.ListBean> data;

    public TwoPresenter(TwoView twoView) {
        mTwoView = twoView;
        mTwoModel = new TwoModel();
    }
    public void two(String path){
        mTwoModel.two(path, new OkHttp.HttpCallBack() {

            @Override
            public void getData(String s) {
                if(s.equals("请求成功")){
                    mTwoView.onSuccess("请求成功");
                }else{
                    mTwoView.onFailer("请求失败");
                }
            }

            @Override
            public void setData(List<User.DataBean.ListBean> list) {
                data = list;
                mTwoView.onGetData(data);
            }
        });
    }
}
