package com.example.mydiary10119255.main.menu.infoapk;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mydiary10119255.R;

        /*
       NIM : 10119255
       Nama : Rizki Lail Rahman
       Kelas : IF-7
        */
public class InfoFragment1 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_info1, container, false);

        return root;
    }
}