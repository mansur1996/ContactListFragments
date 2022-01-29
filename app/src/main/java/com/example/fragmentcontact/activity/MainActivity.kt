package com.example.fragmentcontact.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragmentcontact.R
import com.example.fragmentcontact.fragment.ContactListFragment
import com.example.fragmentcontact.fragment.ContactFragment
import com.example.fragmentcontact.listener.OnSendListener
import com.example.fragmentcontact.model.Contact

class MainActivity : AppCompatActivity(), OnSendListener{

    private lateinit var lfragment : ContactListFragment
    private lateinit var cfragment : ContactFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }
    private fun initViews(){
        lfragment = ContactListFragment()
        cfragment = ContactFragment()

        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_contact_list, lfragment)
            .replace(R.id.frame_contact,cfragment)
            .commit()
    }

    override fun onSend(contact: Contact) {
        cfragment.updateDate(contact)
    }
}