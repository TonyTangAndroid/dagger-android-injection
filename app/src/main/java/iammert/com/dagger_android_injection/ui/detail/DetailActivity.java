package iammert.com.dagger_android_injection.ui.detail;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

import javax.inject.Inject;

import iammert.com.dagger_android_injection.R;
import iammert.com.dagger_android_injection.ui.detail.fragment.DetailFragment;
import iammert.com.dagger_android_injection.ui.detail.fragment.v2.NoteDetailFragment;

/**
 * Created by mertsimsek on 25/05/2017.
 */

public class DetailActivity extends BaseActivityWithFragmentInjector implements DetailView {

    @Inject
    DetailPresenter detailPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        detailPresenter.loadDetail();

        if (savedInstanceState == null)
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, getFragment())
                    .commitAllowingStateLoss();
    }

    private Fragment getFragment() {
        return System.currentTimeMillis() % 2 == 0 ? NoteDetailFragment.newInstance() : DetailFragment.newInstance();
    }

    @Override
    public void onDetailLoaded() {
        Log.v("TEST", "Detail is loaded");
    }

}
