package com.my.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.my.demo.R;

public class PieChart extends View{

    private boolean mShowText;
    private int mTextPos;

    //在Java中new的话，实现此构造函数
    public PieChart(Context context) {
        super(context);
    }

    //在xml中使用的话，实现此构造函数
    public PieChart(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray array = context.getTheme().obtainStyledAttributes(attrs, R.styleable.PieChart, 0, 0);
        mShowText = array.getBoolean(R.styleable.PieChart_showText, false);
        mTextPos = array.getInteger(R.styleable.PieChart_lablePosition, 0);
        array.recycle();
    }

    public boolean ismShowText() {
        return mShowText;
    }

    public void setmShowText(boolean mShowText) {
        this.mShowText = mShowText;
        //自定义控件的属性发生改变之后，控件的样子也可能发生改变
        //在这种情况下就需要调用invalidate()方法让系统取调用view的onDraw()重新绘制
        invalidate();
        //同样的，控件属性的改变可能导致控件所占的大小和形状发生改变
        //所以我们需要调用requestLayout()来请求测量获取一个新的布局位置
        requestLayout();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //设置控件的宽高，记住这里默认是px，记得要分辨率转换实现适配，这里不做说明
        setMeasuredDimension(getSize(widthMeasureSpec), getSize(heightMeasureSpec));
    }

    private int getSize(int measureSpec){
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        switch (specMode){
            case MeasureSpec.EXACTLY:
                //父控件告诉我们子控件了一个确定的大小，你就按这个大小来布局。
                // 比如我们指定了确定的dp值和macth_parent的情况。
                result = 200;
                break;
            case MeasureSpec.AT_MOST:
                //当前控件不能超过一个固定的最大值，一般是wrap_content的情况。
                result = Math.min(100, specSize);
                break;
            case MeasureSpec.UNSPECIFIED:
                //当前控件没有限制，要多大就有多大，这种情况很少出现
                result = 400;
                break;
        }
        return result;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
