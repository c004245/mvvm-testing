package com.example.mvvmtesting.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.mvvmtesting.model.Contact
import com.example.mvvmtesting.repository.ContactRepository
import com.example.mvvmtesting.view.ContactAdapter

class ContactViewModel(application: Application): AndroidViewModel(application) {

    private val repository = ContactRepository(application)
    private val contacts = repository.getAll()
    private var adapter: ContactAdapter? = null

    fun getAll(): LiveData<List<Contact>> {
        return this.contacts
    }

    fun insert(contact: Contact) {
        repository.insert(contact)
    }

    fun delete(contact: Contact) {
        repository.delete(contact)
    }

    fun getAdapter(): ContactAdapter? {
        Log.d("TEST", "getAdapter")
        return adapter
    }
}