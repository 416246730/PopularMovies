package com.personal.alice.popularmovies;

import android.support.v4.app.Fragment;

import com.personal.alice.popularmovies.fragment.DetailFragment;

public class DetailActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new DetailFragment();
    }
}
