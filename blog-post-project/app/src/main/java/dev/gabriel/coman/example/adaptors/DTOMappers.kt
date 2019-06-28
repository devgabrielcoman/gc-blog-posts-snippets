package dev.gabriel.coman.example.adaptors

import android.net.Uri
import dev.gabriel.coman.example.data.ContactDTO
import dev.gabriel.coman.example.data.LastSeenDTO
import dev.gabriel.coman.example.state.ContactViewState
import dev.gabriel.coman.example.state.LastSeenViewState

fun mapDTO(dto: ContactDTO): ContactViewState = ContactViewStateImp(
    nameText = dto.name,
    phoneNumberText = dto.phoneNumber,
    iconUri = Uri.parse(dto.icon),
    isFollowButtonSelected = dto.isFollowed,
    followButtonTitle = if (dto.isFollowed) "UNFOLLOW" else "FOLLOW"
)

fun mapDTO(dto: LastSeenDTO): LastSeenViewState =
    LastSeenViewStateImp(date = dto.lastSeen)