package com.umeng.soexample;

import android.app.Fragment;
import android.content.Intent;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.umeng.socialize.UMShareAPI;
import com.umeng.soexample.fragment.OneFragment;
import com.umeng.soexample.fragment.TwoFragment;

import java.util.ArrayList;

public class TwoActivity extends AppCompatActivity {

    private ViewPager paget;
    private RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        paget = findViewById(R.id.pager);
        rg = findViewById(R.id.rg);
        final ArrayList<Fragment> list = new ArrayList();
        list.add(new OneFragment());
        list.add(new TwoFragment());
        paget.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                rg.check(rg.getChildAt(i).getId());
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case  R.id.rb1:
                        paget.setCurrentItem(0);
                        break;
                    case  R.id.rb2:
                        paget.setCurrentItem(1);
                        break;
                }
            }
        });
        paget.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(getApplicationContext()).onActivityResult(requestCode,resultCode,data);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        UMShareAPI.get(getApplicationContext()).release();
    }
}
