package dev.gabriel.coman.example.adaptors

import android.content.Context
import dev.gabriel.coman.example.interactors.*
import dev.gabriel.coman.example.navigators.BasicNavigator
import dev.gabriel.coman.example.viewmodels.ViewModel

class LoadContactInteractorImpl(private val viewModel: ViewModel): LoadContactInteractor {
    override fun load() = viewModel.getContact()
}

class LoadLastSeenInteractorImpl(private val viewModel: ViewModel): LoadLastSeenInteractor {
    override fun load() = viewModel.getLastSeen()
}

class AddOrRemoveContactInteractorImpl(private val viewModel: ViewModel): AddOrRemoveContactInteractor {
    override fun addOrRemoveFromFavourites() = viewModel.addToFavourites()
}

class CallInteractorImpl(
    private val navigator: BasicNavigator
): CallInteractor {
    override fun call(context: Context) = navigator.gotoCallScreen(context = context)
}