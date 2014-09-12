package com.mobile.yanxu.smarket;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.support.v13.app.FragmentPagerAdapter;

import java.util.Locale;

/**
 * Created by yanxu on 12/09/2014.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private Context mContext = null;

    public SectionsPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
//            return PlaceholderFragment.newInstance(position + 1);
//            HomeFragment hf = new HomeFragment();
        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new DiscoverFragment();
            case 2:
                return new CartFragment();
            case 3:
                return new MeFragment();
        }
        return null;

    }

    @Override
    public int getCount() {
        // Show 4 total pages.
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Locale l = Locale.getDefault();
        switch (position) {
            case 0:
                return mContext.getString(R.string.title_section1).toUpperCase(l);
            case 1:
                return mContext.getString(R.string.title_section2).toUpperCase(l);
            case 2:
                return mContext.getString(R.string.title_section3).toUpperCase(l);
            case 3:
                return mContext.getString(R.string.title_section4).toUpperCase(l);
        }
        return null;
    }
}