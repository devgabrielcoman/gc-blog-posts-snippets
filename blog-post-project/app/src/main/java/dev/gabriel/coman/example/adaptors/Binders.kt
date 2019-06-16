package dev.gabriel.coman.example.adaptors

import dev.gabriel.coman.example.interactors.ContactInteractor
import dev.gabriel.coman.example.interactors.LastSeenInteractor
import dev.gabriel.coman.example.interactors.MainScreenInteractor
import dev.gabriel.coman.example.interactors.SimpleContactInteractor
import dev.gabriel.coman.example.views.ExampleView
import dev.gabriel.coman.example.views.LastSeenView
import dev.gabriel.coman.example.views.MainScreen

fun bind(contactInteractor: ContactInteractor): (ExampleView) -> Unit {
    return { view ->
        view.followButton.setOnClickListener { contactInteractor.addOrRemoveFromFavourites() }
        contactInteractor.initialDataLoad()
    }
}

fun bind(simpleContactInteractor: SimpleContactInteractor): (ExampleView) -> Unit {
    return { view ->
        view.phoneTextView.setOnClickListener { simpleContactInteractor.callContact() }
        simpleContactInteractor.initialDataLoad()
    }
}

fun bind(lastSeenInteractor: LastSeenInteractor): (LastSeenView) -> Unit {
    return { view ->
        lastSeenInteractor.initialDataLoad()
    }
}

fun bind(mainScreenInteractor: MainScreenInteractor): (MainScreen) -> Unit {
    return { view ->
        val bindContact = bind(contactInteractor = mainScreenInteractor.contactInteractor)
        val bindLastSeen = bind(lastSeenInteractor = mainScreenInteractor.lastSeenInteractor)
        bindContact(view.contactView)
        bindLastSeen(view.lastSeenView)
    }
}