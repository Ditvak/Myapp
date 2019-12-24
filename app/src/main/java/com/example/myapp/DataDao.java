package com.example.myapp;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DataDao {

    @Query("SELECT * FROM DataModel")
    List<DataModel> getAll();

    @Query("SELECT * FROM DataModel WHERE id = :id")
    DataModel getById(long id);

    @Insert
    void insert(DataModel DataModel);

    @Update
    void update(DataModel DataModel);

    @Delete
    void delete(DataModel DataModel);

}