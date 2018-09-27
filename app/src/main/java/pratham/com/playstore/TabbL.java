package pratham.com.playstore;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class TabbL extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager pager;
    ViewPagerAdapter adapter;
    List<Fragment> fragmentList = new ArrayList<>();
    List<String> stringList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tabLayout = findViewById(R.id.tab);
        pager = findViewById(R.id.viewPager);
        addFrag();
//        adapter.addFragment(new RecyFragment(),"One");
//        adapter.addFragment(new TwoFragment(),"Two");
//        adapter.addFragment(new RecyFragment(),"Three");
//        adapter.addFragment(new RecyFragment(),"One");
//        adapter.addFragment(new TwoFragment(),"Two");
//        adapter.addFragment(new RecyFragment(),"Three");
//        adapter.addFragment(new RecyFragment(),"One");
//        adapter.addFragment(new TwoFragment(),"Two");
//        adapter.addFragment(new RecyFragment(),"Three");





        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void addFrag(){
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new RecyFragment(),"One");
        adapter.addFragment(new TwoFragment(),"Two");
        adapter.addFragment(new Three(),"Three");
        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        //For some reason, setting minWidth in xml and then accessing it here doesn't work, returns 0
        int minWidth = 80;
        tabLayout.setMinimumWidth(minWidth);

        //If there are less tabs than needed to necessitate scrolling, set to fixed/fill
        if(tabLayout.getTabCount() < dpWidth/minWidth){
            tabLayout.setTabMode(TabLayout.MODE_FIXED);
            tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        }else{
            //Otherwise, set to scrollable
            tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        }
    }


    private class ViewPagerAdapter extends FragmentPagerAdapter {


        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);

        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return stringList.get(position);
        }

        public void addFragment(Fragment twoFragment, String two) {
            fragmentList.add(twoFragment);
            stringList.add(two);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.tab_l,menu);
        return super.onCreateOptionsMenu(menu);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add:
                addFrag();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
