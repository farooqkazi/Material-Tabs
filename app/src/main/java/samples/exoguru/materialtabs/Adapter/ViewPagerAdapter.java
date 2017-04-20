package samples.exoguru.materialtabs.Adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import samples.exoguru.materialtabs.Tabs.Tab1;
import samples.exoguru.materialtabs.Tabs.Tab2;
import samples.exoguru.materialtabs.Tabs.Tab3;

/**
 * Created by Edwin on 15/02/2015.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    CharSequence Titles[]; /** This will store the Titles of the Tabs which are going to be passed when ViewPagerAdapter is created */
    int NumbOfTabs; /** Store the number of tabs, this will also be passed when the ViewPagerAdapter is created */


    /** Build a Constructor and assign the passed values to appropriate values in the class */
    public ViewPagerAdapter(FragmentManager fm,CharSequence mTitles[], int mNumbOfTabsumb) {
        super(fm);

        this.Titles = mTitles;
        this.NumbOfTabs = mNumbOfTabsumb;

    }

    /** This method returns the fragment for the every position in the View Pager*/
    @Override
    public Fragment getItem(int position) {

        /*if(position == 0) // if the position is 0 we are returning the First tab
        {
            Tab1 tab1 = new Tab1();
            return tab1;
        }
        else             // As we are having 2 tabs if the position is now 0 it must be 1 so we are returning second tab
        {
            Tab2 tab2 = new Tab2();
            return tab2;
        }*/


        switch (position){

            case 0:// Fragment # 0 - This will show FirstFragment
                Tab1 tab1 = new Tab1();
                return tab1;
            case 1: // Fragment # 0 - This will show FirstFragment different title
                Tab2 tab2 = new Tab2();
                return tab2;
            case 2: // Fragment # 1 - This will show SecondFragment
                Tab3 tab3 = new Tab3();
                return tab3;
            default:
                return null;

        }

    }

    /** This method return the titles for the Tabs in the Tab Strip */

    @Override
    public CharSequence getPageTitle(int position) {
        return Titles[position];
    }

    // This method return the Number of tabs for the tabs Strip

    @Override
    public int getCount() {
        return NumbOfTabs;
    }
}