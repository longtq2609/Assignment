package com.example.assignment.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.assignment.entity.Contact
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Single

interface ContactDAO {

    @Insert
    fun insertContact(contact: Contact): Single<Int>

    @Update
    fun updateContact(contact: Contact): Completable

    @Delete
    fun deleteContact(contact: Contact): Completable

    @Query("SELECT * FROM contacts WHERE id = :contactId")
    fun getContactById(contactId: Int): Maybe<Contact>

    @Query("SELECT * FROM contacts ")
    fun getAllContact(): Flowable<List<Contact>>
}