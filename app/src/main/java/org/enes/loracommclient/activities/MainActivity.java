package org.enes.loracommclient.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentOnAttachListener;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import org.enes.loracommclient.R;
import org.enes.loracommclient.fragments.MessageFragment;
import org.enes.loracommclient.fragments.MyFragment;
import org.enes.loracommclient.fragments.NodeStatusFragment;
import org.enes.loracommclient.fragments.SettingsFragment;

import java.util.List;

public class MainActivity extends MyActivity implements FragmentOnAttachListener,
        NavigationBarView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initFragment();
    }

    private RelativeLayout rl_main;

    private BottomNavigationView bottom_navigation;

    private void initView() {
        setContentView(R.layout.activity_main);
        rl_main = findViewById(R.id.rl_main);
        bottom_navigation = findViewById(R.id.bottom_navigation);
        bottom_navigation.setOnItemSelectedListener(this);



        BottomNavigationMenuView v = (BottomNavigationMenuView) bottom_navigation.getChildAt(0);
//        Log.e("test", v.toString());

//        bottom_navigation.setN

//        bottom_navigation.getOrCreateBadge(R.id.menu_main).setNumber(64);


    }

    private MessageFragment messageFragment;

    private NodeStatusFragment nodeStatusFragment;

    private SettingsFragment settingsFragment;

    private void initFragment() {
        messageFragment = new MessageFragment();
        nodeStatusFragment = new NodeStatusFragment();
        settingsFragment = new SettingsFragment();
        //
        FragmentTransaction fragmentTransaction = getMyFragmentManager().beginTransaction();
        fragmentTransaction.add(rl_main.getId(), messageFragment, messageFragment.getFragmentTag());
        fragmentTransaction.commit();
    }

    private FragmentManager fragmentManager;

    public FragmentManager getMyFragmentManager() {
        if(fragmentManager == null) {
            fragmentManager = getSupportFragmentManager();
            fragmentManager.addFragmentOnAttachListener(this);
        }
        return fragmentManager;
    }

    private void changeFragment(MyFragment myFragment) {
        FragmentManager fragmentManager = getMyFragmentManager();
        List<Fragment> fragmentList = fragmentManager.getFragments();
        //
        Fragment firstFragment = null;
        if (fragmentList.size() > 0) {
            firstFragment = fragmentList.get(0);
        }
        if(firstFragment != myFragment) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.
                    replace(rl_main.getId(), myFragment, myFragment.getFragmentTag());
            fragmentTransaction.commit();
        }



        // for test
        for(int i = 0 ; i < fragmentList.size() ; i ++ ) {
            Fragment fragment = fragmentList.get(i);
            Log.e("test", fragment.toString());
        }










    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
//        Log.e("test", "onNavigationItemSelected: " + itemId);
        switch (itemId) {
            case R.id.menu_main:
                changeFragment(messageFragment);
                break;
            case R.id.menu_node_status:
                changeFragment(nodeStatusFragment);
                break;
            case R.id.menu_settings:
                changeFragment(settingsFragment);
                break;
        }
        return true;
    }

    @Override
    public void onAttachFragment(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        Log.e("test", "onAttachFragment");
    }
}