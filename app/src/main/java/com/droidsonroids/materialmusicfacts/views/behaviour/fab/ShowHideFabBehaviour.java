package com.droidsonroids.materialmusicfacts.views.behaviour.fab;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.View;

public class ShowHideFabBehaviour extends CoordinatorLayout.Behavior<HidingFab> {

    public ShowHideFabBehaviour() {
        super();
    }

    public ShowHideFabBehaviour(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, HidingFab child, View dependency) {
        return dependency instanceof NestedScrollView;
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, HidingFab child, View directTargetChild, View target, int nestedScrollAxes) {
        child.hideModified();
        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL;
    }

    @Override
    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, HidingFab child, View target) {
        child.showModified();
        super.onStopNestedScroll(coordinatorLayout, child, target);
    }
}
