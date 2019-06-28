package dev.gabriel.coman.example.adaptors

import dev.gabriel.coman.example.interactors.AddOrRemoveContactInteractor
import dev.gabriel.coman.example.interactors.CallInteractor
import dev.gabriel.coman.example.interactors.LoadContactInteractor
import dev.gabriel.coman.example.interactors.LoadLastSeenInteractor
import dev.gabriel.coman.example.views.ContactView
import dev.gabriel.coman.example.views.LastSeenView

fun bind(loadContactInteractor: LoadContactInteractor): (ContactView) -> Unit {
    return { view ->
        loadContactInteractor.load()
    }
}

fun bind(loadLastSeenInteractor: LoadLastSeenInteractor): (LastSeenView) -> Unit {
    return { view ->
        loadLastSeenInteractor.load()
    }
}

fun bind(addOrRemoveContactInteractor: AddOrRemoveContactInteractor): (ContactView) -> Unit {
    return { view ->
        view.followButton.setOnClickListener { addOrRemoveContactInteractor.addOrRemoveFromFavourites() }
    }
}

fun bind(callInteractor: CallInteractor): (ContactView) -> Unit {
    return { view ->
        view.phoneTextView.setOnClickListener { callInteractor.call(context = it.context) }
    }
}