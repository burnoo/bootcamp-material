package com.droidsonroids.materialmusicfacts.screens.screen_main;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;

import com.droidsonroids.materialmusicfacts.App;
import com.droidsonroids.materialmusicfacts.R;
import com.droidsonroids.materialmusicfacts.SuperActivity;
import com.droidsonroids.materialmusicfacts.common.Constants;
import com.droidsonroids.materialmusicfacts.screens.screen_album_details.AlbumDetailsActivity;
import com.droidsonroids.materialmusicfacts.views.SpacesItemDecoration;
import com.squareup.picasso.Picasso;

import butterknife.BindView;


public class MainActivity extends SuperActivity implements AppBarLayout.OnOffsetChangedListener, OnAlbumClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.textView_name)
    TextView mTextViewName;
    @BindView(R.id.textView_surname)
    TextView mTextViewSurname;
    @BindView(R.id.textView_place)
    TextView mTextViewPlace;
    @BindView(R.id.textView_nickname)
    TextView mTextViewNickname;
    @BindView(R.id.appBarLayout)
    AppBarLayout mAppBarLayout;
    @BindView(R.id.detailsBox)
    View mDetailsBox;
    @BindView(R.id.fab)
    FloatingActionButton mFab;
    @BindView(R.id.recyclerView_albums)
    RecyclerView mRecyclerView;

    private boolean showing = true;
    private MainRecyclerViewAdapter mAdapter;

    public static void startActivity(final Activity activity) {
        activity.startActivity(new Intent(activity, MainActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUpView();
    }

    private void setUpView() {
        mTextViewName.setText(App.getMadonnaProvider().provideName());
        mTextViewSurname.setText(App.getMadonnaProvider().provideSurname());
        mTextViewPlace.setText(App.getMadonnaProvider().providePlace());
        mTextViewNickname.setText(App.getMadonnaProvider().provideNickname());
        mAppBarLayout.addOnOffsetChangedListener(this);
        initRecyclerView();
    }

    private void initRecyclerView() {
        mAdapter = new MainRecyclerViewAdapter(Picasso.with(this));
        mAdapter.setOnAlbumClickListener(this);

        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        mRecyclerView.addItemDecoration(new SpacesItemDecoration(4, 5, false));
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setAlbumCovers(App.getMadonnaProvider().provideAlbumCovers());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        double percentage = -1.0 * verticalOffset / appBarLayout.getTotalScrollRange();
        if (showing && percentage >= Constants.CHANGE_PERCENTAGE)
            hideDetails();
        else if (!showing && percentage < Constants.CHANGE_PERCENTAGE)
            showDetails();
    }

    private void showDetails() {
        showing = true;
        AlphaAnimation showAnimation = new AlphaAnimation(0, 1);
        showAnimation.setDuration(Constants.HIDE_SHOW_DETAILS_SPEED);
        mDetailsBox.startAnimation(showAnimation);
        mDetailsBox.setVisibility(View.VISIBLE);
    }

    private void hideDetails() {
        showing = false;
        AlphaAnimation hideAnimation = new AlphaAnimation(1, 0);
        hideAnimation.setDuration(Constants.HIDE_SHOW_DETAILS_SPEED);
        mDetailsBox.startAnimation(hideAnimation);
        mDetailsBox.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onAlbumClickedListener(View imageViewAlbum, int position) {
        ActivityOptions optionsCompact = ActivityOptions.makeSceneTransitionAnimation(this, new Pair<>(imageViewAlbum, "transitionAlbum"));
        Intent intent = new Intent(this, AlbumDetailsActivity.class);
        intent.putExtra(AlbumDetailsActivity.EXTRA_ALBUM_COVER, position);
        startActivity(intent, optionsCompact.toBundle());
    }
}
