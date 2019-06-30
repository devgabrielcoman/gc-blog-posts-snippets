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

fun bind(id: String, interactor: LoadFullContactInteractor): (ContactView) -> Unit {
    return {
        interactor.load(id = id)
    }
}

fun bind(id: String, interactor: LoadCalledContactInteractor): (CallView) -> Unit {
    return {
        interactor.load(id = id)
    }
}

fun bind(id: String, interactor: AddContactToFavouritesInteractor): (ContactView) -> Unit {
    return {
        it.followButton.setOnClickListener { interactor.addToContacts(id = id) }
    }
}

fun bind(id: String, interactor: CallContactInteractor): (ContactView) -> Unit {
    return {
        it.phoneTextView.setOnClickListener { interactor.call(id = id, context = it.context) }
    }
}

fun bind(id: String): (LoadContactInteractor) -> (ContactView) -> Unit {
    return { interactor ->
        { view ->
            interactor.load(id = id)
        }
    }
}

