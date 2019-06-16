package dev.gabriel.coman.example.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import android.widget.TextView
import dev.gabriel.coman.example.R

class LastSeenViewImpl
@JvmOverloads
constructor(context: Context?, attrs: AttributeSet? = null): RelativeLayout(context, attrs), LastSeenView {

    override val lastSeenTextView by lazy { findViewById<TextView>(R.id.last_seen_date) }

    init {
        LayoutInflater.from(context).inflate(R.layout.view_last_seen, this, true)
    }
}