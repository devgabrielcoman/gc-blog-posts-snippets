package dev.gabriel.coman.example.adaptors

import android.view.View
import com.bumptech.glide.Glide
import dev.gabriel.coman.example.state.ContactViewState
import dev.gabriel.coman.example.state.LastSeenViewState
import dev.gabriel.coman.example.state.MainScreenViewState
import dev.gabriel.coman.example.state.SimpleContactViewState
import dev.gabriel.coman.example.views.ExampleView
import dev.gabriel.coman.example.views.LastSeenView
import dev.gabriel.coman.example.views.MainScreen

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

fun redraw(lastSeenViewState: LastSeenViewState): (LastSeenView) -> Unit {
    return { view ->
        view.lastSeenTextView.text = lastSeenViewState.lastSeenText
    }
}

fun redraw(mainScreenViewState: MainScreenViewState): (MainScreen) -> Unit {
    return { view ->
        val contactRedraw = redraw(contactViewState = mainScreenViewState.contactViewState)
        val lastSeenRedraw = redraw(lastSeenViewState = mainScreenViewState.lastSeenViewState)
        contactRedraw(view.contactView)
        lastSeenRedraw(view.lastSeenView)
    }
}