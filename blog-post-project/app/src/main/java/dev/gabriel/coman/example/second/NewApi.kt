package dev.gabriel.coman.example.second

object NewApi {

    fun getContact(id: String) = ContactDTO(
        id = id,
        name = "name-id",
        isFollowed = false,
        phoneNumber = "+44 123 456 7890",
        icon = "https://cms-api-main-popjam.sacdn.net/content-tool/Default/StickerZip/avatar_girl_12.jpg"
    )

    fun getLastSeen(id: String) = LastSeenDTO(id = id, lastSeen = "28 Feb 2018")

}