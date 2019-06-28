package dev.gabriel.coman.example.adaptors

import android.net.Uri
import dev.gabriel.coman.example.state.CallViewState
import dev.gabriel.coman.example.state.ContactViewState
import dev.gabriel.coman.example.state.LastSeenViewState
import dev.gabriel.coman.example.state.MainScreenViewState

data class ContactViewStateImp(
    override val nameText: String,
    override val phoneNumberText: String,
    override val iconUri: Uri?,
    override val isFollowButtonSelected: Boolean,
    override val followButtonTitle: String
): ContactViewState

data class LastSeenViewStateImp(private val date: String): LastSeenViewState {
    override val lastSeenText: String = "Last seen on $date"
}

data class MainScreenViewStateImp(
    override val contactViewState: ContactViewState,
    override val lastSeenViewState: LastSeenViewState
): MainScreenViewState

data class CallViewStateImp(val name: String): CallViewState {
    override val callingText: String = "Calling $name"
}