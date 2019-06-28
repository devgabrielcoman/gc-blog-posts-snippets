package dev.gabriel.coman.example.interactors

import android.content.Context

interface LoadContactInteractor {
    fun load()
}

interface LoadLastSeenInteractor {
    fun load()
}

interface AddOrRemoveContactInteractor {
    fun addOrRemoveFromFavourites()
}

interface CallInteractor {
    fun call(context: Context)
}
