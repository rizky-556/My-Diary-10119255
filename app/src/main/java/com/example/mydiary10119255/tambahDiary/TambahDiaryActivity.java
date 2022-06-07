package com.example.mydiary10119255.tambahDiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mydiary10119255.R;
import com.example.mydiary10119255.database.DbSQLite;
import com.example.mydiary10119255.main.MainActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

        /*
        NIM : 10119255
        Nama : Rizki Lail Rahman
        Kelas : IF-7
         */

public class TambahDiaryActivity extends AppCompatActivity {


    private EditText judulEditText, kategoriEditText, isiEditText;
    private Date date;
    private SimpleDateFormat dateFormat, monthFormat, yearFormat;
    private Button submitButton;
    private DbSQLite helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_diary); /*Memanggil tampilan form diary untuk disi*/


        date = Calendar.getInstance().getTime();
        dateFormat = new SimpleDateFormat("dd", Locale.getDefault());
        monthFormat = new SimpleDateFormat("MMMM", Locale.getDefault());
        yearFormat = new SimpleDateFormat("yyyy", Locale.getDefault());


        submitButton = findViewById(R.id.submitButton);
        judulEditText = findViewById(R.id.judul);
        kategoriEditText = findViewById(R.id.kategori);
        isiEditText = findViewById(R.id.isi);


        helper = new DbSQLite(this);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String judul = judulEditText.getText().toString();
                String kategori = kategoriEditText.getText().toString();
                String isi = isiEditText.getText().toString();
                String formattedDate = dateFormat.format(date);
                String formattedMonth = monthFormat.format(date);
                String formattedYear = yearFormat.format(date);

                if (TextUtils.isEmpty(judul)) {
                    judulEditText.setError("Data tidak boleh kosong");
                    judulEditText.requestFocus();
                } else if (TextUtils.isEmpty(kategori)) {
                    kategoriEditText.setError("Data tidak boleh kosong");
                    kategoriEditText.requestFocus();
                } else if (TextUtils.isEmpty(isi)) {
                    isiEditText.setError("Data tidak boleh kosong");
                    isiEditText.requestFocus();
                } else {
                    boolean isSuccess = helper.insertData(judul, kategori, isi, formattedDate, formattedMonth, formattedYear);

                    if (isSuccess) {
                        Toast.makeText(TambahDiaryActivity.this, "Catatan berhasil ditambahkan", Toast.LENGTH_SHORT).show();

                        startActivity(new Intent(TambahDiaryActivity.this, MainActivity.class));
                        finish();
                    } else {
                        Toast.makeText(TambahDiaryActivity.this, "Catatan gagal ditambahkan", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}