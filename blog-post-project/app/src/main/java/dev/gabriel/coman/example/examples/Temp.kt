package dev.gabriel.coman.example.examples

import android.net.Uri
import android.view.View
import com.bumptech.glide.Glide

interface ContactViewState {
    val nameText: String
    val phoneNumberText: String
    val iconUri: Uri?
    val isFollowButtonSelected: Boolean
    val followButtonTitle: String
}

interface SimpleContactViewState {
    val nameText: String
    val phoneNumberText: String
}

fun redraw(contactViewState: ContactViewState): (ExampleView) -> Unit {
    return { view ->
        view.nameTextView.text = contactViewState.nameText
        view.phoneTextView.text = contactViewState.phoneNumberText
        view.followButton.isSelected = contactViewState.isFollowButtonSelected
        view.followButton.text = contactViewState.followButtonTitle
        Glide.with(view.iconImageView.context).load(contactViewState.iconUri).into(view.iconImageView)
    }
}

fun redraw(simpleContactViewState: SimpleContactViewState): (ExampleView) -> Unit {
    return { view ->
        view.nameTextView.text = simpleContactViewState.nameText
        view.phoneTextView.text = simpleContactViewState.phoneNumberText
        view.followButton.visibility = View.GONE
        view.iconImageView.visibility = View.GONE
    }
}

interface ContactInteractor {
    fun initialDataLoad()
    fun addOrRemoveFromFavourites()
}

interface SimpleContactInteractor {
    fun initialDataLoad()
    fun callContact()
}

fun bind(contactInteractor: ContactInteractor): (ExampleView) -> Unit {
    return { view ->
        view.followButton.setOnClickListener { contactInteractor.addOrRemoveFromFavourites() }
        contactInteractor.initialDataLoad()
    }
}

fun bind(simpleContactInteractor: SimpleContactInteractor): (ExampleView) -> Unit {
    return { view ->
        view.phoneTextView.setOnClickListener { simpleContactInteractor.callContact() }
        simpleContactInteractor.initialDataLoad()
    }
}
