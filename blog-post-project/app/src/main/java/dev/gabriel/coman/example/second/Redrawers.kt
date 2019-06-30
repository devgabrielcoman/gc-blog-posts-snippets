package dev.gabriel.coman.example.second

import com.bumptech.glide.Glide
import dev.gabriel.coman.example.views.CallView
import dev.gabriel.coman.example.views.ContactView
import dev.gabriel.coman.example.views.LastSeenView

fun redraw(contactViewState: ContactViewState): (ContactView) -> Unit {
    return { view ->
        view.nameTextView.text = contactViewState.nameText
        view.phoneTextView.text = contactViewState.phoneNumberText
        view.followButton.isSelected = contactViewState.isFollowButtonSelected
        view.followButton.text = contactViewState.followButtonTitle
        Glide.with(view.iconImageView.context).load(contactViewState.iconUri).into(view.iconImageView)
    }
}

fun redraw(lastSeenViewState: LastSeenViewState): (LastSeenView) -> Unit {
    return { view ->
        view.lastSeenTextView.text = lastSeenViewState.lastSeenText
    }
}

fun redraw(callViewState: CallViewState): (CallView) -> Unit {
    return { view ->
        view.callingView.text = callViewState.callingText
    }
}

