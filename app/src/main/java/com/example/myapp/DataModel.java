package com.example.myapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class DataModel {

    @PrimaryKey
    public long id;

    public String name;

    public int salary;
}
