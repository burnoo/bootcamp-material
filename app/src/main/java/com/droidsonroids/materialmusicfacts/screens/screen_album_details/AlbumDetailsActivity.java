package com.droidsonroids.materialmusicfacts.screens.screen_album_details;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.droidsonroids.materialmusicfacts.App;
import com.droidsonroids.materialmusicfacts.R;
import com.droidsonroids.materialmusicfacts.SuperActivity;
import com.squareup.picasso.Picasso;

import butterknife.BindView;

public class AlbumDetailsActivity extends SuperActivity{
    public static final String EXTRA_ALBUM_COVER = "EXTRA_ALBUM_COVER";

    @BindView(R.id.textView_biography)
    TextView mTextViewBiography;
    @BindView(R.id.imageview_album)
    ImageView mImageViewAlbum;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_album_details;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTextViewBiography.setText(App.getMadonnaProvider().provideMadonnaBiography());
        Picasso.with(this)
                .load(App.getMadonnaProvider()
                        .provideAlbumCoverByPosition(getIntent().getIntExtra(EXTRA_ALBUM_COVER, R.drawable.madonna)))
                .into(mImageViewAlbum);
    }
}
