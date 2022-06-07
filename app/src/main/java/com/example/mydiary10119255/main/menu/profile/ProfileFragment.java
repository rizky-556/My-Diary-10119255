package com.example.mydiary10119255.main.menu.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.mydiary10119255.R;
import com.example.mydiary10119255.databinding.FragmentDiaryBinding;

        /*
       NIM : 10119255
       Nama : Rizki Lail Rahman
       Kelas : IF-7
         */
public class ProfileFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_profile, container, false);

        return root;
    }
}