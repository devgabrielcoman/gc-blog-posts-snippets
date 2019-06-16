package dev.gabriel.coman.example.examples

import android.net.Uri

data class Contact(
    val id: String,
    val name: String,
    val icon: String,
    val phoneNumber: String,
    val isFollowed: Boolean
)

object Api {
    fun getContact() = Contact(id = "123", name = "John Wayne", phoneNumber = "+00 123 45 67890", isFollowed = true, icon = "https://cms-api-main-popjam.sacdn.net/content-tool/Default/StickerZip/avatar_girl_12.jpg")
}

class ViewModel(private val api: Api) {

    private lateinit var contact: Contact

    var onUpdate:((Contact) -> Unit)? = null

    fun getContact() = onUpdate?.invoke(api.getContact().also { this.contact = it }) ?: Unit

    fun addToFavourites() {
        contact = contact.copy(isFollowed = !contact.isFollowed)
        onUpdate?.invoke(contact)
    }
}

data class ContactViewStateImp(private val contact: Contact): ContactViewState {
    override val nameText: String = contact.name
    override val phoneNumberText: String = contact.phoneNumber
    override val iconUri: Uri? = Uri.parse(contact.icon)
    override val isFollowButtonSelected: Boolean = contact.isFollowed
    override val followButtonTitle: String = if (contact.isFollowed) "UNFOLLOW" else "FOLLOW"
}