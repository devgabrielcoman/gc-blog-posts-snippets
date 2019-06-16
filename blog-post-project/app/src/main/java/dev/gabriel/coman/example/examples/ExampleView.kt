package dev.gabriel.coman.example.examples

import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

interface ExampleView {
    val nameTextView: TextView
    val phoneTextView: TextView
    val iconImageView: ImageView
    val followButton: Button
}