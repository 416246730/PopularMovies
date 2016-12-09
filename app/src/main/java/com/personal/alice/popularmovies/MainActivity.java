package com.personal.alice.popularmovies;

import android.support.v4.app.Fragment;

import com.personal.alice.popularmovies.fragment.MoviesFragment;

public class MainActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new MoviesFragment();
    }
}
