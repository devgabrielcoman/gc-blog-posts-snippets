package dev.gabriel.coman.example.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import android.widget.TextView
import dev.gabriel.coman.example.R

class CallViewImp
@JvmOverloads
constructor(context: Context?, attrs: AttributeSet? = null): RelativeLayout(context, attrs), CallView {
    override val callingView: TextView by lazy {
        findViewById<TextView>(R.id.calling_text_view)
    }

    init {
        LayoutInflater.from(context).inflate(R.layout.activity_call, this, true)
    }
}