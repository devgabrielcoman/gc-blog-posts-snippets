package dev.gabriel.coman.example.second

object DI {

    val navigator = Navigator()

    val contactRepository = ContactRepository(api = NewApi)
    val lastSeenRepository = LastSeenRepository(api = NewApi)

    val contactViewModel = ContactViewModel(repo = contactRepository)
    val callViewModel = CallViewModel(repo = contactRepository)
    val lastSeenViewModel = LastSeenViewModel(repo = lastSeenRepository)


    val newLoadFullContactInteractor = LoadFullContactInteractor(viewModel = contactViewModel)
    val newCallContactInteractor = LoadCalledContactInteractor(viewModel = callViewModel)
    val addContactToFavouritesInteractor = AddContactToFavouritesInteractor(viewModel = contactViewModel)
    val loadLastSeenInteractor = LoadLastSeenInteractor(viewModel = lastSeenViewModel)
    val callContactInteractor = CallContactInteractor(navigator = navigator)
}