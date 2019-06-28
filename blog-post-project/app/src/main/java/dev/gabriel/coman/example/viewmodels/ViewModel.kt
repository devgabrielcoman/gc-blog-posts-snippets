package dev.gabriel.coman.example.viewmodels

import dev.gabriel.coman.example.adaptors.MainScreenViewStateImp
import dev.gabriel.coman.example.adaptors.mapDTO
import dev.gabriel.coman.example.data.Api
import dev.gabriel.coman.example.data.ContactDTO
import dev.gabriel.coman.example.data.LastSeenDTO
import dev.gabriel.coman.example.state.MainScreenViewState

typealias ViewModelUpdate = (MainScreenViewState) -> Unit

class ViewModel(private val api: Api) {

    private var contact: ContactDTO = ContactDTO.default
        set(value) {
            field = value
            update(contact, lastSeen)
        }

    private var lastSeen: LastSeenDTO = LastSeenDTO.default
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

    private fun update(contact: ContactDTO, lastSeen: LastSeenDTO) {
        update?.invoke(
            MainScreenViewStateImp(
                mapDTO(dto = contact),
                mapDTO(dto = lastSeen)
            )
        )
    }
}