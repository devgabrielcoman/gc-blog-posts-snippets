package dev.gabriel.coman.example.data

object Api {
    fun getContact() = Contact(
        id = "123",
        name = "John Wayne",
        phoneNumber = "+00 123 45 67890",
        isFollowed = true,
        icon = "https://cms-api-main-popjam.sacdn.net/content-tool/Default/StickerZip/avatar_girl_12.jpg"
    )

    fun getLastSeen() = LastSeen(lastSeen = "Fed 28 2019")
}