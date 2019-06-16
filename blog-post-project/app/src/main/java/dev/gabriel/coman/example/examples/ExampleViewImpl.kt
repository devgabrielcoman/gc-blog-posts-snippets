package dev.gabriel.coman.example.examples

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import dev.gabriel.coman.example.R

class ExampleViewImpl
@JvmOverloads
constructor(context: Context?, attrs: AttributeSet? = null): RelativeLayout(context, attrs), ExampleView {

    override val nameTextView by lazy { findViewById<TextView>(R.id.contact_user_name) }
    override val phoneTextView by lazy { findViewById<TextView>(R.id.contact_phone_number) }
    override val iconImageView by lazy { findViewById<ImageView>(R.id.contact_image_icon) }
    override val followButton by lazy { findViewById<Button>(R.id.contact_follow_button) }

    init {
        LayoutInflater.from(context).inflate(R.layout.view_contact, this, true)
    }
}