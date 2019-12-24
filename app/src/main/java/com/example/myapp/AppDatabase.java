package com.example.myapp;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {DataModel.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DataDao employeeDao();
}