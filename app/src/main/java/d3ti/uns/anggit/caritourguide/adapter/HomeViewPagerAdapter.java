package d3ti.uns.anggit.caritourguide.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import d3ti.uns.anggit.caritourguide.LoginTourguideFragment;
import d3ti.uns.anggit.caritourguide.LoginWisatawanFragment;
import d3ti.uns.anggit.caritourguide.R;


public class HomeViewPagerAdapter extends FragmentStatePagerAdapter {

    private Context context;

    public HomeViewPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new LoginWisatawanFragment();
            case 1:
                return new LoginTourguideFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getResources().getString(R.string.wisatawan);
            case 1:
                return context.getResources().getString(R.string.tour_guide);
        }
        return null;
    }
}