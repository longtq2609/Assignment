package com.example.assignment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment.R
import com.example.assignment.entity.Contact

class ContactAdapter(private var context: Context) :
    RecyclerView.Adapter<ContactAdapter.ViewHolder>() {
    private var contacts: List<Contact> = emptyList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_contact, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactAdapter.ViewHolder, position: Int) {
        val contact = contacts[position]
        holder.bind(contact)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    fun setContact(contacts: List<Contact>) {
        this.contacts = contacts
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(contact: Contact) {
            itemView.findViewById<TextView>(R.id.tvName).text = contact.name
            itemView.findViewById<TextView>(R.id.tvPhone).text = contact.phone
        }
    }
}