package dev.gabriel.coman.example.navigators

import android.content.Context
import android.content.Intent
import dev.gabriel.coman.example.CallActivity

class MainNavigator: BasicNavigator {

    override fun gotoCallScreen(context: Context) {
        val intent = Intent(context, CallActivity::class.java)
        context.startActivity(intent)
    }
}