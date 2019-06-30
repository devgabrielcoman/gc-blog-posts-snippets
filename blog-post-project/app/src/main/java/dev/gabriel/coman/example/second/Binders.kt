package dev.gabriel.coman.example.second

import dev.gabriel.coman.example.views.CallView
import dev.gabriel.coman.example.views.ContactView

fun bind(id: String, interactor: LoadFullContactInteractor): (ContactView) -> Unit {
    return {
        interactor.load(id = id)
    }
}

fun bind(id: String, interactor: LoadCalledContactInteractor): (CallView) -> Unit {
    return {
        interactor.load(id = id)
    }
}

fun bind(id: String, interactor: AddContactToFavouritesInteractor): (ContactView) -> Unit {
    return {
        it.followButton.setOnClickListener { interactor.addToContacts(id = id) }
    }
}

fun bind(id: String, interactor: CallContactInteractor): (ContactView) -> Unit {
    return {
        it.phoneTextView.setOnClickListener { interactor.call(id = id, context = it.context) }
    }
}

fun bind(id: String): (LoadContactInteractor) -> (ContactView) -> Unit {
    return { interactor ->
        { view ->
            interactor.load(id = id)
        }
    }
}