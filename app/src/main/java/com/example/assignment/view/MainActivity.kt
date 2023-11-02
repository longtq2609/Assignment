package com.example.assignment.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment.R
import com.example.assignment.adapter.ContactAdapter
import com.example.assignment.entity.Contact
import com.example.assignment.viewmodel.ContactViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    private var viewModel: ContactViewModel? = null
    private val adapter = ContactAdapter(this)
    private var btnAddContact: FloatingActionButton? = null
    private var rvcContact: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnAddContact = findViewById(R.id.btnAddContact)
        rvcContact = findViewById(R.id.rcvContact)
        initView()
        initObservable()
        initListener()
    }

    private fun initView() {
        rvcContact?.layoutManager = LinearLayoutManager(this)
        rvcContact?.adapter = adapter
    }

    private fun initObservable() {
        viewModel?.getAllContact()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe({ contacts ->
                adapter.setContact(contacts)
            }, { error ->
                Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()
            })
    }

    private fun initListener() {
        btnAddContact?.setOnClickListener {
            val name = "Long"
            val phone = "0389127389"
            val contact = Contact(0, name, phone)
            viewModel?.addContact(contact)
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe({ id ->
                    Toast.makeText(this, "Success: $id", Toast.LENGTH_SHORT).show()
                    adapter.notifyDataSetChanged()
                }, { error ->
                    Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()
                })
        }

    }
}