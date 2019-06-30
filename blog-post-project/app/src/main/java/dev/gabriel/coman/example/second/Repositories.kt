package dev.gabriel.coman.example.second

class ContactRepository(private val api: NewApi) {

    private var contact = ContactDTO.default

    fun getContact(id: String): ContactDTO {
        return api.getContact(id = id).also { contact = it }
    }

    fun switchFollow(id: String): ContactDTO {
        contact = contact.copy(isFollowed = !contact.isFollowed)
        return contact
    }
}

class LastSeenRepository(private val api: NewApi) {

    private var lastSeen = LastSeenDTO.default

    fun getLastSeen(id: String): LastSeenDTO {
        return api.getLastSeen(id = id).also { lastSeen = it }
    }
}