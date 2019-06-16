package dev.gabriel.coman.example

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dev.gabriel.coman.example.adaptors.MainScreenInteractorImpl
import dev.gabriel.coman.example.adaptors.bind
import dev.gabriel.coman.example.adaptors.redraw
import dev.gabriel.coman.example.data.Api
import dev.gabriel.coman.example.viewmodels.ViewModel
import dev.gabriel.coman.example.views.MainScreenImp

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy { ViewModel(api = Api) }
    private val interactor by lazy { MainScreenInteractorImpl(viewModel = viewModel) }
    private val view by lazy { MainScreenImp(context = this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view)
        viewModel.update = { redraw(mainScreenViewState = it)(view) }
        bind(mainScreenInteractor = interactor)(view)
    }
}