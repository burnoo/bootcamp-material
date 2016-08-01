package com.droidsonroids.materialmusicfacts.screens.screen_main;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.droidsonroids.materialmusicfacts.App;
import com.droidsonroids.materialmusicfacts.R;
import com.droidsonroids.materialmusicfacts.SuperActivity;
import com.droidsonroids.materialmusicfacts.data.MadonnaProvider;
import com.droidsonroids.materialmusicfacts.views.SpacesItemDecoration;
import com.squareup.picasso.Picasso;


public class MainActivity extends SuperActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    public static void startActivity(final Activity activity) {
        activity.startActivity(new Intent(activity, MainActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
}
