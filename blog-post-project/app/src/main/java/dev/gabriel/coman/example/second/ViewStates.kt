package dev.gabriel.coman.example.second

import android.net.Uri

interface ContactViewState {
    val nameText: String
    val phoneNumberText: String
    val iconUri: Uri?
    val isFollowButtonSelected: Boolean
    val followButtonTitle: String
}

interface LastSeenViewState {
    val lastSeenText: String
}

interface CallViewState {
    val callingText: String
}