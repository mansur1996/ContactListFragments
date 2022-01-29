package com.example.fragmentcontact.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentcontact.R
import com.example.fragmentcontact.fragment.ContactListFragment
import com.example.fragmentcontact.model.Contact

class ContactListAdapter(var lfragment: ContactListFragment, var contacts : ArrayList<Contact>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contact,parent,false)
        return ContactViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val contact = contacts[position]

        if(holder is ContactViewHolder){
            holder.apply {
                profile.setImageResource(contact.profile)
                name.text = contact.name
                number.text = contact.number

                lay_click.setOnClickListener(View.OnClickListener {
                    lfragment.getData(contact)
                })
            }
        }
    }

    override fun getItemCount() = contacts.size

    class ContactViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val profile = view.findViewById<ImageView>(R.id.iv_profile)
        val name = view.findViewById<TextView>(R.id.tv_name)
        val number = view.findViewById<TextView>(R.id.tv_number)
        val lay_click = view.findViewById<LinearLayout>(R.id.ll_item_contact)
    }
}