package dev.gabriel.coman.example.interactors

interface ContactInteractor {
    fun initialDataLoad()
    fun addOrRemoveFromFavourites()
}

interface SimpleContactInteractor {
    fun initialDataLoad()
    fun callContact()
}

interface LastSeenInteractor {
    fun initialDataLoad()
}

interface MainScreenInteractor {
    val contactInteractor: ContactInteractor
    val lastSeenInteractor: LastSeenInteractor
}