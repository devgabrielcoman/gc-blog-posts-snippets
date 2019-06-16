package dev.gabriel.coman.example.data

data class Contact(
    val id: String,
    val name: String,
    val icon: String,
    val phoneNumber: String,
    val isFollowed: Boolean
) {
    companion object {
        val default = Contact(id = "", name = "", icon = "", phoneNumber = "", isFollowed = false)
    }
}