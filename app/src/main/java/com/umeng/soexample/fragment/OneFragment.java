package com.umeng.soexample.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.umeng.soexample.R;
import com.umeng.soexample.adapter.TwoAdapter;
import com.umeng.soexample.bean.User;
import com.umeng.soexample.presenter.TwoPresenter;
import com.umeng.soexample.url.UrlUtil;
import com.umeng.soexample.view.TwoView;

import java.util.List;

public class OneFragment extends Fragment implements TwoView {

    private RecyclerView recycle;
    private TwoPresenter mPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        recycle = view.findViewById(R.id.recycle);
        mPresenter = new TwoPresenter(this);
        mPresenter.two(UrlUtil.PATh);
        return view;
    }

    @Override
    public void onSuccess(String result) {

    }

    @Override
    public void onFailer(String msg) {

    }

    @Override
    public void onGetData(final List<User.DataBean.ListBean> list) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                layoutid(false,true);
                TwoAdapter adapter = new TwoAdapter(getActivity(),list);
                recycle.setAdapter(adapter);
            }
        });
    }
    public void layoutid(boolean a,boolean b){
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,b?StaggeredGridLayoutManager.VERTICAL:StaggeredGridLayoutManager.HORIZONTAL);
        recycle.setLayoutManager(staggeredGridLayoutManager);
    }
}
