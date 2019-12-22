package com.my.anim;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.AnimationSet;

import com.my.demo.R;

import java.util.Set;

/**
 * 属性动画
 */
public class PropertyAnimation {

    //旋转
    private void rtateAnimation(View view){
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(view, "rotation",
                0f, 360f);
        objectAnimator.setDuration(2000);
        objectAnimator.start();
    }

    //渐变
    private void alphaAnimation(View view){
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(view, "alpha",
                1.0f, 0.8f, 0.6f, 0.4f, 0.2f, 0f);
        //setRepeatCount：设置动画的重复次数（-1表示无限重复）
        objectAnimator.setRepeatCount(-1);
        //setRepeatMode：设置动画的重复模式（reverse:逆向重复，restart：连续重复）
        objectAnimator.setRepeatMode(ObjectAnimator.REVERSE);
        objectAnimator.setDuration(2000);
        objectAnimator.start();
    }

    //组合
    private void setAnimation(View view){
        ObjectAnimator alpha = ObjectAnimator.ofFloat(view, "alpha",
                1.0f, 0.8f, 0.6f, 0.4f, 0.2f, 0f);
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(view, "scaleX", 0.0f, 1.0f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(view, "scaleY", 0.0f, 1.0f);
        ObjectAnimator rotation = ObjectAnimator.ofFloat(view, "rotation", 0f, 360f);
        ObjectAnimator translateX = ObjectAnimator.ofFloat(view, "translationX", 100, 400);
        ObjectAnimator translateY = ObjectAnimator.ofFloat(view, "translationY", 100, 750);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(scaleX, scaleY, rotation, translateX, translateY);
        animatorSet.setDuration(2000);
        animatorSet.start();
    }
}
