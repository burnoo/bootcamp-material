package com.droidsonroids.materialmusicfacts.screens.screen_album_details;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.droidsonroids.materialmusicfacts.App;
import com.droidsonroids.materialmusicfacts.R;
import com.droidsonroids.materialmusicfacts.SuperActivity;

import butterknife.BindView;

public class AlbumDetailsActivity extends SuperActivity{

    @BindView(R.id.textView_biography)
    TextView mTextViewBiography;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_album_details;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTextViewBiography.setText(App.getMadonnaProvider().provideMadonnaBiography());
    }
}
