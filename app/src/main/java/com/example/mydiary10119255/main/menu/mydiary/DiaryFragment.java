package com.example.mydiary10119255.main.menu.mydiary;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.mydiary10119255.R;
import com.example.mydiary10119255.tambahDiary.TambahDiaryActivity;
import com.example.mydiary10119255.database.DbSQLite;
import com.example.mydiary10119255.model.MyDiary;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
        /*
        NIM : 10119255
        Nama : Rizki Lail Rahman
        Kelas : IF-7
         */

public class DiaryFragment extends Fragment {

    /* Deklarasi variable */
    private FloatingActionButton addButton;
    private ListView listView;
    private ListViewAdapter listViewAdapter;
    private ArrayList<MyDiary> listTask = new ArrayList<>();
    private DbSQLite helper;

    @Nullable
    @Override
    /*Fungsi membuat view dan menampilkan data*/
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_diary, container, false);

        addButton = root.findViewById(R.id.addButton);
        listView = root.findViewById(R.id.listView);

        helper = new DbSQLite(this.getActivity());

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), TambahDiaryActivity.class));
            }
        });

        showData();

        return root;
    }

    /*Fungsi menampilkan data*/
    public void showData() {
        listTask.clear();
        Cursor res = helper.getAllData();
        while (res.moveToNext()) {
            String id = res.getString(0);
            String judul = res.getString(1);
            String kategori = res.getString(2);
            String isi = res.getString(3);
            String date = res.getString(4);
            String month = res.getString(5);
            String year = res.getString(6);

            listTask.add(new MyDiary(id, judul, kategori, isi, date, month, year));
        }

        listViewAdapter = new ListViewAdapter(listTask, getActivity());
        listView.setAdapter(listViewAdapter);
        listViewAdapter.notifyDataSetChanged();
    }

}
