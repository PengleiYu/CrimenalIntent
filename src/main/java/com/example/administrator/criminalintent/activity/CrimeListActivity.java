package com.example.administrator.criminalintent.activity;


import android.support.v4.app.Fragment;

import com.example.administrator.criminalintent.fragment.CrimeListFragment;

/**
 * Created by Administrator on 2016/3/8.
 */
public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
