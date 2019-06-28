package dev.gabriel.coman.example.data

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