package dev.gabriel.coman.example.second

import android.net.Uri

fun LastSeenDTO.toLastSeenViewState() = LastSeenViewStateImpl(lastSeen = this.lastSeen)

fun ContactDTO.toContactViewState(): ContactViewState = ContactViewStateImpl(
    nameText = this.name,
    phoneNumberText = this.phoneNumber,
    iconUri = Uri.parse(this.icon),
    isFollowButtonSelected = this.isFollowed,
    followButtonTitle = if (this.isFollowed) "UNFOLLOW" else "FOLLOW")

fun ContactDTO.toCallViewState(): CallViewState = CallViewStateImpl(phone = this.phoneNumber, name = this.name)