package dev.gabriel.coman.example.second

import dev.gabriel.coman.example.views.CallView
import dev.gabriel.coman.example.views.ContactView
import dev.gabriel.coman.example.views.LastSeenView

fun bind(interactor: LoadContactInteractor): (ContactView) -> Unit {
    return { view ->
        interactor.load()
    }
}

fun bind(interactor: LoadCalledContactInteractor): (CallView) -> Unit {
    return { view ->
        interactor.load()
    }
}

fun bind(interactor: AddContactToFavouritesInteractor): (ContactView)  -> Unit {
    return { view ->
        view.followButton.setOnClickListener { interactor.addToContacts() }
    }
}


fun bind(interactor: LoadLastSeenInteractor): (LastSeenView) -> Unit {
    return { view ->
        interactor.load()
    }
}

fun bind(interactor: CallContactInteractor): (ContactView) -> Unit {
    return { view ->
        view.phoneTextView.setOnClickListener { interactor.call() }
    }
}
