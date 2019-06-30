package dev.gabriel.coman.example.second

object DI {

    val navigator = Navigator()

    val contactRepository = ContactRepository(api = NewApi)
    val lastSeenRepository = LastSeenRepository(api = NewApi)

    val contactViewModel = ContactViewModel(repo = contactRepository)
    val callViewModel = CallViewModel(repo = contactRepository)
    val lastSeenViewModel = LastSeenViewModel(repo = lastSeenRepository)

    val loadFullContactInteractor = LoadFullContactInteractor(viewModel = contactViewModel)
    val loadCallContactInteractor = LoadCalledContactInteractor(viewModel = callViewModel)
    val addContactToFavouritesInteractor = AddContactToFavouritesInteractorImpl(viewModel = contactViewModel)
    val loadLastSeenInteractor = LoadLastSeenInteractorImpl(viewModel = lastSeenViewModel)
    val callContactInteractor = CallContactInteractorImpl(navigator = navigator)
}