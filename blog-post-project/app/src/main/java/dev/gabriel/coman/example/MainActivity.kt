package dev.gabriel.coman.example

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dev.gabriel.coman.example.examples.*

class MainActivity : AppCompatActivity() {

    private val contactView by lazy { findViewById<ExampleViewImpl>(R.id.contact_view) }

    private val viewModel = ViewModel(api = Api)

    private val interactor = ContactInteractorImpl(viewModel = viewModel)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        viewModel.onUpdate = { contact ->
            val redrawFunc = redraw(contactViewState = ContactViewStateImp(contact = contact))
            redrawFunc(contactView)
        }

        val bindFunc = bind(contactInteractor = interactor)
        bindFunc(contactView)
    }
}

class ContactInteractorImpl(private val viewModel: ViewModel): ContactInteractor {
    override fun initialDataLoad() = viewModel.getContact()
    override fun addOrRemoveFromFavourites() = viewModel.addToFavourites()
}