package dev.gabriel.coman.example.state

import android.net.Uri

interface ContactViewState {
    val nameText: String
    val phoneNumberText: String
    val iconUri: Uri?
    val isFollowButtonSelected: Boolean
    val followButtonTitle: String
}

interface SimpleContactViewState {
    val nameText: String
    val phoneNumberText: String
}

interface LastSeenViewState {
    val lastSeenText: String
}

interface MainScreenViewState {
    val contactViewState: ContactViewState
    val lastSeenViewState: LastSeenViewState
}