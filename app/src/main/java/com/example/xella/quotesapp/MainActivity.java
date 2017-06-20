package com.example.xella.quotesapp;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import static com.example.xella.quotesapp.R.id.pager;

public class MainActivity extends FragmentActivity {

    /**
     * The number of pages (wizard steps).
     */
    static final int PAGE_COUNT = 10;

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    /**
     * A simple pager adapter that represents 10 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch(position) {
                case 0:
                    return PageFragment.newInstance(position, getString(R.string.quote_one), getString(R.string.author_one));
                case 1:
                    return PageFragment.newInstance(position, getString(R.string.quote_two), getString(R.string.author_two));
                case 2:
                    return PageFragment.newInstance(position, getString(R.string.quote_three), getString(R.string.author_three));
                case 3:
                    return PageFragment.newInstance(position, getString(R.string.quote_four), getString(R.string.author_four));
                case 4:
                    return PageFragment.newInstance(position, getString(R.string.quote_five), getString(R.string.author_five));
                case 5:
                    return PageFragment.newInstance(position, getString(R.string.quote_six), getString(R.string.author_six));
                case 6:
                    return PageFragment.newInstance(position, getString(R.string.quote_seven), getString(R.string.author_seven));
                case 7:
                    return PageFragment.newInstance(position, getString(R.string.quote_eight), getString(R.string.author_eight));
                case 8:
                    return PageFragment.newInstance(position, getString(R.string.quote_nine), getString(R.string.author_nine));
                case 9:
                    return PageFragment.newInstance(position, getString(R.string.quote_ten), getString(R.string.author_ten));
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }
    }
}
