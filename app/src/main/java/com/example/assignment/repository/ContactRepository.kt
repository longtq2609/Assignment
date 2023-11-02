package com.example.assignment.repository

import com.example.assignment.dao.ContactDAO
import com.example.assignment.entity.Contact
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Single

class ContactRepository(private val contactDAO: ContactDAO) {
    fun addContact(contact: Contact): Single<Int> {
        return contactDAO.insertContact(contact)
    }

    fun updateContact(contact: Contact): Completable {
        return contactDAO.updateContact(contact)
    }

    fun deleteContact(contact: Contact): Completable {
        return contactDAO.deleteContact(contact)
    }

    fun getContactById(contactId: Int): Maybe<Contact> {
        return contactDAO.getContactById(contactId)
    }

    fun getAllContact(): Flowable<List<Contact>>{
        return contactDAO.getAllContact()
    }
}