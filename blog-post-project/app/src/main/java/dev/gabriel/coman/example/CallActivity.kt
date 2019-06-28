package dev.gabriel.coman.example

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dev.gabriel.coman.example.views.CallScreenImp

class CallActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(CallScreenImp(this))
    }
}