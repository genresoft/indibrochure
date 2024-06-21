package com.poster.postmaker.database;

import android.annotation.SuppressLint;


import com.poster.postmaker.activity.HomeActivity;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

@SuppressLint("SdCardPath")
public class ImportDatabase {

    public static void copyDataBase() {

        try {

            OutputStream databaseOutputStream = new FileOutputStream("/data/data/com.poster.postmaker/databases/Suitdb.sql");
            InputStream databaseInputStream;

            byte[] buffer = new byte[1024];
            databaseInputStream = HomeActivity.databaseInputStream1;

            while ((databaseInputStream.read(buffer)) > 0) {
                databaseOutputStream.write(buffer);
            }
            databaseInputStream.close();
            databaseOutputStream.flush();
            databaseOutputStream.close();

        } catch (Exception e) {
        }
    }
}
