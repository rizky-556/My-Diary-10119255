package com.example.mydiary10119255.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
        /*
        NIM : 10119255
        Nama : Rizki Lail Rahman
        Kelas : IF-7
        */

public class DbSQLite extends SQLiteOpenHelper {

    private static final String DATABASE = "mydiary.db";
    private static final String TABLE = "catatan";
    private static final String COL_1 = "id";
    private static final String COL_2 = "judul";
    private static final String COL_3 = "kategori";
    private static final String COL_4 = "isi";
    private static final String COL_5 = "date";
    private static final String COL_6 = "month";
    private static final String COL_7 = "year";

    public DbSQLite(@Nullable Context context) {
        super(context, DATABASE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE + " (" +
                COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_2 + " TEXT, " +
                COL_3 + " TEXT, " +
                COL_4 + " TEXT, " +
                COL_5 + " TEXT, " +
                COL_6 + " TEXT, " +
                COL_7 + " TEXT" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
    }

    /*Fungsi untuk menambahkan data*/
    public boolean insertData(String judul, String kategori, String isi, String date, String month, String year) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_2, judul);
        values.put(COL_3, kategori);
        values.put(COL_4, isi);
        values.put(COL_5, date);
        values.put(COL_6, month);
        values.put(COL_7, year);

        long results = db.insert(TABLE, null, values);

        return results != -1;
    }

    /*Fungsi untuk mengubah data*/
    public boolean updateData(String id, String judul, String kategori, String isi, String date, String month, String year) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, id);
        contentValues.put(COL_2, judul);
        contentValues.put(COL_3, kategori);
        contentValues.put(COL_4, isi);
        contentValues.put(COL_5, date);
        contentValues.put(COL_6, month);
        contentValues.put(COL_7, year);

        long results = db.update(TABLE, contentValues, COL_1 + " = ? ", new String[]{id});

        return results != -1;
    }

    /*Fungsi untuk mengambil data yang ada*/
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();

        return  db.rawQuery("SELECT * FROM " + TABLE, null);
    }

    /*Fungsi untuk menghapus data yang dipilih*/
    public Integer deteleData(String id){
        SQLiteDatabase db = getWritableDatabase();
        return db.delete(TABLE, COL_1 + " = ? ", new String[]{id});
    }
}
