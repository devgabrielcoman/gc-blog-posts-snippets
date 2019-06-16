package dev.gabriel.coman.example.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import dev.gabriel.coman.example.R

class MainScreenImp
@JvmOverloads
constructor(context: Context?, attrs: AttributeSet? = null): RelativeLayout(context, attrs), MainScreen {

    override val contactView: ExampleView by lazy { findViewById<ExampleViewImpl>(R.id.contact_view) }
    override val lastSeenView: LastSeenView by lazy { findViewById<LastSeenViewImpl>(R.id.last_seen_view) }

    init {
        LayoutInflater.from(context).inflate(R.layout.activity_main, this, true)
    }
}