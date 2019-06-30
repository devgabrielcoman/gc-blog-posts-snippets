package dev.gabriel.coman.example.second

import android.net.Uri

data class ContactViewStateImpl(
    override val nameText: String,
    override val phoneNumberText: String,
    override val iconUri: Uri?,
    override val isFollowButtonSelected: Boolean,
    override val followButtonTitle: String
) : ContactViewState

data class LastSeenViewStateImpl(private val lastSeen: String) : LastSeenViewState {
    override val lastSeenText: String = "Last seen on $lastSeen"
}

data class CallViewStateImpl(private val name: String, private val phone: String): CallViewState {
    override val callingText: String = "Calling $name on $phone"
}