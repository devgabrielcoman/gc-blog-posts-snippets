package dev.gabriel.coman.example

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dev.gabriel.coman.example.second.*
import dev.gabriel.coman.example.views.ContactViewImpl

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ContactComponent(context = this, id = "user-id"))
    }
}

fun ContactComponent(context: Context, id: String): ContactViewImpl =
        ContactViewImpl(context = context)
            .apply {
                DI.contactViewModel.callback = {
                    redraw(contactViewState = it)(this)
                }
            }
            .apply {
                bind(interactor = DI.newLoadFullContactInteractor(id))(this)
                bind(interactor = DI.addContactToFavouritesInteractor(id))(this)
                bind(interactor = DI.callContactInteractor(id, context))(this)
            }