package com.example.fragmentcontact.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentcontact.R
import com.example.fragmentcontact.adapter.ContactListAdapter
import com.example.fragmentcontact.listener.OnSendListener
import com.example.fragmentcontact.model.Contact

class ContactListFragment : Fragment() {

    private var listener : OnSendListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.contact_list_fragment, container, false)

        initViews(view)

        return view
    }

    private fun initViews(view : View){
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        var adapter = ContactListAdapter(this,prepareContactList())
        recyclerView.adapter = adapter
    }

    fun getData(contact: Contact){
        listener!!.onSend(contact)
    }

    private fun prepareContactList() : ArrayList<Contact>{
        val contactList = ArrayList<Contact>()

        for(i in 1..15){
            contactList.add(Contact(R.drawable.img_profile, "Android Developer", "+9989 97 999 ${i%10}${i%10} ${i%10}${i%10}"))
        }
        return contactList
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is OnSendListener){
            listener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

}