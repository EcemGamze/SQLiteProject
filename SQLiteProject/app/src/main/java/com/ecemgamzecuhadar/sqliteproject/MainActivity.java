package com.ecemgamzecuhadar.sqliteproject;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.SortedMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            SQLiteDatabase database = this.openOrCreateDatabase("Musicians", MODE_PRIVATE, null);
            database.execSQL("CREATE TABLE IF NOT EXISTS musicians(id INTEGER PRIMARY KEY, name VARCHAR, age INT)");


            //database.execSQL("INSERT INTO musicians (name, age) VALUES ('James',50 )");
            //database.execSQL("INSERT INTO musicians (name, age) VALUES ('Lars',60 )");
            database.execSQL("INSERT INTO musiciacns (name, age) VALUES ('Kirk', 55)");

            Cursor cursor = database.rawQuery("SELECT * FROM musicians", null );

            int nameIx = cursor.getColumnIndex("name");
            int ageIx = cursor.getColumnIndex("age");
            int idIX = cursor.getColumnIndex("id");

            while (cursor.moveToNext()) {
                System.out.println("Name: " + cursor.getString(nameIx));
                System.out.println("Age: " + cursor.getInt(ageIx));
                System.out.println("Id: " + cursor.getInt(idIX));
            }
            cursor.close();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}