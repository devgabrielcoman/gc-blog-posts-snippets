package dev.gabriel.coman.example.second

import android.content.Context

//typealias LoadCtInteractor = (String) -> Unit
//
//fun LoadCtInteractorImpl(viewModel: ContactViewModel): LoadCtInteractor {
//    return { id ->
//        viewModel.getContact(id = id)
//    }
//}

interface LoadContactInteractor {
    fun load(id: String)
}

interface AddContactToFavouritesInteractor {
    fun addToContacts(id: String)
}

interface CallContactInteractor {
    fun call(id: String, context: Context)
}

interface LoadLastSeenInteractor {
    fun load(id: String)
}

class LoadFullContactInteractor(private val viewModel: ContactViewModel): LoadContactInteractor {
    override fun load(id: String) = viewModel.getContact(id = id)
}

class LoadCalledContactInteractor(private val viewModel: CallViewModel): LoadContactInteractor {
    override fun load(id: String) = viewModel.getCalledContact(id = id)
}

class AddContactToFavouritesInteractorImpl(private val viewModel: ContactViewModel): AddContactToFavouritesInteractor {
    override fun addToContacts(id: String) = viewModel.addToFavourites(id = id)
}

class LoadLastSeenInteractorImpl(private val viewModel: LastSeenViewModel): LoadLastSeenInteractor {
    override fun load(id: String) = viewModel.getLastSeen(id = id)
}

class CallContactInteractorImpl(private val navigator: AppNavigator): CallContactInteractor {
    override fun call(id: String, context: Context) = navigator.call(context = context, id = id)
}