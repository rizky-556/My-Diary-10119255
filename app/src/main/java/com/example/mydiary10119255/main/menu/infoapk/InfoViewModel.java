package com.example.mydiary10119255.main.menu.infoapk;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;
        /*
        NIM : 10119255
        Nama : Rizki Lail Rahman
        Kelas : IF-7
        */

public class InfoViewModel extends FragmentStatePagerAdapter {

    private List<Fragment> fragmentList;

    public InfoViewModel(FragmentManager fm, List<Fragment> fragmentList ) {
        super(fm);

        this.fragmentList = fragmentList;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}