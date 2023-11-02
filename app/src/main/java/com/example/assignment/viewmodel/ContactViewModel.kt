package com.example.assignment.viewmodel

import androidx.lifecycle.ViewModel
import com.example.assignment.entity.Contact
import com.example.assignment.repository.ContactRepository
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Single

class ContactViewModel(private val contactRepository: ContactRepository) : ViewModel() {

    fun addContact(contact: Contact): Single<Int> {
        return contactRepository.addContact(contact)
    }

    fun updateContact(contact: Contact): Completable {
        return contactRepository.updateContact(contact)
    }

    fun deleteContact(contact: Contact): Completable {
        return contactRepository.deleteContact(contact)
    }

    fun getContactById(contactId: Int): Maybe<Contact> {
        return contactRepository.getContactById(contactId)
    }

    fun getAllContact(): Flowable<List<Contact>>{
        return contactRepository.getAllContact()
    }
}