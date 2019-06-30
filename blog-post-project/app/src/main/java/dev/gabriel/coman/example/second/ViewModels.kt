package dev.gabriel.coman.example.second

typealias ContactUpdateCallback = (ContactViewState) -> Unit
typealias LastSeenUpdateCallback = (LastSeenViewState) -> Unit
typealias CallUpdateCallback = (CallViewState) -> Unit

class ContactViewModel(private val repo: ContactRepository) {

    var callback: ContactUpdateCallback? = null

    private var viewState: ContactViewState? = null
        set(value) {
            field = value
            value?.let {
                callback?.invoke(value)
            }
        }

    fun getContact(id: String) {
        viewState = repo.getContact(id = id).toContactViewState()
    }

    fun addToFavourites(id: String) {
        viewState = repo.switchFollow(id = id).toContactViewState()
    }
}

class LastSeenViewModel(private val repo: LastSeenRepository) {

    val callback: LastSeenUpdateCallback? = null

    private var viewState: LastSeenViewState? = null
        set(value) {
            field = value
            value?.let {
                callback?.invoke(value)
            }
        }

    fun getLastSeen(id: String) {
        viewState = repo.getLastSeen(id = id).toLastSeenViewState()
    }
}

class CallViewModel(private val repo: ContactRepository) {

    var callback: CallUpdateCallback? = null

    private var viewState: CallViewState? = null
        set(value) {
            field = value
            value?.let {
                callback?.invoke(value)
            }
        }

    fun getCalledContact(id: String) {
        viewState = repo.getContact(id = id).toCallViewState()
    }
}