package com.example.mydiary10119255.main.menu.infoapk;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.mydiary10119255.R;
import com.example.mydiary10119255.databinding.FragmentInfoBinding;


import java.util.ArrayList;
import java.util.List;
        /*
        NIM : 10119255
        Nama : Rizki Lail Rahman
        Kelas : IF-7
        */

public class InfoFragment extends Fragment {

    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_info, container, false);

        viewPager = root.findViewById(R.id.pager);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        List<Fragment> list = new ArrayList<>();
        list.add(new InfoFragment1());
        list.add(new InfoFragment2());
        list.add(new InfoFragment3());

        pagerAdapter = new InfoViewModel(requireActivity().getSupportFragmentManager(), list);

        viewPager.setAdapter(pagerAdapter);
    }

}