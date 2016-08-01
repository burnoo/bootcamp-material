package com.droidsonroids.materialmusicfacts.views.behaviour.fab;


import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

import com.droidsonroids.materialmusicfacts.R;
import com.droidsonroids.materialmusicfacts.common.Constants;

public class HidingFab extends FloatingActionButton {
    private int right;

    public HidingFab(Context context) {
        super(context);
    }

    public HidingFab(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.HidingFab);

        right = ta.getInt(R.styleable.HidingFab_hideStyle, 0);
        ta.recycle();
    }

    public void showModified() {
        if (right == 1)
            showRight();
        else
            show();
    }

    public void hideModified() {
        if (right == 1)
            hideRight();
        else
            hide();
    }

    private void hideRight() {
        Animation hideAnimation = new TranslateAnimation(0, Constants.OUT_OFF_SCREEN_PX, 0, 0);
        hideAnimation.setDuration(Constants.CUSTOM_HIDE_SHOW_FAB_SPEED);
        setAnimation(hideAnimation);
        setVisibility(INVISIBLE);
    }

    private void showRight() {
        Animation showAnimation = new TranslateAnimation(Constants.OUT_OFF_SCREEN_PX, 0, 0, 0);
        showAnimation.setDuration(Constants.CUSTOM_HIDE_SHOW_FAB_SPEED);
        setAnimation(showAnimation);
        setVisibility(VISIBLE);
    }
}
