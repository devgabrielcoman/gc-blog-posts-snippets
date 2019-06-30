package dev.gabriel.coman.example.second

import android.content.Context
import android.content.Intent
import dev.gabriel.coman.example.CallActivity

interface AppNavigator {
    fun call(context: Context, id: String)
}

class Navigator: AppNavigator {
    override fun call(context: Context, id: String) {
        val intent = Intent(context, CallActivity::class.java)
        intent.putExtra("user-id", id)
        context.startActivity(intent)
    }
}