package dev.gabriel.coman.example.adaptors

import android.net.Uri
import dev.gabriel.coman.example.data.Contact
import dev.gabriel.coman.example.data.LastSeen
import dev.gabriel.coman.example.state.ContactViewState
import dev.gabriel.coman.example.state.LastSeenViewState
import dev.gabriel.coman.example.state.MainScreenViewState

data class ContactViewStateImp(private val contact: Contact): ContactViewState {
    override val nameText: String = contact.name
    override val phoneNumberText: String = contact.phoneNumber
    override val iconUri: Uri? = Uri.parse(contact.icon)
    override val isFollowButtonSelected: Boolean = contact.isFollowed
    override val followButtonTitle: String = if (contact.isFollowed) "UNFOLLOW" else "FOLLOW"
}

data class LastSeenViewStateImp(private val lastSeen: LastSeen): LastSeenViewState {
    override val lastSeenText: String = "Last seen on ${lastSeen.lastSeen}"
}

data class MainScreenViewStateImp(
    private val contact: Contact,
    private val lastSeen: LastSeen
): MainScreenViewState {
    override val contactViewState: ContactViewState = ContactViewStateImp(contact = contact)
    override val lastSeenViewState: LastSeenViewState = LastSeenViewStateImp(lastSeen = lastSeen)
}