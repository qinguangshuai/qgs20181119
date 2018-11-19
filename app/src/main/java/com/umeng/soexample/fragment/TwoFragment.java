package com.umeng.soexample.fragment;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.soexample.R;

import java.util.Iterator;
import java.util.Map;

public class TwoFragment extends Fragment {

    private ImageView image1;
    private TextView text1,text2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        image1 = view.findViewById(R.id.image1);
        text1 = view.findViewById(R.id.text1);
        text2 = view.findViewById(R.id.text2);
        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                authorization(SHARE_MEDIA.QQ);
            }
        });
        return view;
    }
    private void authorization(SHARE_MEDIA share_media){
        UMShareAPI.get(getActivity()).getPlatformInfo(getActivity(), share_media, new UMAuthListener() {
            @Override
            public void onStart(SHARE_MEDIA share_media) {
                Log.e("asdas","1");
            }

            @Override
            public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {

                String openid = map.get("openid");
                String name = map.get("name");
                String iconurl = map.get("iconurl");
                Toast.makeText(getActivity(),""+name+openid+iconurl,Toast.LENGTH_SHORT).show();
                Log.e("asdas",""+name);
                Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
                while (iterator.hasNext()){
                    Map.Entry<String, String> entry = iterator.next();
                    if(entry.getKey().equals("iconurl")){
                        Picasso.with(getActivity()).load(entry.getValue()).into(image1);
                    }
                    if(entry.getKey().equals("openid")){
                        text1.setText(entry.getValue());
                    }
                    if(entry.getKey().equals("name")){
                        text2.setText(entry.getValue());
                    }
                }
            }

            @Override
            public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
                Log.e("asdas","2");
            }

            @Override
            public void onCancel(SHARE_MEDIA share_media, int i) {

            }
        });
    }
}
