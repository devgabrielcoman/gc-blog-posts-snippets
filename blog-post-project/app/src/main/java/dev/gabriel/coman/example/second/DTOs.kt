package dev.gabriel.coman.example.second

interface DTO

data class ContactDTO(
    val id: String,
    val name: String,
    val icon: String,
    val phoneNumber: String,
    val isFollowed: Boolean
): DTO {
    companion object {
        val default = ContactDTO(id = "", name = "", icon = "", phoneNumber = "", isFollowed = false)
    }
}

data class LastSeenDTO (val id: String, val lastSeen: String): DTO {
    companion object {
        val default = LastSeenDTO(id = "", lastSeen = "")
    }
}
