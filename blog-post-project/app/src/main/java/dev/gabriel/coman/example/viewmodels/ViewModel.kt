package dev.gabriel.coman.example.viewmodels

import dev.gabriel.coman.example.adaptors.MainScreenViewStateImp
import dev.gabriel.coman.example.data.Api
import dev.gabriel.coman.example.data.Contact
import dev.gabriel.coman.example.data.LastSeen
import dev.gabriel.coman.example.state.MainScreenViewState

typealias ViewModelUpdate = (MainScreenViewState) -> Unit

class ViewModel(private val api: Api) {

    private var contact: Contact = Contact.default
        set(value) {
            field = value
            update(contact, lastSeen)
        }

    private var lastSeen: LastSeen = LastSeen.default
        set(value) {
            field = value
            update(contact, lastSeen)
        }

    var update: ViewModelUpdate? = null

    fun getContact() {
        this.contact = api.getContact()
    }

    fun addToFavourites() {
        contact = contact.copy(isFollowed = !contact.isFollowed)
    }

    fun getLastSeen() {
        this.lastSeen = api.getLastSeen()
    }

    private fun update(contact: Contact, lastSeen: LastSeen) = update?.invoke(MainScreenViewStateImp(contact, lastSeen)) ?: Unit
}