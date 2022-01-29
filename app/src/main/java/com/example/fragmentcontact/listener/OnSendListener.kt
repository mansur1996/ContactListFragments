package com.example.fragmentcontact.listener

import com.example.fragmentcontact.model.Contact

interface OnSendListener {
    fun onSend(contact: Contact)
}