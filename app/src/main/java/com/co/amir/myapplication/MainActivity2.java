package com.co.amir.myapplication;

import android.arch.lifecycle.ViewModelProviders;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.co.amir.myapplication.ui.mainactivity2.Fragment_dashboard;
import com.co.amir.myapplication.ui.mainactivity2.MainActivity2FragmentHome;
import com.co.amir.myapplication.ui.mainactivity2.MainActivity2ViewModel;

public class MainActivity2 extends AppCompatActivity implements Fragment_dashboard.OnFragmentInteractionListener {
    Fragment frag_home= MainActivity2FragmentHome.newInstance();
    Fragment frag_dash = new Fragment_dashboard();
    FragmentManager fm=getSupportFragmentManager();
    Fragment active=frag_home;

    MainActivity2ViewModel mViewModel;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fm.beginTransaction().hide(active).show(frag_home).commit();
                    active=frag_home;
                    return true;
                case R.id.navigation_dashboard:
                    fm.beginTransaction().hide(active).show(frag_dash).commit();
                    active=frag_dash;
                    return true;
                case R.id.navigation_notifications:

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity2_activity);

        BottomNavigationView navView = findViewById(R.id.nav_view_m2);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        fm.beginTransaction().add(R.id.container,frag_dash,"Dashboard").hide(frag_dash).commit();
        fm.beginTransaction().add(R.id.container, frag_home,"Home").commit();

        mViewModel = ViewModelProviders.of(this).get(MainActivity2ViewModel.class);
    }

    @Override
    public void onFragmentInteraction(Uri uri){
        //you can leave it empty
    }
}
