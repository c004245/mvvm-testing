package com.example.mvvmtesting.view

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmtesting.R
import com.example.mvvmtesting.model.Contact
import com.example.mvvmtesting.viewmodel.ContactViewModel
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity: AppCompatActivity() {

    private lateinit var contactViewModel: ContactViewModel
    private var id: Long? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        contactViewModel = ViewModelProviders.of(this).get(ContactViewModel::class.java)

        if (intent != null && intent.hasExtra(EXTRA_CONTACT_NAME) && intent.hasExtra(EXTRA_CONTACT_NUMBER)
            && intent.hasExtra(EXTRA_CONTACT_ID)) {

            et_add_name.setText(intent.getStringExtra(EXTRA_CONTACT_NAME))
            et_add_number.setText(intent.getStringExtra(EXTRA_CONTACT_NUMBER))
            id = intent.getLongExtra(EXTRA_CONTACT_ID, -1)
        }

        btn_add.setOnClickListener {
            val name = et_add_name.text.toString().trim()
            val number = et_add_number.text.toString()

            if (name.isEmpty() || number.isEmpty()) {
                Toast.makeText(this, "Please enter name and number.", Toast.LENGTH_SHORT).show()
            } else {
                val initial = name[0].toUpperCase()
                val contact = Contact(id, name, number, initial)
                contactViewModel.insert(contact)
                finish()
            }
        }

    }

    companion object {
        const val EXTRA_CONTACT_NAME = "EXTRA_CONTACT_NAME"
        const val EXTRA_CONTACT_NUMBER = "EXTRA_CONTACT_NUMBER"
        const val EXTRA_CONTACT_ID = "EXTRA_CONTACT_ID"
    }
}