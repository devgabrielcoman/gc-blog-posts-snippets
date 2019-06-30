package dev.gabriel.coman.example

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dev.gabriel.coman.example.second.*
import dev.gabriel.coman.example.views.CallViewImp

class CallActivity: AppCompatActivity() {

    private val userId by lazy {
        intent.extras["user-id"] as String
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(CallComponent(context = this, id = userId))
    }
}

fun CallComponent(context: Context, id: String): CallViewImp =
        CallViewImp(context = context)
            .apply {
                DI.callViewModel.callback = {
                    redraw(callViewState = it)(this)
                }
            }
            .apply {
                bind(interactor = DI.newCallContactInteractor(id))(this)
            }