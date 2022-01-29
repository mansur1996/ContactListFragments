package com.example.fragmentcontact.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.fragmentcontact.R
import com.example.fragmentcontact.model.Contact

class ContactFragment : Fragment() {

    private var name : TextView? = null
    private var number : TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.contact_fragment, container, false)

        name = view.findViewById(R.id.tv_name)
        number = view.findViewById(R.id.tv_number)

        val call = view.findViewById<ImageView>(R.id.iv_call)
        val sms = view.findViewById<ImageView>(R.id.iv_sms)


        call.setOnClickListener(View.OnClickListener {


        })

        sms.setOnClickListener(View.OnClickListener {

        })

        return view
    }

    fun updateDate(contact : Contact){
            name!!.text = contact.name
        number!!.text = contact.number

    }
}