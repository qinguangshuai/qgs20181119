package com.umeng.soexample.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.umeng.soexample.R;
import com.umeng.soexample.bean.User;

import java.util.List;

/**
 * date:2018/11/19    9:15
 * author:秦广帅(Lenovo)
 * fileName:TwoAdapter
 */
public class TwoAdapter extends RecyclerView.Adapter<TwoAdapter.MyViewHolder> {

    private Context mContext;
    private List<User.DataBean.ListBean> list;

    public TwoAdapter(Context context, List<User.DataBean.ListBean> list) {
        mContext = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item, viewGroup, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        //User.DataBean.ListBean bean = list.get(i);
        myViewHolder.text.setText(list.get(i).getTitle());
        String images = list.get(i).getImages();
        String[] str = images.split("!");
        Picasso.with(mContext).load(str[0]).into(myViewHolder.image);
        if(i!=0){
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(myViewHolder.image.getLayoutParams());
            params.setMargins(0,100,0,0);
            myViewHolder.image.setLayoutParams(params);
        }else{
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(myViewHolder.image.getLayoutParams());
            params.setMargins(0,20,0,0);
            myViewHolder.image.setLayoutParams(params);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView text;
        ImageView image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.text);
            image = itemView.findViewById(R.id.image);
        }
    }
}
