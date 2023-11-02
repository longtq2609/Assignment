package com.example.assignment.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.assignment.entity.Contact

@Database(entities = [Contact::class], version = 1)
abstract class ContactDatabase : RoomDatabase() {
    abstract fun contactDao(): ContactDAO
}