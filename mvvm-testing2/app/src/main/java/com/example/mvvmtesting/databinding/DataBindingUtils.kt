package com.example.mvvmtesting.databinding

import android.content.ClipData
import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmtesting.model.Contact
import com.example.mvvmtesting.view.ContactAdapter

@BindingAdapter("setAdapter")
fun bindRecyclerViewAdapter(recyclerView: RecyclerView, adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>) {
    Log.d("TEST", "bindingRecyclerView --->")
    recyclerView.setHasFixedSize(true)
    recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
    recyclerView.adapter = adapter
}

@BindingAdapter("bind_items")
fun setBindItem(view: RecyclerView, items: List<Contact>?) {
    items?.let {
        val adapter = view.adapter as ContactAdapter
        adapter.setContacts(items)
        adapter.notifyDataSetChanged()
    }
}