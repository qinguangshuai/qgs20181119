package com.umeng.soexample;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView text;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.textview);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator animator1 = ObjectAnimator.ofFloat(text,"alpha",1.0f,0.8f);
                ObjectAnimator animator2 = ObjectAnimator.ofFloat(text,"rotationX",new float[]{0f, 360f});
                ObjectAnimator animator3 = ObjectAnimator.ofFloat(text,"scaleX",0,2);
                AnimatorSet set = new AnimatorSet();
                set.setDuration(100);
                set.playTogether(animator1,animator2,animator3);
                set.start();
                set.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        Intent intent = new Intent(MainActivity.this,TwoActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });
    }
}
