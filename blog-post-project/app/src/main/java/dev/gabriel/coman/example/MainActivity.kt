package dev.gabriel.coman.example

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dev.gabriel.coman.example.adaptors.*
import dev.gabriel.coman.example.data.Api
import dev.gabriel.coman.example.navigators.BasicNavigator
import dev.gabriel.coman.example.navigators.MainNavigator
import dev.gabriel.coman.example.viewmodels.ViewModel
import dev.gabriel.coman.example.views.MainScreenImp

object DI {
    val viewModel = ViewModel(api = Api)
    val navigator: BasicNavigator = MainNavigator()

    val loadContactInteractor = LoadContactInteractorImpl(viewModel = viewModel)
    val loadLastSeenInteractor = LoadLastSeenInteractorImpl(viewModel = viewModel)
    val addOrRemoveContactInteractor = AddOrRemoveContactInteractorImpl(viewModel = viewModel)
    val callInteractor = CallInteractorImpl(navigator = navigator)
}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ConnectedMainScreen(this))
    }
}

fun ConnectedMainScreen(context: Context): MainScreenImp =
    MainScreenImp(context = context)
        .apply {
            DI.viewModel.update = { state ->
                redraw(contactViewState = state.contactViewState)(this.contactView)
                redraw(lastSeenViewState = state.lastSeenViewState)(this.lastSeenView)
            }
        }
        .apply {
            bind(loadContactInteractor = DI.loadContactInteractor)(this.contactView)
            bind(loadLastSeenInteractor = DI.loadLastSeenInteractor)(this.lastSeenView)
            bind(addOrRemoveContactInteractor = DI.addOrRemoveContactInteractor)(this.contactView)
            bind(callInteractor = DI.callInteractor)(this.contactView)
        }