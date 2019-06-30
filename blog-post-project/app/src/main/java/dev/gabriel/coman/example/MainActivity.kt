package dev.gabriel.coman.example

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dev.gabriel.coman.example.second.DI
import dev.gabriel.coman.example.second.bind
import dev.gabriel.coman.example.second.redraw
import dev.gabriel.coman.example.views.ContactViewImpl

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ConnectedContactView(context = this, id = "user-id"))
    }
}

fun ConnectedContactView(context: Context, id: String): ContactViewImpl =
        ContactViewImpl(context = context)
            .apply {
                DI.contactViewModel.callback = { viewState ->
                    redraw(contactViewState = viewState)(this)
                }
            }
            .apply {
                bind(id = id, interactor = DI.loadFullContactInteractor)(this)
                bind(id = id, interactor = DI.addContactToFavouritesInteractor)(this)
                bind(id = id, interactor = DI.callContactInteractor)(this)
            }