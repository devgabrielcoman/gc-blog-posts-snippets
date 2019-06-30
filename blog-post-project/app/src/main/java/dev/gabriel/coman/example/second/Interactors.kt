package dev.gabriel.coman.example.second

import android.content.Context

interface LoadContactInteractor {
    fun load()
}

interface LoadCalledContactInteractor {
    fun load()
}

interface AddContactToFavouritesInteractor {
    fun addToContacts()
}

interface LoadLastSeenInteractor {
    fun load()
}

interface CallContactInteractor {
    fun call()
}

fun LoadFullContactInteractor(viewModel: ContactViewModel): (String) -> LoadContactInteractor {
    return { id ->
        object: LoadContactInteractor {
            override fun load() = viewModel.getContact(id = id)
        }
    }
}

fun LoadCalledContactInteractor(viewModel: CallViewModel): (String) -> LoadCalledContactInteractor {
    return { id ->
        object : LoadCalledContactInteractor {
            override fun load() = viewModel.getCalledContact(id = id)
        }
    }
}

fun AddContactToFavouritesInteractor(viewModel: ContactViewModel): (String) -> AddContactToFavouritesInteractor {
    return { id ->
        object : AddContactToFavouritesInteractor {
            override fun addToContacts() = viewModel.addToFavourites(id = id)
        }
    }
}

fun LoadLastSeenInteractor(viewModel: LastSeenViewModel): (String) -> LoadLastSeenInteractor {
    return { id ->
        object: LoadLastSeenInteractor {
            override fun load() = viewModel.getLastSeen(id = id)
        }
    }
}

fun CallContactInteractor(navigator: AppNavigator): (String, Context) -> CallContactInteractor {
    return { id, context ->
        object: CallContactInteractor {
            override fun call() = navigator.call(context = context, id = id)
        }
    }
}