package dev.gabriel.coman.example.adaptors

import dev.gabriel.coman.example.interactors.ContactInteractor
import dev.gabriel.coman.example.interactors.LastSeenInteractor
import dev.gabriel.coman.example.interactors.MainScreenInteractor
import dev.gabriel.coman.example.viewmodels.ViewModel

class ContactInteractorImpl(private val viewModel: ViewModel): ContactInteractor {
    override fun initialDataLoad() = viewModel.getContact()
    override fun addOrRemoveFromFavourites() = viewModel.addToFavourites()
}

class LastSeenInteractorImpl(private val viewModel: ViewModel): LastSeenInteractor {
    override fun initialDataLoad() = viewModel.getLastSeen()
}

class MainScreenInteractorImpl(viewModel: ViewModel): MainScreenInteractor {
    override val contactInteractor: ContactInteractor = ContactInteractorImpl(viewModel = viewModel)
    override val lastSeenInteractor: LastSeenInteractor = LastSeenInteractorImpl(viewModel = viewModel)
}