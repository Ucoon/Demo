package com.my.anim;

import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

import com.my.demo.R;

public class AnimationTest {

    //平移动画
    public void clickToTranslate(View targetView){
        TranslateAnimation translateAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, 1,
                Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, 1);
        translateAnimation.setDuration(2000);
        targetView.startAnimation(translateAnimation);
    }

    //缩放动画
    public void clickToScale(View targetView){
        ScaleAnimation scaleAnimation = new ScaleAnimation(
                1, 0.5f,
                1, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(2000);
        targetView.startAnimation(scaleAnimation);
    }

    //旋转动画
    public void clickToRotate(View targetView){
        RotateAnimation rotateAnimation = new RotateAnimation(
                0, 360,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5F
        );
        rotateAnimation.setDuration(2000);
        targetView.startAnimation(rotateAnimation);
    }

    //渐变动画
    public void clickToAlpha(View targetView){
        AlphaAnimation alphaAnimation = new AlphaAnimation(
                1, 0.5f
        );
        alphaAnimation.setDuration(2000);
        targetView.startAnimation(alphaAnimation);
    }

    //组合动画
    public void clickToSet(View targetView){
        AlphaAnimation alphaAnimation = new AlphaAnimation(
                1, 0.5f
        );
        alphaAnimation.setDuration(2000);

        RotateAnimation rotateAnimation = new RotateAnimation(
                0, 360,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5F
        );
        rotateAnimation.setDuration(2000);

        ScaleAnimation scaleAnimation = new ScaleAnimation(
                1, 0.5f,
                1, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(2000);

        TranslateAnimation translateAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, 1,
                Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, 1);
        translateAnimation.setDuration(2000);

        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(rotateAnimation);
        animationSet.addAnimation(scaleAnimation);
        //设置动画过程监听
        animationSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        targetView.startAnimation(animationSet);
    }

    //帧动画
    public void clickToAnimationList(View targetView){
        targetView.setBackgroundResource(R.drawable.fram_animation_list);
        AnimationDrawable drawable = (AnimationDrawable) targetView.getBackground();
        drawable.start();
    }
}
