package com.example.administrator.criminalintent.activity;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.administrator.criminalintent.R;
import com.example.administrator.criminalintent.fragment.CrimeFragment;
import com.example.administrator.criminalintent.fragment.CrimeListFragment;
import com.example.administrator.criminalintent.model.Crime;

/**
 * Created by Administrator on 2016/3/8.
 */
public class CrimeListActivity extends SingleFragmentActivity implements CrimeListFragment.Callbacks, CrimeFragment.Callbacks {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }

    @Override
    protected int getLayoutResId() {
        //本意是通过引用，实现响应式布局，但行不通，只好在不同文件夹放置布局
        return R.layout.activity_masterDetail;
    }

    @Override
    public void onCrimeSelected(Crime crime) {
        if (findViewById(R.id.detailFragmentContainer) == null) {
            Intent intent = new Intent(this, CrimePagerActivity.class);
            intent.putExtra(CrimeFragment.EXTRA_CRIME_ID, crime.getId());
            startActivity(intent);
        } else {
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            Fragment oldDetail = manager.findFragmentById(R.id.detailFragmentContainer);
            Fragment newDetail = CrimeFragment.newInstance(crime.getId());
            if (oldDetail != null)
                transaction.remove(oldDetail);
            transaction.add(R.id.detailFragmentContainer, newDetail);
            transaction.commit();
        }
    }

    @Override
    public void onCrimeUpdated(Crime crime) {
        FragmentManager manager = getSupportFragmentManager();
        CrimeListFragment fragment = (CrimeListFragment) manager.findFragmentById(R.id.fragmentContainer);
        fragment.updateUI();
    }
}
